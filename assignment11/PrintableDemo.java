package assignment11;

interface Printable {
    void print();
}

class Student implements Printable {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void print() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

class Employee implements Printable {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void print() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }
}

public class PrintableDemo {
    public static void main(String[] args) {
        Student s = new Student("Chaitanya", 101);
        Employee e = new Employee("Rahul", 201);

        s.print();
        System.out.println();

        e.print();
    }
}
