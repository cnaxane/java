import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUDDB";
        String username = "root";
        String password = "chaitanya";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully.");
            System.out.println("Connection Status: Connected");
            con.close();
        } catch (Exception e) {
            System.out.println("Connection Status: Not Connected");
            System.out.println("Error: " + e.getMessage());
        }
    }
}