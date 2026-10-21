/**
 * Assignment 25 - Exercise 2
 * Problem Statement: Create a Java program using multiple threads to simulate bank transactions.
 * One thread performs deposit operations, and another performs withdrawal operations,
 * both printing transaction details simultaneously.
 */

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount, String threadName) {
        System.out.printf("[%s] Attempting to DEPOSIT: $%.2f | Balance before: $%.2f%n", threadName, amount, balance);
        balance += amount;
        System.out.printf("[%s] Successfully DEPOSITED: $%.2f | Updated Balance: $%.2f%n%n", threadName, amount, balance);
    }

    public synchronized void withdraw(double amount, String threadName) {
        System.out.printf("[%s] Attempting to WITHDRAW: $%.2f | Balance before: $%.2f%n", threadName, amount, balance);
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("[%s] Successfully WITHDREW: $%.2f | Updated Balance: $%.2f%n%n", threadName, amount, balance);
        } else {
            System.out.printf("[%s] INSUFFICIENT FUNDS! Cannot withdraw $%.2f | Current Balance: $%.2f%n%n", threadName, amount, balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private double[] depositAmounts;

    public DepositThread(String name, BankAccount account, double[] amounts) {
        super(name);
        this.account = account;
        this.depositAmounts = amounts;
    }

    @Override
    public void run() {
        for (double amount : depositAmounts) {
            account.deposit(amount, getName());
            try {
                Thread.sleep(500); // simulate transaction delay
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted: " + e.getMessage());
            }
        }
        System.out.println(getName() + " completed all deposit operations.");
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    private double[] withdrawAmounts;

    public WithdrawThread(String name, BankAccount account, double[] amounts) {
        super(name);
        this.account = account;
        this.withdrawAmounts = amounts;
    }

    @Override
    public void run() {
        for (double amount : withdrawAmounts) {
            account.withdraw(amount, getName());
            try {
                Thread.sleep(600); // simulate transaction delay
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted: " + e.getMessage());
            }
        }
        System.out.println(getName() + " completed all withdrawal operations.");
    }
}

public class BankTransactionThreads {
    public static void main(String[] args) {
        System.out.println("=== Assignment 25: Multithreaded Bank Transaction Simulation ===");

        BankAccount account = new BankAccount("ACC-987654321", 1000.00);
        System.out.printf("Account: %s | Starting Balance: $%.2f%n%n", account.getAccountNumber(), account.getBalance());

        double[] deposits = { 200.0, 500.0, 300.0, 150.0 };
        double[] withdrawals = { 400.0, 700.0, 600.0, 200.0 };

        DepositThread depositThread = new DepositThread("Deposit-Thread", account, deposits);
        WithdrawThread withdrawThread = new WithdrawThread("Withdrawal-Thread", account, withdrawals);

        System.out.println("Starting concurrent Deposit and Withdrawal threads...\n");
        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.printf("%n=== All Transactions Finished | Final Account Balance: $%.2f ===%n", account.getBalance());
    }
}
