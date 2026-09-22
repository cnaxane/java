package assignment10;

abstract class FoodOrderBase {
    double amount;

    FoodOrderBase(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrderBase {

    DineInOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        double tax = amount * 0.05;
        double total = amount + tax;

        System.out.println("Dine-In Order");
        System.out.println("Food Amount: " + amount);
        System.out.println("Tax: " + tax);
        System.out.println("Total Bill: " + total);
    }
}

class TakeAwayOrder extends FoodOrderBase {

    TakeAwayOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        double packingCharge = 50;
        double total = amount + packingCharge;

        System.out.println("Take-Away Order");
        System.out.println("Food Amount: " + amount);
        System.out.println("Packing Charge: " + packingCharge);
        System.out.println("Total Bill: " + total);
    }
}

public class FoodOrder {
    public static void main(String[] args) {
        DineInOrder dineIn = new DineInOrder(1000);
        TakeAwayOrder takeAway = new TakeAwayOrder(1000);

        dineIn.calculateBill();
        System.out.println();

        takeAway.calculateBill();
    }
}
