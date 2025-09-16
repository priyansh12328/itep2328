//WAP to replace all element with 0 which is multiple of 5
import java.util.Scanner;

class Q05 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();

        int arr[] = new int[n];

    
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        
        for (int i = 0; i < n; i++) {
            if (arr[i] % 5 == 0) {  // 5 to 0 
                arr[i] = 0;
            }
        }

        System.out.println("The updated elements are:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
