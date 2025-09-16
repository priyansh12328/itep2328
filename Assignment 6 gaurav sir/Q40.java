//40) WAP to merge two arrays
import java.util.Scanner;
class Q40{

    static void array1(int arr1[],int n1){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array1 elements : ");
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.print("Array1 : ");
        for(int x:arr1){
            System.out.print(x+"  ");
        }

    }

    static void array2(int arr2[],int n2){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter array2 elements : ");
        for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.print("Array2 : ");
        for(int x:arr2){
            System.out.print(x+"  ");
        }
        
    }

    static void Merge(int merge[],int arr1[],int arr2[],int n1,int n2){
        for(int i=0;i<n1;i++){
            merge[i]=arr1[i];
        }
        for(int i=0;i<n2;i++){
            merge[n1+i]=arr2[i];
        }

        System.out.print("\nAfter merge : ");
        for(int x : merge){
            System.out.print(x+"  ");
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter array1 size : ");
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        array1(arr1,n1);


        System.out.print("\nEnter array2 size : ");
        int n2=sc.nextInt();
        int arr2[]=new int[n2];
        array2(arr2,n2);

        int merge[]=new int[n1+n2];
        Merge(merge, arr1,arr2,n1,n2);
    }
}