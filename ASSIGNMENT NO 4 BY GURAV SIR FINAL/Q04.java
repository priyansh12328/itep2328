//4) WAP to create a menu and perform all arithmetic operations with integer case and with special symbols

import java.util.Scanner;

 class Q04{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1, num2;
        char choice;

        System.out.print("Enter first number: ");
        num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        num2 = sc.nextInt();

        System.out.println("\n=== MENU ===");
        System.out.println("+ : Addition");
        System.out.println("- : Subtraction");
        System.out.println("* : Multiplication");
        System.out.println("/ : Division");
        System.out.println("% : Modulus (Remainder)");

        System.out.print("\nEnter your choice (symbol): ");
        choice = sc.next().charAt(0);

        switch (choice) {
            case '+':
                System.out.println("Result = " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result = " + (num1 - num2));
                break;
            case '*':
                System.out.println("Result = " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Result = " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero!");
                }
                    break;
                case '%':
                    if (num2 != 0) {
                        System.out.println("Result = " + (num1 % num2));
                    } else {
                        System.out.println("Error: Modulus by zero!");
                    }
                    break;
                   default:
                    System.out.println("Invalid choice! Please enter +, -, *, /, or %");
            }

        }
    }
