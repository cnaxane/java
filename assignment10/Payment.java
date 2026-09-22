package assignment10;

abstract class PaymentMethod {
    double amount;

    PaymentMethod(double amount) {
        this.amount = amount;
    }

    abstract void pay();
}

class CreditCard extends PaymentMethod {

    CreditCard(double amount) {
        super(amount);
    }

    void pay() {
        System.out.println("Credit Card Payment");
        System.out.println("Amount: " + amount);
        System.out.println("Payment Successful");
    }
}

class UPI extends PaymentMethod {

    UPI(double amount) {
        super(amount);
    }

    void pay() {
        System.out.println("UPI Payment");
        System.out.println("Amount: " + amount);
        System.out.println("Payment Successful");
    }
}

public class Payment {
    public static void main(String[] args) {
        CreditCard card = new CreditCard(5000);
        UPI upi = new UPI(2000);

        card.pay();
        System.out.println();

        upi.pay();
    }
}