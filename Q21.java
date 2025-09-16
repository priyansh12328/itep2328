/*
21.Create a class Alpha and Beta.
 Both classes contain one data member of type integer. 
 Write a program to find which class data member is greater.
*/
class Alpha {
    int a;
    Alpha(int a) { this.a = a; }
}

class Beta {
    int b;
    Beta(int b) { this.b = b; }
}

public class Q21 {
    public static void main(String[] args) {
        Alpha obj1 = new Alpha(20);
        Beta obj2 = new Beta(15);

        if (obj1.a > obj2.b)
            System.out.println("Alphas data is greater = " + obj1.a);
        else
            System.out.println("Betas data is greater = " + obj2.b);
    }
}
