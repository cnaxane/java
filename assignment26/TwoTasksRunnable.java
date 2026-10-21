/**
 * Assignment 26 - Exercise 1
 * Problem Statement: Create a program using Runnable to run two tasks simultaneously.
 */

class EvenNumberTask implements Runnable {
    private int limit;

    public EvenNumberTask(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        System.out.println("[Task-Even] Started execution by: " + Thread.currentThread().getName());
        for (int i = 2; i <= limit; i += 2) {
            System.out.println("[Task-Even] Even Number: " + i);
            try {
                Thread.sleep(400); // simulate task processing delay
            } catch (InterruptedException e) {
                System.out.println("[Task-Even] Interrupted: " + e.getMessage());
            }
        }
        System.out.println("[Task-Even] Completed execution.");
    }
}

class SquareNumberTask implements Runnable {
    private int count;

    public SquareNumberTask(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("[Task-Square] Started execution by: " + Thread.currentThread().getName());
        for (int i = 1; i <= count; i++) {
            System.out.println("[Task-Square] Square of " + i + " = " + (i * i));
            try {
                Thread.sleep(350); // simulate task processing delay
            } catch (InterruptedException e) {
                System.out.println("[Task-Square] Interrupted: " + e.getMessage());
            }
        }
        System.out.println("[Task-Square] Completed execution.");
    }
}

public class TwoTasksRunnable {
    public static void main(String[] args) {
        System.out.println("=== Assignment 26: Running Two Tasks Simultaneously using Runnable ===");

        // Instantiate Runnable tasks
        EvenNumberTask evenTask = new EvenNumberTask(10);
        SquareNumberTask squareTask = new SquareNumberTask(5);

        // Pass Runnable tasks to Thread instances
        Thread thread1 = new Thread(evenTask, "Worker-Even");
        Thread thread2 = new Thread(squareTask, "Worker-Square");

        // Start both threads concurrently
        System.out.println("Starting both task threads concurrently...\n");
        thread1.start();
        thread2.start();

        try {
            // Wait for both tasks to complete
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\n=== Both Runnable tasks completed successfully ===");
    }
}
