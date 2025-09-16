/*

30.Create a class Employee with one data member(name).Declare the member function 
a)Employee() :- initializes the data member.
b)getName() :- which gets the name. 
c)setName() :- which sets the name. 
d)pay(int hours_worked)

Create a class HourlyEmployee which takes two data members(name and wage).Use above member function.
 The pay method should calculate the hourly wage of an employee.

Create a class SalariedEmployee which takes two data members(name and wage).Use above member function.
 The pay method should calculate the hourly wage of an employee.

*/
class Employee {
    String name;
    Employee(String n) { name = n; }
    String getName() { return name; }
    void setName(String n) { name = n; }
    double pay(int hours) { return 0; }
}

class HourlyEmployee extends Employee {
    double wage;
    HourlyEmployee(String n, double w) { super(n); wage = w; }
    double pay(int hours) { return hours * wage; }
}

class SalariedEmployee extends Employee {
    double salary;
    SalariedEmployee(String n, double s) { super(n); salary = s; }
    double pay(int hours) { return salary; }
}

public class Q30 {
    public static void main(String[] args) {
        HourlyEmployee h = new HourlyEmployee("Ravi", 200);
        System.out.println("Hourly Pay = " + h.pay(40));

        SalariedEmployee s = new SalariedEmployee("Asha", 50000);
        System.out.println("Salaried Pay = " + s.pay(0));
    }
}
