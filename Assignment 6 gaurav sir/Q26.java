//26) WAP to find out the factorial of a number.
import java.util.Scanner;
class Q26{
    int f=1;
    void fact(int n){
        while(n!=0){
            f=f*n;
            n--;
        }
        System.out.println("Factorial Number : "+f);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number = ");
        int n=sc.nextInt();
        Q26 obj=new Q26();
        obj.fact(n);
    }
}