//4) Program to check whether entered character is an alphabet or not
import java.util.Scanner;

class Q04{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a charater :");
        int ch = sc.next().charAt(0);

        
        if (ch >= 'a' && ch <= 'z'||ch>='A'&& ch<='Z') {
            System.out.println(" is an Alphabe .");
        } else {
            System.out.println( "  it is not Alphabet .");
        }
    }
}