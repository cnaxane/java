package assignment12;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Chaitanya", 101, "Computer Science");
        Faculty f = new Faculty("Rahul", 201, "Computer Science");

        System.out.println("Student Details");
        s.display();

        System.out.println();

        System.out.println("Faculty Details");
        f.display();
    }

    static class Student {
        private final String name;
        private final int id;
        private final String department;

        Student(String name, int id, String department) {
            this.name = name;
            this.id = id;
            this.department = department;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Department: " + department);
        }
    }

    static class Faculty {
        private final String name;
        private final int id;
        private final String department;

        Faculty(String name, int id, String department) {
            this.name = name;
            this.id = id;
            this.department = department;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Department: " + department);
        }
    }
}
