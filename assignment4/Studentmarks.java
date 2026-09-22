package assignment4;

import java.util.Scanner;

class StudentMarks {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

        System.out.print("Enter marks 1: ");
        String m1 = sc.nextLine();

        System.out.print("Enter marks 2: ");
        String m2 = sc.nextLine();

        System.out.print("Enter marks 3: ");
        String m3 = sc.nextLine();

        Integer mark1 = Integer.valueOf(m1);
        Integer mark2 = Integer.valueOf(m2);
        Integer mark3 = Integer.valueOf(m3);

        int total = mark1 + mark2 + mark3;

            System.out.println("Total Marks: " + total);
        }
    }
}

