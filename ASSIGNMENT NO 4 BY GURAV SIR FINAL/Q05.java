//5) WAP to create a menu and find out area of circle, square, rectangle and trapezium 


import java.util.Scanner;

public class Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== AREA CALCULATOR MENU ===");
        System.out.println("1. Area of Circle");
        System.out.println("2. Area of Square");
        System.out.println("3. Area of Rectangle");
        System.out.println("4. Area of Trapezium");

        System.out.print("Enter your choice (1-4): ");
        choice = sc.nextInt();

        switch (choice) {
            case 1: // Circle
                System.out.print("Enter radius: ");
                double r = sc.nextDouble();
                double areaCircle = Math.PI * r * r;
                System.out.println("Area of Circle = " + areaCircle);
                break;

            case 2: // Square
                System.out.print("Enter side: ");
                double side = sc.nextDouble();
                double areaSquare = side * side;
                System.out.println("Area of Square = " + areaSquare);
                break;

            case 3: // Rectangle
                System.out.print("Enter length: ");
                double length = sc.nextDouble();
                System.out.print("Enter breadth: ");
                double breadth = sc.nextDouble();
                double areaRectangle = length * breadth;
                System.out.println("Area of Rectangle = " + areaRectangle);
                break;

            case 4: // Trapezium
                System.out.print("Enter base1: ");
                double base1 = sc.nextDouble();
                System.out.print("Enter base2: ");
                double base2 = sc.nextDouble();
                System.out.print("Enter height: ");
                double height = sc.nextDouble();
                double areaTrapezium = 0.5 * (base1 + base2) * height;
                System.out.println("Area of Trapezium = " + areaTrapezium);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
