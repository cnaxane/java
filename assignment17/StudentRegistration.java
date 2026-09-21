package assignment17;

import javax.swing.*;
import java.awt.*;

public class StudentRegistration {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");

        JLabel nameLabel = new JLabel("Name:");
        JLabel rollLabel = new JLabel("Roll No:");
        JLabel courseLabel = new JLabel("Course:");
        JLabel ageLabel = new JLabel("Age:");

        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField ageField = new JTextField();

        JButton submitButton = new JButton("Submit");

        frame.setLayout(new GridLayout(5, 2, 10, 10));

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(rollLabel);
        frame.add(rollField);

        frame.add(courseLabel);
        frame.add(courseField);

        frame.add(ageLabel);
        frame.add(ageField);

        frame.add(new JLabel());
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String roll = rollField.getText();
            String course = courseField.getText();
            String age = ageField.getText();

            JOptionPane.showMessageDialog(frame,
                    "Student Details\n\n" +
                    "Name: " + name +
                    "\nRoll No: " + roll +
                    "\nCourse: " + course +
                    "\nAge: " + age);
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}