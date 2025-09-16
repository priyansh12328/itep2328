//3) Program to check whether entered character is in lowercase or not
import java.util.Scanner;

class Q03{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a charater :");
        int ch = sc.next().charAt(0);

        
        if (ch >= 'a' && ch <= 'z') {
            System.out.println(" is an Lowercase letter.");
        } else {
            System.out.println( " is not Lowercase letter.");
        }
    }
}