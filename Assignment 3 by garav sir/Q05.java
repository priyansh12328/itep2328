//5) Program to check whether entered character is a digit or not
import java.util.Scanner;

class Q05 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if (ch >= '0' && ch <= '9') {
            System.out.println("Entered character is a DIGIT.");
        } else {
            System.out.println("Entered character is NOT a DIGIT.");
        }
    }
}
