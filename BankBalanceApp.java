// import required libraries
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This app The "BankBalanceApp" is a Java Swing application that allows users to manage and monitor their bank 
 * account balances through a user-friendly graphical interface. Utilizing Swing's invokeLater(), the app ensures 
 * smooth execution of GUI-related tasks on the Event Dispatch Thread for a responsive user experience.
 */
public class BankBalanceApp extends JFrame 
{

    private double balance = 0.0; // Initial balance set to zero

    public BankBalanceApp() 
    {
        // Create a JPanel
        JPanel panel = new JPanel();

        // Create deposit button
        JButton depositButton = new JButton("Deposit");

        // Add action listener to button
        depositButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Prompt user for deposit amount
                String input = JOptionPane.showInputDialog("Enter deposit amount:");
                double depositAmount = Double.parseDouble(input);
                balance += depositAmount;
            }
        });

        // Create withdraw button
        JButton withdrawButton = new JButton("Withdraw");

        // Add action listener to button
        withdrawButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Prompt user for withdrawal amount
                String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
                double withdrawAmount = Double.parseDouble(input);
                if (withdrawAmount <= balance) 
                {
                    balance -= withdrawAmount;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Insufficient funds!");
                }
            }
        });

        // Create show balance button
        JButton showBalanceButton = new JButton("Show Balance");

        // Add action listener to button
        showBalanceButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Display the current balance
                JOptionPane.showMessageDialog(null, "Current Balance: $" + balance);
            }
        });

        // Add buttons to the JPanel
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showBalanceButton);

        // Add panel to the frame
        add(panel);

        // Set frame properties
        setTitle("Bank Balance Application");     // Set title
        setSize(333, 162);                 // set window sixe
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes app on xit
        setVisible(true);                             // Displays the frame
    }

    // Schedule the creation of a new instance of the BankBalanceApp class on the 
    //  Event Dispatch Thread (EDT) in a Java Swing application.
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new BankBalanceApp());
    }
}
