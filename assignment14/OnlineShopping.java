package assignment14;

import java.util.Scanner;

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero.");
            }

            System.out.println("Product quantity: " + quantity);
            System.out.println("Order placed successfully.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        finally {
            sc.close();
        }
    }
}