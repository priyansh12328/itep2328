//8) WAP to create a medical equipment menu for retailer and whole seller where retailers
//  sees only 5 medicines and purchase of medicine units is not more than 5 whereas wholesaler
//  sees list of 10 medicines and purchase of units is not more than 100 ,
//  prices of medicine would be in double.
import java.util.Scanner;

public class Q08{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prices (double) for medicines
        double m1 = 12.5, m2 = 25.0, m3 = 30.75, m4 = 45.50, m5 = 60.0;
        double m6 = 80.25, m7 = 95.0, m8 = 110.5, m9 = 130.0, m10 = 150.75;

        System.out.println("=== Medical Store Menu ===");
        System.out.print("Are you a Retailer (R) or Wholesaler (W)? : ");
        char userType = sc.next().charAt(0);

        double totalCost = 0;
        int choice, units;

        if (userType == 'R' || userType == 'r') {
            // Retailer menu (5 medicines)
            System.out.println("\nRetailer Menu (Max 5 units each)");
            System.out.println("1. Paracetamol   - Rs." + m1);
            System.out.println("2. Dolo-650      - Rs." + m2);
            System.out.println("3. Azithromycin  - Rs." + m3);
            System.out.println("4. Vitamin-C     - Rs." + m4);
            System.out.println("5. ORS Powder    - Rs." + m5);

            System.out.print("\nEnter your choice (1-5): ");
            choice = sc.nextInt();

            System.out.print("Enter units (<=5): ");
            units = sc.nextInt();

            if (units > 5) {
                System.out.println("Retailer cannot purchase more than 5 units!");
                return;
            }

            switch (choice) {
                case 1: totalCost = units * m1; break;
                case 2: totalCost = units * m2; break;
                case 3: totalCost = units * m3; break;
                case 4: totalCost = units * m4; break;
                case 5: totalCost = units * m5; break;
                default: System.out.println("Invalid choice!"); return;
            }
        } 
        else if (userType == 'W' || userType == 'w') {
            // Wholesaler menu (10 medicines)
            System.out.println("\nWholesaler Menu (Max 100 units each)");
            System.out.println("1. Paracetamol   - Rs." + m1);
            System.out.println("2. Dolo-650      - Rs." + m2);
            System.out.println("3. Azithromycin  - Rs." + m3);
            System.out.println("4. Vitamin-C     - Rs." + m4);
            System.out.println("5. ORS Powder    - Rs." + m5);
            System.out.println("6. Crocin        - Rs." + m6);
            System.out.println("7. Amoxicillin   - Rs." + m7);
            System.out.println("8. Cough Syrup   - Rs." + m8);
            System.out.println("9. Insulin       - Rs." + m9);
            System.out.println("10. BP Tablet    - Rs." + m10);

            System.out.print("\nEnter your choice (1-10): ");
            choice = sc.nextInt();

            System.out.print("Enter units (<=100): ");
            units = sc.nextInt();

            if (units > 100) {
                System.out.println(" Wholesaler cannot purchase more than 100 units!");
                return;
            }

            switch (choice) {
                case 1: totalCost = units * m1; break;
                case 2: totalCost = units * m2; break;
                case 3: totalCost = units * m3; break;
                case 4: totalCost = units * m4; break;
                case 5: totalCost = units * m5; break;
                case 6: totalCost = units * m6; break;
                case 7: totalCost = units * m7; break;
                case 8: totalCost = units * m8; break;
                case 9: totalCost = units * m9; break;
                case 10: totalCost = units * m10; break;
                default: System.out.println("Invalid choice!"); return;
            }
        } 
        else {
            System.out.println(" Invalid user type!");
            return;
        }

        // Final Bill
        System.out.println("\n===== BILL =====");
        System.out.println("Total Cost = Rs." + totalCost);
        System.out.println("================");
        
        sc.close();
    }
}
