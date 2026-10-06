import java.sql.*;
import java.util.Scanner;

public class HospitalStaffLogin {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUDDB";
        String username = "root";
        String password = "chaitanya";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        String query = "SELECT role FROM HospitalStaff WHERE login_id = ? AND password = ?";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, loginId);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                System.out.println("Authentication Successful.");

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Access Granted: Doctor.");
                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Access Granted: Nurse.");
                } else {
                    System.out.println("Access Granted: Hospital Staff.");
                }
            } else {
                System.out.println("Authentication Failed.");
                System.out.println("Invalid Login ID or Password.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}