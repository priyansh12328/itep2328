
///WAP to sort the array
import java.util.Scanner;

class Q06 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int arr[] = new int[n];

       
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        
        for (int i = 0; i < n - 1; i++) {   // Bubble sort logic to sort the array in ascending order
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array in ascending order:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}

    
    