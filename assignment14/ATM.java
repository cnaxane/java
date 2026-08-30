package assignment14;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 10000;

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount.");
            }

            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }

            balance = balance - amount;

            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance: Rs. " + balance);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Invalid input.");
        }
        finally {
            sc.close();
        }
    }
}