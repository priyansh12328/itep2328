/*
8.Write a program to calculate the area of a rectangle, 
which accepts value from the user and displays it.
 Use Constructor to initialize members.
 */
import java.util.Scanner;

class Rectangle {
    int length, breadth;

    Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    void area() {
        System.out.println("Area = " + (length * breadth));
    }
}

public class Q08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        int l = sc.nextInt();
        System.out.print("Enter breadth: ");
        int b = sc.nextInt();

        Rectangle r = new Rectangle(l, b);
        r.area();
    }
}
