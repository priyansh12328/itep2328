/*
12.Create a Class Calculate with two data members(num,num1)Declare two member function.
a) create parameterized constructor which takes two integer value and	initialize members with this pointer.
b)sum() :- which displays the number using this
*/
class Calculate {
    int num, num1;

    Calculate(int num, int num1) {
        this.num = num;
        this.num1 = num1;
    }

    void sum() {
        System.out.println("Sum = " + (this.num + this.num1));
    }
}

public class Q12 {
    public static void main(String[] args) {
        Calculate c = new Calculate(15, 25);
        c.sum();
    }
}


