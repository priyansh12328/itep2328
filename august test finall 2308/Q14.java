//write a program to sort an array take value from user in ssimple way 

import java.util.Scanner;
import java.util.Arrays;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //  Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // : Input array elements
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // array method 
        Arrays.sort(arr);

        // dispaly sortrf aray 
        System.out.println("Sorted array in ascending order:");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
/*
// Program to sort an array in ascending order
public class SortArray {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 6};  // Sample array

        // Sorting using simple nested loops
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Printing sorted array
        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

*/
/*
import java.util.Scanner;
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Ask user for array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Step 2: Declare array
        int[] arr = new int[n];

        // Step 3: Input elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 4: Sort the array
        Arrays.sort(arr);

        // Step 5: Print sorted array
        System.out.println("Sorted Array in Ascending Order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
