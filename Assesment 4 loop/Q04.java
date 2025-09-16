//. Calculate the sum of following series
  //  1 2 3 .....n  

//  1 - 2 + 3 - 4 + 5 - 6 ....n 

  import java.util.Scanner;
class Q04{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
      System.out.println("enter the number");
  int n =  sc.nextInt();

 int firstseries = n * (n + 1) / 2;

int secondseries = 0;
        for (int i = 1; i <= n; i++)
         {
            if (i % 2 == 0) 
                secondseries -= i;
            else
                secondseries += i;
        }
        System.out.println("sum of first series( 1 2 3 .....n :) "+firstseries);
        System.out.println("sum of second series( 1 - 2 + 3 - 4 + 5 - 6 ....n ):"+secondseries);
    }}