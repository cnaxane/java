/**
 * Assignment 25 - Exercise 1
 * Problem Statement: Create a program where multiple threads print numbers simultaneously
 * and demonstrate their lifecycle.
 */

class NumberPrinterThread extends Thread {
    private int start;
    private int end;

    public NumberPrinterThread(String threadName, int start, int end) {
        super(threadName);
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(getName() + " entered RUNNING state (Thread State: " + getState() + ")");
        for (int i = start; i <= end; i++) {
            System.out.println(getName() + " printed: " + i);
            try {
                // Sleep briefly to demonstrate TIMED_WAITING and enable interleaved concurrent execution
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted: " + e.getMessage());
            }
        }
        System.out.println(getName() + " finished execution.");
    }
}

public class NumberPrintingThreads {
    public static void main(String[] args) {
        System.out.println("=== Assignment 25: Multiple Threads Printing Simultaneously ===");

        // Create threads (NEW state)
        NumberPrinterThread t1 = new NumberPrinterThread("Thread-Alpha", 1, 5);
        NumberPrinterThread t2 = new NumberPrinterThread("Thread-Beta", 10, 15);
        NumberPrinterThread t3 = new NumberPrinterThread("Thread-Gamma", 100, 105);

        // Display lifecycle: NEW
        System.out.println("Lifecycle State before start():");
        System.out.println(t1.getName() + " State: " + t1.getState());
        System.out.println(t2.getName() + " State: " + t2.getState());
        System.out.println(t3.getName() + " State: " + t3.getState());

        // Start threads (transitions to RUNNABLE)
        System.out.println("\nStarting threads...");
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Lifecycle State immediately after start():");
        System.out.println(t1.getName() + " State: " + t1.getState());

        try {
            // Main thread observes them while sleeping (TIMED_WAITING state)
            Thread.sleep(150);
            System.out.println("Lifecycle State while running/sleeping: " + t1.getName() + " State: " + t1.getState());

            // Wait for threads to terminate
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        // Display lifecycle: TERMINATED
        System.out.println("\nLifecycle State after completion:");
        System.out.println(t1.getName() + " State: " + t1.getState());
        System.out.println(t2.getName() + " State: " + t2.getState());
        System.out.println(t3.getName() + " State: " + t3.getState());
        System.out.println("=== All threads completed successfully ===");
    }
}
