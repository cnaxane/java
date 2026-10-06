import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class BookIssueTracking extends JFrame {

    JTextField bookIdField, studentField, issueDateField, returnDateField;
    JButton addButton, viewButton, deleteButton;

    String url = "jdbc:mysql://localhost:3306/CRUDDB";
    String username = "root";
    String password = "chaitanya";

    BookIssueTracking() {
        setTitle("Book Issue Tracking System");
        setSize(500, 400);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        add(bookIdField);

        add(new JLabel("Student Name:"));
        studentField = new JTextField();
        add(studentField);

        add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueDateField = new JTextField();
        add(issueDateField);

        add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnDateField = new JTextField();
        add(returnDateField);

        addButton = new JButton("Issue Book");
        viewButton = new JButton("View Records");
        deleteButton = new JButton("Delete Record");

        add(addButton);
        add(viewButton);
        add(deleteButton);

        addButton.addActionListener(e -> addRecord());
        viewButton.addActionListener(e -> viewRecords());
        deleteButton.addActionListener(e -> deleteRecord());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void addRecord() {
        String query = "INSERT INTO BookIssue VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(bookIdField.getText()));
            ps.setString(2, studentField.getText());
            ps.setDate(3, Date.valueOf(issueDateField.getText()));
            ps.setDate(4, Date.valueOf(returnDateField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book issue record added successfully.");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void viewRecords() {
        String query = "SELECT * FROM BookIssue";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            StringBuilder data = new StringBuilder();

            while (rs.next()) {
                data.append("Book ID: ").append(rs.getInt("BookID")).append("\n");
                data.append("Student Name: ").append(rs.getString("StudentName")).append("\n");
                data.append("Issue Date: ").append(rs.getDate("IssueDate")).append("\n");
                data.append("Return Date: ").append(rs.getDate("ReturnDate")).append("\n");
                data.append("----------------------\n");
            }

            JOptionPane.showMessageDialog(this, data.toString());

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void deleteRecord() {
        String query = "DELETE FROM BookIssue WHERE BookID = ?";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(bookIdField.getText()));
            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new BookIssueTracking();
    }
}