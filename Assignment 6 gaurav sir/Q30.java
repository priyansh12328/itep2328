//30) WAP to print N even numbers.
import java.util.Scanner;
class Q30{
    void even(int n){
        System.out.println(n+ "Even numbers : ");
        for(int i=1;i<=n;i++){
            
                System.out.print((2*i)+" ");
        }
    }
    public static void main(String argss[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of terms : ");
        int n=sc.nextInt();
        Q30 obj=new Q30();
        obj.even(n);
    }
}