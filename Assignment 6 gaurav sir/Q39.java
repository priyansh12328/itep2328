//39) WAP to remove an element from a specific index
import java.util.Scanner;
class Q39{
    static void getData(int arr[],int n){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter array elements : \n");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Original array : ");
        for(int x: arr){
            System.out.print(x+"  ");
        }
    }

    static void delete(int arr[],int n,int p){
        for(int i=p;i<n-1;i++){
            arr[i]=arr[i+1];
        }
        
        System.out.println("After deletion:");
        for (int i = 0; i < n - 1; i++) { 
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        getData(arr,n);
        System.out.print("\nEnter position (0 to " + (n - 1) + ") to delete: ");
        int p=sc.nextInt();
        delete(arr,n,p);
    }
}