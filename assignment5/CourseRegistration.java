package assignment5;


import java.util.ArrayList;
import java.util.Scanner;

class CourseRegistration {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Courses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter course name: ");
                String course = sc.nextLine();
                courses.add(course);
                System.out.println("Course added.");
            }
            else if (choice == 2) {
                System.out.print("Enter course name to remove: ");
                String course = sc.nextLine();

                if (courses.remove(course))
                    System.out.println("Course removed.");
                else
                    System.out.println("Course not found.");
            }
            else if (choice == 3) {
                StringBuffer result = new StringBuffer();

                for (String course : courses) {
                    result.append(course).append("\n");
                }

                System.out.println("\nRegistered Courses:");
                System.out.println(result);
            }
            else if (choice == 4) {
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}


