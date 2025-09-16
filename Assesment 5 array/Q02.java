//WAP to program to calculate the sum of all element of array.
import java.util.Scanner;
class Q02{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
int sum = 0;
        System.out.println("enter the element of array :");
        int n = sc.nextInt();

       int arr[]=new int[n];
            for(int i= 0; i<n;i++)
            {
            System.out.println("Enter the array :"+(i+1));
            arr[i] =  sc.nextInt();
            }
            
                for(int i= 0; i<n;i++)
    
    {
        sum = sum + arr[i];
       
    }
        System.out.println("sum of array elment : "+sum); 
    }
}