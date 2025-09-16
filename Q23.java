/*
23.Create three classes
Faculty (facultyname, department, salary) 
FullTimeFaculty (basic, allowance) inherits class Faculty 
PartTimeFaculty (hour, rate) inherits class Faculty

Create a function for accepting input for FullTimeFaculty and PartTimeFaculty
 but salary should not be accepted. Salary is calculated on the basis of (basic+allowance) for FullTimeFaculty 
and (hour*rate) for PartTimeFaculty. Also create function for displaying data for any faculty.
*/
class Faculty {
    String name, department;
    double salary;
    void display() {
        System.out.println("Name: " + name + ", Dept: " + department + ", Salary: " + salary);
    }
}

class FullTimeFaculty extends Faculty {
    double basic, allowance;
    void input(String n, String d, double b, double a) {
        name = n; department = d; basic = b; allowance = a;
        salary = basic + allowance;
    }
}

class PartTimeFaculty extends Faculty {
    int hour; double rate;
    void input(String n, String d, int h, double r) {
        name = n; department = d; hour = h; rate = r;
        salary = hour * rate;
    }
}

public class Q23 {
    public static void main(String[] args) {
        FullTimeFaculty f1 = new FullTimeFaculty();
        f1.input("Raj", "CSE", 30000, 5000);
        f1.display();

        PartTimeFaculty p1 = new PartTimeFaculty();
        p1.input("Simran", "Maths", 40, 500);
        p1.display();
    }
}
