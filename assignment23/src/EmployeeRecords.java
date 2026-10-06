import java.sql.*;

public class EmployeeRecords {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUDDB";
        String username = "root";
        String password = "chaitanya";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "SELECT EmployeeID, Name, Department, Salary FROM Employee";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Employee Records:");

            while (rs.next()) {
                int id = rs.getInt("EmployeeID");
                String name = rs.getString("Name");
                String department = rs.getString("Department");
                double salary = rs.getDouble("Salary");

                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Department: " + department);
                System.out.println("Salary: " + salary);
                System.out.println("----------------------");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}