/*
26.Create a class Employee with two protected data member (name, payRate).
Declare two member function
a)void getName() :- which accepts name.
b)float getPay() :- which accepts the pay.
Create a class Manager with one data member is_salaried (which should be in the form of 0(false) or 1(true).
Declare one member function
a)int is_salaried() :- which returns whether the manager is salaried or not. b)showDetail() :- it display the entire detail of a employee.
*/

class Employee {
    protected String name;
    protected float payRate;

    void getName(String n) { name = n; }
    void getPay(float p) { payRate = p; }
}

class Manager extends Employee {
    private int salaried; // 1 true, 0 false

    void setSalaried(int s) { salaried = s; }
    int is_salaried() { return salaried; }

    void showDetail() {
        System.out.println("Name: " + name + ", PayRate: " + payRate + ", Salaried: " + (salaried==1?"Yes":"No"));
    }
}

public class Q26 {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.getName("Priya");
        m.getPay(50000);
        m.setSalaried(1);
        m.showDetail();
    }
}
