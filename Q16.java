/*

16.Create a class TCSEmployee with data members
 name, eid, salary and companyName to store information 
 of All TCS’s Employee records. Create functions which
  accept these members value and display them. Now u
   need to manage that companyName should be assign 
   only once, no matter how
many number of object of this class created.*/


class TCSEmployee {
    String name;
    int eid;
    double salary;
    static String companyName = "TCS";

    TCSEmployee(String n, int id, double s) {
        name = n;
        eid = id;
        salary = s;
    }

    void display() {
        System.out.println("Name: " + name + ", EID: " + eid + ", Salary: " + salary + ", Company: " + companyName);
    }
}

public class Q16 {
    public static void main(String[] args) {
        TCSEmployee e1 = new TCSEmployee("Piyush", 101, 40000);
        TCSEmployee e2 = new TCSEmployee("falak", 102, 50000);
        e1.display();
        e2.display();
    }
}
