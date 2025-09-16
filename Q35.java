/*
35. Create a class Employee with(empNo ,salary and totalSalary) ) with following features.
a. Only parameterized constructor;
b. totalSalary always represent total of all the salaries of all employees created.
c. empNo should be auto incremented.
d. display total employees and totalSalary using class method.

*/



class Employee {
    private int empNo;
    private double salary;
    private static double totalSalary = 0;
    private static int totalEmployees = 0;

    // Parameterized Constructor
    public Employee(double salary) {
        this.salary = salary;
        totalEmployees++;
        empNo = totalEmployees; // Auto-increment employee number
        totalSalary += salary;  // Add this salary to total
    }

    // Display Employee details
    public void display() {
        System.out.println("Employee No: " + empNo + ", Salary: " + salary);
    }

    // Class method to display totals
    public static void showTotals() {
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Total Salary: " + totalSalary);
    }
}

// Test Class
public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(30000);
        Employee e2 = new Employee(40000);
        Employee e3 = new Employee(35000);

        e1.display();
        e2.display();
        e3.display();

        // Display total employees and salary
        Employee.showTotals();
    }
}
