//. WAP to program calaculate the sum of all even element and all odd element of array.
import java.util.Scanner;

class Q03 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int sum1 = 0, sum2 = 0;

        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                sum1 += arr[i]; // sum of even elements
            } else {
                sum2 += arr[i]; // sum of odd elements
            }
        }

        System.out.println("Sum of even elements: " + sum1);
        System.out.println("Sum of odd elements: " + sum2);
    }
}
