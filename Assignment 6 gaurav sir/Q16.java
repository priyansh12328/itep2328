//Check if both numbers are equals or not, if not then find out the greatest number.

import java.util.Scanner;
public class Q16 {
        static void checkNumbers() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        if (a == b) {
            System.out.println("Both numbers are equal");
        } else if (a > b) {
            System.out.println(a + " is greater");
        } else {
            System.out.println(b + " is greater");
        }
    }

    public static void main(String[] args) {
        checkNumbers();
    }
}
