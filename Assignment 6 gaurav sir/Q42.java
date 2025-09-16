//42) WAP showing the concept of sort (Ascending order | Descending order).

import java.util.Scanner;

class Q42 {
    //  Ascending Order
    static void Ascending(int arr[],int n){
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        System.out.println("Ascending order:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
    // Descending Order 
    static void Descending(int arr[],int n){
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }

        System.out.println("\nDescending order:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Ascending(arr,n);
        Descending(arr,n);
         
    }
}