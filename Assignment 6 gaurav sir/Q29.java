//29) WAP to print Fibonacci series.
import java.util.Scanner;
class Q29{
    void fibonacci(int n){
        int n1=0,n2=1,n3;
        System.out.print(n1+" "+n2+" ");
        for(int i=3;i<=n;i++){
            n3=n1+n2;
            System.out.print(n3+" ");
            n1=n2;
            n2=n3;
        }

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter n : ");
        int n=sc.nextInt();
        Q29 obj=new Q29();
        obj.fibonacci(n);
    }
}