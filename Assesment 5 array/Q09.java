//WAP to delete element from array at specific position
import java.util.Scanner;

class Q09 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

    
        System.out.print("Enter position to delete (1 to " + n + "): ");
        int position = sc.nextInt();

        
        if (position < 1 || position > n) {
            System.out.println("Invalid position!");
            return;
        }

       
        System.out.println("Array after deletion:");
        for (int i = 0; i < n; i++) {
            if (i == position - 1) {
                continue; 
            }
            System.out.print(arr[i] + " ");
        }
    }
}
