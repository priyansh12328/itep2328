//
import java.util.Scanner;

class Q2 {
    void display() {
           
 Scanner sc = new Scanner(System.in);
    System.out.print("Enter a character ");
    char ch = sc.next().charAt(0);
    if (ch>='A' && ch<='Z'){
        System.out.print("the uppercase ");
    }
    }
    public static void main(String args[]){

        Q2 obj = new Q2();
        obj.display();
    }
}