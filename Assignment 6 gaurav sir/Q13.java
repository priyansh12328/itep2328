//13) WAP to find out average of 5 numbers

import java.util.Scanner;

public class Q13 {
    static void findAverage() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter number " + i + ": ");
            sum += sc.nextInt();
        }
        double avg = sum / 5.0;
        System.out.println("Average = " + avg);
    }

    public static void main(String[] args) {
        findAverage();
    }
}