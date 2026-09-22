package assignment11;

interface Switchable {
    void turnOn();
}

class Light implements Switchable {
    public void turnOn() {
        System.out.println("Light is ON");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan is ON");
    }
}

public class SwitchableDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        light.turnOn();
        fan.turnOn();
    }
}
