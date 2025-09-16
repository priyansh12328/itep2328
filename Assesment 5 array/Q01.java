//1. WAP to Enter n element in array and print array....
import java.util.Scanner;
class Q01{
    public static void main (String args[]){
         Scanner sc= new Scanner(System.in);

         System.out.print("Enter n number of element:  ");
            int n = sc.nextInt();

            int arr[]=new int[n];
            for(int i= 0; i<n;i++)
            {
            System.out.println("Enter the array :"+(i+1));
            arr[i] =  sc.nextInt();}
            System.out.println("Array element is  ");
     for(int i=0; i<n; i++){
        System.out.println(arr[i]);
      }
                }
}