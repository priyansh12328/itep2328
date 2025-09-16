//7) WAP to enter source, destination,date, day and time and
//  creates a menu for reservation where user needs to select vehicle 
//  then selects no. Of seats for males, females and children and
//  also calculate the fare according to senior citizen criteria.
//  Note : No bookings will be considered for Saturday and Sunday 

import java.util.Scanner;

public class Q07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Journey details
        System.out.print("Enter Source: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter Date (dd/mm/yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter Day: ");
        String day = sc.nextLine().toLowerCase();  // to handle any case

        System.out.print("Enter Time (HH:MM): ");
        String time = sc.nextLine();

        // Check for Saturday & Sunday
        if (day.equals("saturday") || day.equals("sunday")) {
            System.out.println("\n Sorry! No bookings allowed on Saturday or Sunday.");
            return;  // exit program
        }

        // Menu for vehicle
        System.out.println("\n=== Vehicle Menu ===");
        System.out.println("1. Bus  (Fare: Rs. 200 per seat)");
        System.out.println("2. Train (Fare: Rs. 150 per seat)");
        System.out.println("3. Flight (Fare: Rs. 2000 per seat)");
        System.out.print("Select vehicle (1-3): ");
        int choice = sc.nextInt();

        int farePerSeat = 0;
        switch (choice) {
            case 1: farePerSeat = 200; break;
            case 2: farePerSeat = 150; break;
            case 3: farePerSeat = 2000; break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        // Input passengers
        System.out.print("\nEnter number of Male passengers: ");
        int males = sc.nextInt();

        System.out.print("Enter number of Female passengers: ");
        int females = sc.nextInt();

        System.out.print("Enter number of Children: ");
        int children = sc.nextInt();

        System.out.print("Enter number of Senior Citizens (age 60+): ");
        int seniors = sc.nextInt();

        // Fare calculation
        int totalSeats = males + females + children + seniors;
        double totalFare = (totalSeats * farePerSeat);

        // Discount for senior citizens: 50% off
        double seniorDiscount = seniors * (farePerSeat * 0.5);
        totalFare -= seniorDiscount;

        // Final Bill
        System.out.println("\n===== Reservation Details =====");
        System.out.println("From: " + source + "  To: " + destination);
        System.out.println("Date: " + date + "  Day: " + day);
        System.out.println("Time: " + time);
        System.out.println("Vehicle Fare per seat = Rs. " + farePerSeat);
        System.out.println("---------------------------------");
        System.out.println("Males: " + males);
        System.out.println("Females: " + females);
        System.out.println("Children: " + children);
        System.out.println("Senior Citizens: " + seniors + " (50% discount applied)");
        System.out.println("---------------------------------");
        System.out.println("Total Seats = " + totalSeats);
        System.out.println("Total Fare = Rs. " + totalFare);
        System.out.println("=================================");

        sc.close();
    }
}
