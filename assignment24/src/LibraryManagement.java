import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class LibraryManagement extends JFrame {

    JTextField idField, nameField, authorField, priceField;
    JButton addButton, viewButton;

    String url = "jdbc:mysql://localhost:3306/CRUDDB";
    String username = "root";
    String password = "chaitanya";

    LibraryManagement() {
        setTitle("Library Management System");
        setSize(450, 350);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Book ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Book Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Author:"));
        authorField = new JTextField();
        add(authorField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        addButton = new JButton("Add Book");
        viewButton = new JButton("View Books");

        add(addButton);
        add(viewButton);

        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void addBook() {
        String query = "INSERT INTO Books VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, authorField.getText());
            ps.setDouble(4, Double.parseDouble(priceField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book added successfully.");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void viewBooks() {
        String query = "SELECT * FROM Books";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            StringBuilder data = new StringBuilder();

            while (rs.next()) {
                data.append("Book ID: ").append(rs.getInt("BookID")).append("\n");
                data.append("Book Name: ").append(rs.getString("BookName")).append("\n");
                data.append("Author: ").append(rs.getString("Author")).append("\n");
                data.append("Price: ").append(rs.getDouble("Price")).append("\n");
                data.append("----------------------\n");
            }

            JOptionPane.showMessageDialog(this, data.toString());

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new LibraryManagement();
    }
}