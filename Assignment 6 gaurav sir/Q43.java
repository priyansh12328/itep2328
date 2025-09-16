//43) Addition and Multiplication of two 2d array.
import java.util.Scanner;
class Q43{
    static void getData(int arr1[][],int arr2[][],int m,int n){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array 1 elements : ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr1[i][j]=sc.nextInt();
            }
        }
        System.out.println("\n\nEnter array 2 elements : ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr2[i][j]=sc.nextInt();
            }
        }

        System.out.println("Array1 : ");
        for(int x[]:arr1){
            for(int y:x){
                System.out.print(y+" ");
            }
            System.out.println();
        }

        System.out.println("\nArray2 : ");
        for(int x[]:arr2){
            for(int y:x){
                System.out.print(y+" ");
            }
            System.out.println();
        }

    }
    //Addition
    static void add(int arr1[][],int arr2[][],int m,int n){
        int sum[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum[i][j]=arr1[i][j]+arr2[i][j];
            }
        } 
           

        System.out.println("Addtiton : ");
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }
    }
    //Multiplication
    static void multi(int arr1[][],int arr2[][],int m,int n){
        int mul[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mul[i][j]=0;
                for(int k=0;k<n;k++){
                    mul[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }
        System.out.println("\nMultiplication :");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(mul[i][j]+" ");
            }
        System.out.println();
        }
    } 

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of rows : ");
        int m=sc.nextInt();
        System.out.print("Enter no. of columns : ");
        int n=sc.nextInt();

        int arr1[][]=new int[m][n];
        int arr2[][]=new int[m][n];
        getData(arr1,arr2,m,n);
        add( arr1, arr2, m, n);
        multi( arr1, arr2, m, n);
    }
}