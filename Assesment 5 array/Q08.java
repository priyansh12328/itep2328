import java.util.Scanner;

class Q08 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n + 1];

        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        
        System.out.print("Enter the element to insert: ");
        int newElement = sc.nextInt();

        System.out.print("Enter the position (1 to " + (n + 1) + "): ");
        int index = sc.nextInt();

        if (index < 1 || index > n + 1) {
            System.out.println("Invalid position!");
        } else {
            for (int i = n; i >= index; i--) {
                arr[i] = arr[i - 1];
            }

            
            arr[index - 1] = newElement;
            System.out.println("Array after insertion:");
            for (int i = 0; i <= n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
