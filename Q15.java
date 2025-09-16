/*
15. Create a class Student (rollno, name) which keeps track
 of how many objects are created of the class. Every time 
 object of the class is created, it should display number 
 of total objects created.
*/
class Student {
    int rollno;
    String name;
    static int count = 0;

    Student(int r, String n) {
        rollno = r;
        name = n;
        count++;
        System.out.println("Objects created = " + count);
        
    }
}

public class Q15 {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Ram");
        Student s2 = new Student(2, "Shyam");
        Student s3 = new Student(3,"Mohan");
    }
}
