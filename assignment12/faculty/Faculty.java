package assignment12.faculty;

public class Faculty {
    String name;
    int id;
    String department;

    public Faculty(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public void display() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Faculty ID: " + id);
        System.out.println("Department: " + department);
    }
}