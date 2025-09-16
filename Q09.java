/*
9.Create a class Employee with members (empid, salary).
Create following functions
a)calcTax() with employee object as argument
 and print tax on salary with 12.5% tax rate;
b)max() which accepts two employee as objects 
and return the employee with higher salary
*/
      
class Employee {
    int empid;
    double salary;

    Employee(int id, double sal) {
        empid = id;
        salary = sal;
    }

    void calcTax() {
        double tax = salary * 0.125;
        System.out.println("Tax for Employee " + empid + " = " + tax);
    }

    static Employee max(Employee e1, Employee e2) {
        return (e1.salary > e2.salary) ? e1 : e2;
    }
}

public class Q09 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, 40000);
        Employee e2 = new Employee(2, 55000);

        e1.calcTax();
        e2.calcTax();

        Employee maxEmp = Employee.max(e1, e2);
        System.out.println("Employee with higher salary = " + maxEmp.empid);
    }
}
