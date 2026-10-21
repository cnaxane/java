/**
 * Assignment 26 - Exercise 2
 * Problem Statement: Create a Java program using the Runnable interface where two tasks run simultaneously:
 * one thread performs deposit operations, and another performs withdrawal operations, both displaying results concurrently.
 */

class SharedBankAccount {
    private String accountNumber;
    private double balance;

    public SharedBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        String threadName = Thread.currentThread().getName();
        System.out.printf("[%s] >>> Initiating DEPOSIT of $%.2f | Current Balance: $%.2f%n", threadName, amount, balance);
        balance += amount;
        System.out.printf("[%s] <<< DEPOSIT COMPLETED of $%.2f | New Balance: $%.2f%n%n", threadName, amount, balance);
    }

    public synchronized void withdraw(double amount) {
        String threadName = Thread.currentThread().getName();
        System.out.printf("[%s] >>> Initiating WITHDRAWAL of $%.2f | Current Balance: $%.2f%n", threadName, amount, balance);
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("[%s] <<< WITHDRAWAL COMPLETED of $%.2f | New Balance: $%.2f%n%n", threadName, amount, balance);
        } else {
            System.out.printf("[%s] !!! WITHDRAWAL FAILED: Insufficient funds for $%.2f | Balance: $%.2f%n%n", threadName, amount, balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class DepositRunnableTask implements Runnable {
    private SharedBankAccount account;
    private double[] amounts;

    public DepositRunnableTask(SharedBankAccount account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.deposit(amt);
            try {
                Thread.sleep(450); // delay between deposit operations
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted: " + e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " completed all deposits.");
    }
}

class WithdrawRunnableTask implements Runnable {
    private SharedBankAccount account;
    private double[] amounts;

    public WithdrawRunnableTask(SharedBankAccount account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.withdraw(amt);
            try {
                Thread.sleep(550); // delay between withdrawal operations
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted: " + e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " completed all withdrawals.");
    }
}

public class BankTransactionRunnable {
    public static void main(String[] args) {
        System.out.println("=== Assignment 26: Concurrent Bank Transactions using Runnable ===");

        SharedBankAccount account = new SharedBankAccount("SB-77123400", 1500.00);
        System.out.printf("Account: %s | Initial Balance: $%.2f%n%n", account.getAccountNumber(), account.getBalance());

        double[] deposits = { 300.0, 450.0, 250.0, 500.0 };
        double[] withdrawals = { 600.0, 800.0, 700.0, 400.0 };

        DepositRunnableTask depositTask = new DepositRunnableTask(account, deposits);
        WithdrawRunnableTask withdrawTask = new WithdrawRunnableTask(account, withdrawals);

        Thread depositWorker = new Thread(depositTask, "Deposit-Worker");
        Thread withdrawWorker = new Thread(withdrawTask, "Withdraw-Worker");

        System.out.println("Starting concurrent Deposit-Worker and Withdraw-Worker threads...\n");
        depositWorker.start();
        withdrawWorker.start();

        try {
            depositWorker.join();
            withdrawWorker.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.printf("%n=== All Transactions Completed | Final Account Balance: $%.2f ===%n", account.getBalance());
    }
}
