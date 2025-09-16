// 1	+	1/2	+	1/3	+	1/4	+	1/5	….. n terms(find out sum)

import java.util.Scanner;
class Q09{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int n =  sc.nextInt();


        
        double sum = 0.0;

        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i ;
        
         if (i == 1)
                System.out.print("1");
            else
                System.out.print(" + 1/" + i);
         
        }
        System.out.println("\nSum of  up to " + n + " terms is: " + sum);



    }}