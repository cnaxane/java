package assignment18;

import javax.swing.*;
import java.awt.*;

public class BankBalanceCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Balance Calculator");

        JLabel balanceLabel = new JLabel("Initial Balance:");
        JLabel amountLabel = new JLabel("Transaction Amount:");
        JLabel resultLabel = new JLabel("Updated Balance:");

        JTextField balanceField = new JTextField();
        JTextField amountField = new JTextField();
        JTextField resultField = new JTextField();

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        resultField.setEditable(false);

        frame.setLayout(new GridLayout(4, 2, 10, 10));

        frame.add(balanceLabel);
        frame.add(balanceField);

        frame.add(amountLabel);
        frame.add(amountField);

        frame.add(resultLabel);
        frame.add(resultField);

        frame.add(depositButton);
        frame.add(withdrawButton);

        depositButton.addActionListener(e -> {
            double balance = Double.parseDouble(balanceField.getText());
            double amount = Double.parseDouble(amountField.getText());

            double newBalance = balance + amount;

            resultField.setText(String.valueOf(newBalance));
        });

        withdrawButton.addActionListener(e -> {
            double balance = Double.parseDouble(balanceField.getText());
            double amount = Double.parseDouble(amountField.getText());

            double newBalance = balance - amount;

            resultField.setText(String.valueOf(newBalance));
        });

        frame.setSize(450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
