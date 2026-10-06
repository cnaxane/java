import java.sql.*;

public class DisplayRecords {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUDDB";
        String username = "root";
        String password = "chaitanya";

        String query = "SELECT * FROM Employee";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Database Records:");

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("EmployeeID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Department: " + rs.getString("Department"));
                System.out.println("Salary: " + rs.getDouble("Salary"));
                System.out.println("----------------------");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}