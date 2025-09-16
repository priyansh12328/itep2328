/*

18.Create a class Max with one data member(v) and functions
a)getV(): which is use to read variable value
b)display() : to display value
c)check() : which return an object of Max class and find maximum value using one objects as argument.
(use this keyword to return an object).
*/
class Max {
    int v;

    void getV(int val) {
        v = val;
    }

    void display() {
        System.out.println("Value = " + v);
    }

    Max check(Max m) {
        if (this.v > m.v) return this;
        else return m;
    }
}

public class Q18 {
    public static void main(String[] args) {
        Max m1 = new Max();
        Max m2 = new Max();
        m1.getV(20);
        m2.getV(30);
        Max m = m1.check(m2);
        m.display();
    }
}
