// Q37) WAP to reverse individual elements of an array


import java.util.Scanner;

class Q37 {
    static int reverseNum(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Array with reversed elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(reverseNum(arr[i]) + " ");
        }
    }
}
