//)Program to check whether entered year is a leap year or not using nested if else
import java.util.Scanner;

public class Q20 {
    static void checkLeap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    System.out.println(year + " is a Leap Year");
                else
                    System.out.println(year + " is NOT a Leap Year");
            } else {
                System.out.println(year + " is a Leap Year");
            }
        } else {
            System.out.println(year + " is NOT a Leap Year");
        }
    }

    public static void main(String[] args) {
        checkLeap();
    }
}
