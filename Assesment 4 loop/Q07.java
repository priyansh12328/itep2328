//0 1 1 2 3 5 8 13 ..... n-Terms     
 import java.util.Scanner;
class Q07{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
      System.out.println("enter the number");
  int n =  sc.nextInt();
  
   int a = 0, b = 1;
        
System.out.print( + a + " " + b);
        for (int i = 0; i<=n; i++)
         {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
  }}