package assignment1;

class Mobile {
    String brand;
    String model;
    double price;

    Mobile() {
        brand = "Unknown";
        model = "Unknown";
        price = 0;
    }

    Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    Mobile(Mobile m) {
        this.brand = m.brand;
        this.model = m.model;
        this.price = m.price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("Samsung", "Galaxy S25", 79999);
        Mobile m3 = new Mobile(m2);

        System.out.println("Default Constructor:");
        m1.display();

        System.out.println("\nParameterized Constructor:");
        m2.display();

        System.out.println("\nDuplicate Object:");
        m3.display();
    }
}


