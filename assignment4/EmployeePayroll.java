package assignment4;


import java.util.Scanner;

class EmployeePayroll {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            String basic = sc.nextLine();

            System.out.print("Enter Bonus: ");
            String bonus = sc.nextLine();

            Integer employeeId = Integer.valueOf(id);
            Double basicSalary = Double.valueOf(basic);
            Double bonusAmount = Double.valueOf(bonus);

            if (basicSalary <= 0) {
                System.out.println("Invalid salary");
            } else if (bonusAmount < 0) {
                System.out.println("Invalid bonus");
            } else {
                Double netSalary = basicSalary + bonusAmount;

                System.out.println("Employee ID: " + employeeId);
                System.out.println("Basic Salary: " + basicSalary);
                System.out.println("Bonus: " + bonusAmount);
                System.out.println("Net Salary: " + netSalary);
            }
        }
    }
}


