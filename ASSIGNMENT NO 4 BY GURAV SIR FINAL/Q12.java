// 

import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String customerName, contact;
        int choice, days;
        double rentPerDay, totalRent;

        System.out.println("=== Rental Management System ===");

        // Customer Details
        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        contact = sc.nextLine();

        // Rental Menu
        System.out.println("\nSelect Rental Type:");
        System.out.println("1. Home Rental");
        System.out.println("2. Vehicle Rental");
        System.out.print("Enter choice: ");
        choice = sc.nextInt();

        // Days & Rent Input
        System.out.print("Enter Number of Days: ");
        days = sc.nextInt();
        System.out.print("Enter Rent per Day: ");
        rentPerDay = sc.nextDouble();

        // Calculation
        totalRent = days * rentPerDay;

        // Bill
        System.out.println("\n=== RENTAL BILL ===");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Contact       : " + contact);
        if (choice == 1) {
            System.out.println("Rental Type   : Home");
        } else if (choice == 2) {
            System.out.println("Rental Type   : Vehicle");
        } else {
            System.out.println("Rental Type   : Unknown");
        }
        System.out.println("Days Rented   : " + days);
        System.out.println("Rent/Day      : " + rentPerDay);
        System.out.println("Total Rent    : " + totalRent);
        System.out.println("====================");

    
    }
}
