// Q33) WAP to print the series: A b C d E f G h … up to n terms (alternating case)

import java.util.Scanner;

class Q33 {
    void series(int n) {
        for (int i = 0; i < n; i++) {
            char ch = (char)('A' + i);
            if (i % 2 == 0)
                System.out.print(ch + " ");
            else
                System.out.print(Character.toLowerCase(ch) + " ");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt() ;
        Q33 obj = new Q33();
        obj.series(n);
    }
}
