//. WAP to find an element in array.
import java.util.Scanner;
class Q04{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
    int arr[]= {10,20,30,40,50,60,70,80,90,100};

        System.out.println("enter an element ");
        int  n = sc.nextInt();
         boolean x=false;

        for(int i=0;i<arr.length;i++){
        if (n==arr[i])
        
        {
            System.out.println(arr[i]+" is present at index["+i+"] ");
            x=true;
      
       break;
         }
        }
        if(x==false){
            System.out.print("Not present");
        }
    }
}