// 1 4 9 16 25 ...n [Term]
import java.util.Scanner;
class Q03{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
      System.out.println("enter the number");
      int n =  sc.nextInt();
    int i ;
    for(i=1;i<=n;i++ ){
        System.out.print((i * i) + " ");
    }
    }
}