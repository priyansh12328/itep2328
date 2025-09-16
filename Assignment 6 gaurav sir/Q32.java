// Q32) WAP to print the series: 9, 99, 999, 9999, 99999 … up to n terms

import java.util.Scanner;

class Q32 {
    void series(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = (num * 10) + 9;
            System.out.print(num + " ");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        Q32 obj = new Q32();
        obj.series(n);
    }
}

