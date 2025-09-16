// 1	2	2	4	8	32	…… n term
import java.util.Scanner;
class q08{
   public static void main(String args[]){
   Scanner sc = new Scanner(System.in);
   
 System.out.println("enter the number");
        int n =  sc.nextInt();


   int a = 1, b = 2;
        
System.out.print( + a + " " + b);
        for (int i = 2; i<=n; i++)
         {
            int c = a * b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }

   




    }}