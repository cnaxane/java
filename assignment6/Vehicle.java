package assignment6;

interface VehicleAction {
    void action();
}

public class Vehicle {
    String vehicleName;
    String model;
    int year;

    Vehicle(String vehicleName, String model, int year) {
        this.vehicleName = vehicleName;
        this.model = model;
        this.year = year;
    }

    class VehicleDetails {
        void display() {
            System.out.println("Vehicle Name: " + vehicleName);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
        }
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("Toyota", "Camry", 2024);

        Vehicle.VehicleDetails details = v.new VehicleDetails();
        details.display();

        VehicleAction action = new VehicleAction() {
            public void action() {
                System.out.println("Vehicle is starting.");
            }
        };

        action.action();
    }
}