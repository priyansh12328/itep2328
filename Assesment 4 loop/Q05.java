// 1 3 5 7 9 .....n-Terms



  import java.util.Scanner;
class Q05{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
      System.out.println("enter the number");
  int n =  sc.nextInt();
 for (int i = 1; i <= n; i++)
  {
            int odd = 2*i-1;
            System.out.print(odd + " ");

  }


    }}