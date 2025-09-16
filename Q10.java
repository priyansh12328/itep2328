/*

10.Create a class Student with data member 
(rno, fees and static member totalFees).Create
 parameterized constructor  which update the 
 totalFees and create member function which prints 
 the total fees collected of all the students.
*/
class Student {
    int rno;
    float fees;
    static float totalFees = 0;

    Student(int r, float f) {
        rno = r;
        fees = f;
        totalFees += f;
    }

    void show() {
        System.out.println("RollNo: " + rno + ", Fees: " + fees);
    }

    static void showTotal() {
        System.out.println("Total Fees Collected = " + totalFees);
    }
}

public class Q10 {
    public static void main(String[] args) {
        Student s1 = new Student(1, 5000);
        Student s2 = new Student(2, 6000);
        s1.show();
        s2.show();
        Student.showTotal();
    }
}
