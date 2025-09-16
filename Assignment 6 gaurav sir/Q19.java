//Program to check whether entered year is a leap year or not

import java.util.Scanner;

public class Q19{
    static void Leap() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            System.out.println(year + " is a Leap Year");
        else
            System.out.println(year + " is NOT a Leap Year");
    }

    public static void main(String[] args) {
        Leap();
    }
}
