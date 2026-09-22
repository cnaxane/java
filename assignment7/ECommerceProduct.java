package assignment7;

interface Product {
    void display();
}

abstract class ProductDetails {
    String name;
    double price;

    ProductDetails(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Electronic extends ProductDetails implements Product {
    String brand;

    Electronic(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public void display() {
        System.out.println("Electronic Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Brand: " + brand);
    }
}

class Clothing extends ProductDetails implements Product {
    String size;

    Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public void display() {
        System.out.println("Clothing Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Size: " + size);
    }
}

class Grocery extends ProductDetails implements Product {
    String expiryDate;

    Grocery(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public void display() {
        System.out.println("Grocery Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Expiry Date: " + expiryDate);
    }
}

public class ECommerceProduct {
    public static void main(String[] args) {
        Electronic e = new Electronic("Laptop", 50000, "Dell");
        Clothing c = new Clothing("T-Shirt", 999, "L");
        Grocery g = new Grocery("Milk", 60, "25-09-2026");

        e.display();
        System.out.println();

        c.display();
        System.out.println();

        g.display();
    }
}
