//write a program to showing the concept of jaagged array on generalized manner 



import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //user enter rows
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        //jaged declarekri 
        int[][] jagged = new int[rows][];

        // take user column input and  rows
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of elements in row " + (i + 1) + ": ");
            int cols = sc.nextInt();
            jagged[i] = new int[cols];

            // enter the value in the rows cloumn 
            System.out.println("Enter " + cols  + " elements:");
            for (int j = 0; j < cols; j++) {
                jagged[i][j] = sc.nextInt();
            }
        }

        // 
        System.out.println("\nJagged Array:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println(); // new line after each row
        }

        
    }
}
