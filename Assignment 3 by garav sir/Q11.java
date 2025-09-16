//Program to find out whether entered number is even or odd
import java.util.Scanner;
class Q11{
    public static void main (String args[]){

        Scanner sc  = new Scanner(System.in);

        System.out.print("enter a number :");
        int num = sc.nextInt();

        if(num%2==0){
          System.out.print(" even no");  
          
        }
        else{
          System.out.print("odd  no");    
        }
    }
}