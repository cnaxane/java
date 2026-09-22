package assignment8;

class Vehicle {
    String vehicleNumber;
    String vehicleModel;

    Vehicle(String vehicleNumber, String vehicleModel) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
    }

    void displayVehicle() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Model: " + vehicleModel);
    }
}

class CarInsurance extends Vehicle {
    double premium;

    CarInsurance(String vehicleNumber, String vehicleModel, double premium) {
        super(vehicleNumber, vehicleModel);
        this.premium = premium;
    }

    void displayInsurance() {
        super.displayVehicle();
        System.out.println("Car Insurance Premium: " + premium);
    }
}

class BikeInsurance extends Vehicle {
    double premium;

    BikeInsurance(String vehicleNumber, String vehicleModel, double premium) {
        super(vehicleNumber, vehicleModel);
        this.premium = premium;
    }

    void displayInsurance() {
        super.displayVehicle();
        System.out.println("Bike Insurance Premium: " + premium);
    }
}

public class VehicleInsurance {
    public static void main(String[] args) {
        CarInsurance car = new CarInsurance("MH12AB1234", "Toyota", 15000);
        BikeInsurance bike = new BikeInsurance("MH14XY5678", "Honda", 8000);

        System.out.println("Car Insurance");
        car.displayInsurance();

        System.out.println();

        System.out.println("Bike Insurance");
        bike.displayInsurance();
    }
}