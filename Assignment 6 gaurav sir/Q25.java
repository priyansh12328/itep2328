//25) WAP to print table of a number.
import java.util.Scanner;
class Q25{
    void Table(int n){
        for(int i=1;i<=10;i++){
            System.out.println(n+" * "+i+" = "+(n*i));
        }
    }
    public static void main(String arhs[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number = ");
        int n=sc.nextInt();
        Q25 obj=new Q25();
        obj.Table(n);
    }
}