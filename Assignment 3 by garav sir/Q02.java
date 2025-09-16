// Program to check whether entered character is in uppercase or not
import java.util.Scanner;

class Q02{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a charater :");
        int ch = sc.next().charAt(0);

        
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println( " is an Uppercase letter.");
        } else {
            System.out.println( " is not uppercase letter.");
        }
    }
}