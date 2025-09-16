/*
20.Create a class Distance with data members (feet and inch).Write a program
 showing the concept of passing object in a function and returning
 object from a function (add the data members of both the objects
  and find out the total feet and inches).
*/
class Distance {
    int feet, inch;

    Distance(int f, int i) {
        feet = f;
        inch = i;
    }

    Distance add(Distance d) {
        int f = this.feet + d.feet;
        int i = this.inch + d.inch;
        if (i >= 12) {
            f += i / 12;
            i = i % 12;
        }
        return new Distance(f, i);
    }

    void display() {
        System.out.println("Feet = " + feet + ", Inch = " + inch);
    }
}

public class Q20 {
    public static void main(String[] args) {
        Distance d1 = new Distance(5, 8);
        Distance d2 = new Distance(3, 7);
        Distance d3 = d1.add(d2);
        d3.display();
    }
}
