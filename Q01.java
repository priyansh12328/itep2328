 /*
1.Write a program that lets the user perform arithmetic operations on two numbers. 
Your program must be menu driven, allowing the user to select the operation (+, -, *, or /) and 
input the numbers. Furthermore, your program must consist of following functions:
a). Function showChoice: This function shows the options to the user and explains how to enter data. 
b). Function add: This function accepts two number as arguments and returns sum.
c). Function subtract: This function accepts two number as arguments and returns their difference. 
d). Function mulitiply: This function accepts two number as arguments and returns product.
e). Function divide: This function accepts two number as arguments and returns quotient.
 */

import java.util.Scanner;

public class Q01 {
    public static double add(double a, double b) {
        return a + b;
    }
    public static double subtract(double a, double b) {
        return a - b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error! Division by zero.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        switch (choice) {
            case 1:
                System.out.println("Result = " + add(num1, num2));
                break;
            case 2:
                System.out.println("Result = " + subtract(num1, num2));
                break;
            case 3:
                System.out.println("Result = " + multiply(num1, num2));
                break;
            case 4:
                System.out.println("Result = " + divide(num1, num2));
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

