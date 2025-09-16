//6) WAP to create a menu of 5 items regarding spare
//  parts of a vehicle and take individually the units
// and price of each part and then find out the total cost. 
import java.util.Scanner;

public class  Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int u1, u2, u3, u4, u5;
        double p1, p2, p3, p4, p5;
        double totalCost;

        System.out.println("=== Vehicle Spare Parts Billing ===");

        System.out.println("\nItem 1: Engine Oil");
        System.out.print("Enter units: ");
        u1 = sc.nextInt();
        System.out.print("Enter price per unit: ");
        p1 = sc.nextDouble();

        System.out.println("\nItem 2: Brake Pad");
        System.out.print("Enter units: ");
        u2 = sc.nextInt();
        System.out.print("Enter price per unit: ");
        p2 = sc.nextDouble();

        System.out.println("\nItem 3: Headlight");
        System.out.print("Enter units: ");
        u3 = sc.nextInt();
        System.out.print("Enter price per unit: ");
        p3 = sc.nextDouble();

        System.out.println("\nItem 4: Battery");
        System.out.print("Enter units: ");
        u4 = sc.nextInt();
        System.out.print("Enter price per unit: ");
        p4 = sc.nextDouble();

        System.out.println("\nItem 5: Tyre");
        System.out.print("Enter units: ");
        u5 = sc.nextInt();
        System.out.print("Enter price per unit: ");
        p5 = sc.nextDouble();

        // total cost
        totalCost = (u1 * p1) + (u2 * p2) + (u3 * p3) + (u4 * p4) + (u5 * p5);

        System.out.println("\n========== BILL ==========");
        System.out.println("Engine Oil   -> " + u1 + " x " + p1 + " = " + (u1 * p1));
        System.out.println("Brake Pad    -> " + u2 + " x " + p2 + " = " + (u2 * p2));
        System.out.println("Headlight    -> " + u3 + " x " + p3 + " = " + (u3 * p3));
        System.out.println("Battery      -> " + u4 + " x " + p4 + " = " + (u4 * p4));
        System.out.println("Tyre         -> " + u5 + " x " + p5 + " = " + (u5 * p5));
        System.out.println("--------------------------");
        System.out.println("Total Cost = " + totalCost);
        System.out.println("==========================");

        sc.close();
    }
}
