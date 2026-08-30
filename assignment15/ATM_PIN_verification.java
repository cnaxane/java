package assignment15;

import java.util.Scanner;

public class ATM_PIN_verification {
    static void verifyPIN(int pin) throws Exception {
        if (pin != 1234) {
            throw new Exception("Invalid PIN");
        }
        System.out.println("PIN Verified Successfully");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter ATM PIN: ");
            int pin = sc.nextInt();

            verifyPIN(pin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("PIN verification process completed.");
        }

        sc.close();
    }
}