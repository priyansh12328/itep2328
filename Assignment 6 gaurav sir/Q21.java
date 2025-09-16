/*21)Program to get marks of 5 subjects from user and find out its grade using nested if else
Per>=75 && per<=100 Grade A
Per>=60 && per<75 Grade B
Per>=50 && per<60 Grade C
Per>=33 && per<50 Grade D
else Fail
*/
import java.util.Scanner;

public class Q21 {
    static void Grade() {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter marks of subject " + i + ": ");
            total += sc.nextInt();
        }
        double per = total / 5.0;

        if (per >= 75 && per <= 100)
            System.out.println("Grade A");
        else if (per >= 60)
            System.out.println("Grade B");
        else if (per >= 50)
            System.out.println("Grade C");
        else if (per >= 33)
            System.out.println("Grade D");
        else
            System.out.println("Fail");
    }

    public static void main(String[] args) {
        Grade();
    }
}
