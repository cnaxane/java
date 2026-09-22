package assignment6;

interface DeliveryStatus {
    void updateStatus();
}

public class FoodDelivery {
    String customerName;
    String foodName;
    double price;

    FoodDelivery(String customerName, String foodName, double price) {
        this.customerName = customerName;
        this.foodName = foodName;
        this.price = price;
    }

    class OrderDetails {
        void display() {
            System.out.println("Customer Name: " + customerName);
            System.out.println("Food: " + foodName);
            System.out.println("Price: " + price);
        }
    }

    public static void main(String[] args) {
        FoodDelivery order = new FoodDelivery("Chaitanya", "Pizza", 299);

        FoodDelivery.OrderDetails details = order.new OrderDetails();
        details.display();

        DeliveryStatus preparing = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Order is being prepared.");
            }
        };

        DeliveryStatus delivered = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Order has been delivered.");
            }
        };

        preparing.updateStatus();
        delivered.updateStatus();
    }
}
