//jmb menu card

import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, qty;
        double total = 0;

        System.out.println("=== Welcome to JMB Restaurant ===");

        do {
            // Display Menu Card
            System.out.println("\n------ MENU CARD ------");
            System.out.println("1. Burger      - Rs. 120");
            System.out.println("2. Pizza       - Rs. 250");
            System.out.println("3. Sandwich    - Rs. 100");
            System.out.println("4. Cold Drink  - Rs. 60");
            System.out.println("5. Ice Cream   - Rs. 80");
            System.out.println("6. Exit & Generate Bill");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity of Burger: ");
                    qty = sc.nextInt();
                    total += qty * 120;
                    break;
                case 2:
                    System.out.print("Enter quantity of Pizza: ");
                    qty = sc.nextInt();
                    total += qty * 250;
                    break;
                case 3:
                    System.out.print("Enter quantity of Sandwich: ");
                    qty = sc.nextInt();
                    total += qty * 100;
                    break;
                case 4:
                    System.out.print("Enter quantity of Cold Drink: ");
                    qty = sc.nextInt();
                    total += qty * 60;
                    break;
                case 5:
                    System.out.print("Enter quantity of Ice Cream: ");
                    qty = sc.nextInt();
                    total += qty * 80;
                    break;
                case 6:
                    System.out.println("\nGenerating Final Bill...");
                    break;
                default:
                    System.out.println(" Invalid choice! Please select again.");
            }
        } while (choice != 6);

        // Final Bill
        System.out.println("\n======= BILL RECEIPT =======");
        System.out.println("Total Amount : Rs. " + total);
        System.out.println("Thank you for visiting JMB Restaurant!");
        System.out.println("============================");

        sc.close();
    }
}
