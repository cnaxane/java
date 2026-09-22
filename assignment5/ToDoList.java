package assignment5;

import java.util.ArrayList;
import java.util.Scanner;

class TodoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of tasks: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter task: ");
                tasks.add(sc.nextLine());
            }
        }

        StringBuffer result = new StringBuffer();

        for (String task : tasks) {
            result.append(task).append("\n");
        }

        System.out.println("\nTo-Do List:");
        System.out.println(result);
    }
}


