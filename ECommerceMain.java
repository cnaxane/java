
interface Product {
    void display();
    double getPrice();
}

class Electronic implements Product {
    String name;
    double price;

    Electronic(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Electronic: " + name);
        System.out.println("Price: " + price);
    }

    public double getPrice() {
        return price;
    }
}

class Clothing implements Product {
    String name;
    double price;

    Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Clothing: " + name);
        System.out.println("Price: " + price);
    }

    public double getPrice() {
        return price;
    }
}

class Grocery implements Product {
    String name;
    double price;

    Grocery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Grocery: " + name);
        System.out.println("Price: " + price);
    }

    public double getPrice() {
        return price;
    }
}

public class ECommerceMain {
    public static void main(String[] args) {
        Product p1 = new Electronic("Laptop", 50000);
        Product p2 = new Clothing("T-Shirt", 800);
        Product p3 = new Grocery("Rice", 1200);

        p1.display();
        p2.display();
        p3.display();
    }
}

