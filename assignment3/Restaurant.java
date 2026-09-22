package assigment2;

class Restaurant {
    static int totalOrders = 0;

    double bill(double amount) {
        totalOrders++;
        return amount;
    }

    double bill(double amount, double takeawayCharge) {
        totalOrders++;
        return amount + takeawayCharge;
    }

    double bill(double amount, double deliveryCharge, double tax) {
        totalOrders++;
        return amount + deliveryCharge + tax;
    }

    public static void main(String[] args) {
        Restaurant r = new Restaurant();

        System.out.println("Dine-in Bill: " + r.bill(500));
        System.out.println("Takeaway Bill: " + r.bill(500, 30));
        System.out.println("Delivery Bill: " + r.bill(500, 50, 25));

        System.out.println("Total Orders: " + totalOrders);
    }
}

