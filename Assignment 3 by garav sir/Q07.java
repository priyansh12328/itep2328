//Program to check whether entered character is in uppercase or not and if yes, then convert it into lowercase
import java.util.Scanner;

class Q07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if (ch >= 'A' && ch <= 'Z') {
            char lower = (char)(ch + 32);  // add 32 to change in small letter
            System.out.println("Entered character is Uppercase.");
            System.out.println("Converted to Lowercase: " + lower);
        } else {
            System.out.println("Entered character is NOT Uppercase.");
        }
    }
}
