/*
31.Create a class to calculate Area of circle with one data member to store the radius and another to store area value. Create method members
1. init - to input radius from user
2. calc - to calculate area
3. display- to display area
*/
import java.util.Scanner;

class Circle {
    double radius, area;

    void init() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        radius = sc.nextDouble();
    }

    void calc() { area = Math.PI * radius * radius; }//if wee enter the 3.14  = ans wer is 6358.50000000001 /////////////
    // if we enter Math.PI  then asnwer  is 6361.725123519332............

    void display() { System.out.println("Area of Circle = " + area); }
}

public class Q31 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.init();
        c.calc();
        c.display();
    }
}
