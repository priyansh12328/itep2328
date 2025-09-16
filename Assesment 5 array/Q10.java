//10.WAP to to count the occurance of all element in array
import java.util.Scanner;

class Q10 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        boolean visit[] = new boolean[n];

      
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + " element: ");
            arr[i] = sc.nextInt();
        }

      
        System.out.println("Data input:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

      
        System.out.println("Frequencies:");
        for (int i = 0; i < n; i++) {
            if (visit[i]) 
            continue;

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visit[j] = true;
                }
            }
            System.out.println(arr[i] + " occurs " + count + " times");
        }
    }
}
