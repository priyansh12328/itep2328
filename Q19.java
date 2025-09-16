/*
19.Create a class Distance with data members (feet and inch).
Write a program showing the concept of passing object in a function
 and add the data members of both the objects and
  find out the total feet and inches.
*/

class Distance {
    int feet, inch;

    Distance(int f, int i) {
        feet = f;
        inch = i;
    }

    void add(Distance d) {
        int f = this.feet + d.feet;
        int i = this.inch + d.inch;
        if (i >= 12) {
            f += i / 12;
            i = i % 12;
        }
        System.out.println("Total = " + f + " feet " + i + " inch");
    }
}

public class Q19 {
    public static void main(String[] args) {
        Distance d1 = new Distance(5, 8);
        Distance d2 = new Distance(3, 7);
        d1.add(d2);
    }
}
