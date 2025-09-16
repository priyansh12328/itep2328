//Solve the following programs by Command Line Argument Concept
//1) WAP to take n number of elements of an array and find out the 
// sum of first and last element of an array. 

import java.util.Scanner;

public class Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = arr[0] + arr[n - 1];
        System.out.println("Sum of first and last element: " + sum);

    
    }
}

/*
public class Q01 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please enter at least two numbers!");
            return;
        }

        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        int sum = arr[0] + arr[arr.length - 1];
        System.out.println("Sum of first and last element: " + sum);
    }
}
*/


/*
public class Q01 {
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Please enter at least two elements!");
            return;
        }
        int n = args.length;
        int first = Integer.parseInt(args[0]);
        int last = Integer.parseInt(args[args.length - 1]);
        int sum = first + last;
        System.out.println("Sum of first and last element: " + sum);
    }
}
*/

/*

public class Q01 {
    public static void main(String args[]) {
        // Check if user entered at least 1 argument
        
        if (args.length == 0) {
            System.out.println("Please provide array elements as command line arguments!");
            return;
        }

        // Convert first and last argument into integer

        int first = Integer.parseInt(args[0]);
        int last = Integer.parseInt(args[args.length - 1]);

        int sum = first + last;


        // Print result
        System.out.println("First element = " + first);
        System.out.println("Last element = " + last);
        System.out.println("Sum of First & Last Element = " + sum);
    }
}*/