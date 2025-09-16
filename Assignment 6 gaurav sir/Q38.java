//38) WAP to insert an element at specific index in an array
import java.util.Scanner;
class Q38{
    static void getData(int arr[],int n){
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter array element : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("\nArray : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+"  ");
        }
    }

    static void insert(int arr[],int n,int p,int x){
        for(int i=n;i>p ; i--){
            arr[i]=arr[i-1];
        }
        arr[p]= x;
        System.out.print("\nAfter insertion....\n");
        for(int elements : arr){
            System.out.print(elements+"  ");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n=sc.nextInt();

        int arr[]=new int[n+1];
        getData(arr,n);

        System.out.print("\nEnter position : ");
        int p =sc.nextInt();
        if(n<p){
            System.out.print("\n Enter position between 0 to "+n+" : ");
            p=sc.nextInt();
        }

        System.out.print("Enter element : ");
        int x=sc.nextInt();

        insert(arr,n,p,x);
    }
}
/*
// Q38) WAP to insert an element at a specific index in an array

import java.util.Scanner;

class Q38 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n+1];  // extra space for insertion

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter element to insert: ");
        int elem = sc.nextInt();
        System.out.print("Enter position (0-based index): ");
        int pos = sc.nextInt();

        for (int i = n; i > pos; i--) {
            arr[i] = arr[i-1];
        }
        arr[pos] = elem;

        System.out.println("Array after insertion:");
        for (int i = 0; i <= n; i++) System.out.print(arr[i] + " ");
    }
}
*/