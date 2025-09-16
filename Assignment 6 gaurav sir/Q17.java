//Program to find out greater number between two numbers using conditional operator.

import java.util.Scanner;

public class Q17 {
    static void findGreater() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        int max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("Greatest = " + max);
    }

    public static void main(String[] args) {
        findGreater();
    }
}

