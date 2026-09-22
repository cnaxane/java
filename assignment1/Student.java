package assignment1;

class Student {
    String name;
    int rollNo;

    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Chaitanya", 101);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("\nParameterized Constructor:");
        s2.display();
    }
}

