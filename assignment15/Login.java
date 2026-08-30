package assignment15;

import java.util.Scanner;

public class Login {
    static void checkPassword(String password) throws Exception {
        if (!password.equals("12345")) {
            throw new Exception("Invalid Password");
        }
        System.out.println("Login Successful");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            checkPassword(password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Login process completed.");
        }

        sc.close();
    }
}