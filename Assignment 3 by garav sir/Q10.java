// check if both numbers are equals or not, if not then find out the greatest number.
import java.util.Scanner;

class Q10 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        if (num1 == num2) {
            System.out.println("Both numbers are EQUAL.");
        } else if (num1 > num2) {
            System.out.println("Greatest number is: " + num1);
        } else {
            System.out.println("Greatest number is: " + num2);
        }
    }
}
