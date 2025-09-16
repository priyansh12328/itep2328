/*
29. Create a Abstract class Volume with two data members(radius and height).
Declare two member function
a)getValue() :- which accepts value from user. 
b)showValue() :- which displays valus. 
c)calVol() :- which calculates volumes.
Create a class Cone which uses the above mentioned three methods to calculate the volume of Cone. 
Create a class Cylinder which uses the above mentioned three methods to calculate the volume of Cylinder.
*/
import java.util.Scanner;

abstract class Volume {
    double radius, height;
    Scanner sc = new Scanner(System.in);

    void getValue() {
        System.out.print("Enter radius: ");
        radius = sc.nextDouble();
        System.out.print("Enter height: ");
        height = sc.nextDouble();
    }

    void showValue() {
        System.out.println("Radius: " + radius + ", Height: " + height);
    }

    abstract void calVol();
}

class Cone extends Volume {
    void calVol() {
        double v = (Math.PI * radius * radius * height) / 3;
        System.out.println("Volume of Cone = " + v);
    }
}

class Cylinder extends Volume {
    void calVol() {
        double v = Math.PI * radius * radius * height;
        System.out.println("Volume of Cylinder = " + v);
    }
}

public class Q29 {
    public static void main(String[] args) {
        Cone c = new Cone();
        c.getValue();
        c.showValue();
        c.calVol();

        Cylinder cy = new Cylinder();
        cy.getValue();
        cy.showValue();
        cy.calVol();
    }
}
