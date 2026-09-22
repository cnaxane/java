package assignment9;

class Account {
    final int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Account account = new Account(101, "Chaitanya", 50000);

        account.display();
    }
}
