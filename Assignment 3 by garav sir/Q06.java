// Program to check whether entered character is a $ or @ by its ascii value
import java.util.Scanner;

class Q06 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if ((int)ch == 36) {   // ASCII==36
            System.out.println("Entered character is $");
        } else if ((int)ch == 64) {  // ASCII ==64
            System.out.println("Entered character is @");
        } else {
            System.out.println("Entered character is neither $ nor @");
        }
    }
}
