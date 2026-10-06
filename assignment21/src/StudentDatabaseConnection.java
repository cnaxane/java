import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDatabaseConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUDDB";
        String username = "root";
        String password = "chaitanya";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connection Status: Connected");
            System.out.println("Student database is connected successfully.");

            con.close();
        } catch (Exception e) {
            System.out.println("Database Connection Status: Not Connected");
            System.out.println("Error: " + e.getMessage());
        }
    }
}