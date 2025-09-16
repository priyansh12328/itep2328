// Program to check whether entered character is in lowercase or not and if yes, then convert it into uppercase.
import java.util.Scanner;

class Q08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if (ch >= 'a' && ch <= 'z') {
            char upper = (char)(ch - 32);  //
            System.out.println("Entered character is Lowercase .");
            System.out.println("Converted to Upercase: " + upper);
        } else {
            System.out.println("Entered character is NOT lowwercase.");
        }
    }
}
