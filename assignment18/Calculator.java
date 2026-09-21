package assignment18;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");

        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        JLabel resultLabel = new JLabel("Result:");

        JTextField num1Field = new JTextField();
        JTextField num2Field = new JTextField();
        JTextField resultField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Subtract");

        resultField.setEditable(false);

        frame.setLayout(new GridLayout(4, 2, 10, 10));

        frame.add(num1Label);
        frame.add(num1Field);

        frame.add(num2Label);
        frame.add(num2Field);

        frame.add(resultLabel);
        frame.add(resultField);

        frame.add(addButton);
        frame.add(subButton);

        addButton.addActionListener(e -> {
            double a = Double.parseDouble(num1Field.getText());
            double b = Double.parseDouble(num2Field.getText());
            resultField.setText(String.valueOf(a + b));
        });

        subButton.addActionListener(e -> {
            double a = Double.parseDouble(num1Field.getText());
            double b = Double.parseDouble(num2Field.getText());
            resultField.setText(String.valueOf(a - b));
        });

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
