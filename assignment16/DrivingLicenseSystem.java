package assignment16;

import java.util.Scanner;

class InvalidDrivingAgeException extends Exception {
    InvalidDrivingAgeException(String message) {
        super(message);
    }
}

public class DrivingLicenseSystem {
    static void checkAge(int age) throws InvalidDrivingAgeException {
        if (age < 18) {
            throw new InvalidDrivingAgeException(
                "You are not eligible for a driving license."
            );
        }
        System.out.println("You are eligible for a driving license.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkAge(age);
        } catch (InvalidDrivingAgeException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}