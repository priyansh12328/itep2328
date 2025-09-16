/*
11) WAP to manage Child vaccination */
import java.util.Scanner;

public class Q11 {
    static String childName, parentName;
    static int age;
    static boolean[] vaccinated = new boolean[5]; // 5 vaccines
    static boolean dataEntered = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Child Vaccination Management System ===");
            System.out.println("1. Enter Child Details");
            System.out.println("2. Add Vaccination Record");
            System.out.println("3. View Vaccination History");
            System.out.println("4. Next Due Vaccine Reminder");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    enterDetails(sc);
                    break;
                case 2:
                    if (dataEntered) addVaccination(sc);
                    else System.out.println(" Enter child details first!");
                    break;
                case 3:
                    if (dataEntered) showHistory();
                    else System.out.println(" Enter child details first!");
                    break;
                case 4:
                    if (dataEntered) nextDueVaccine();
                    else System.out.println(" Enter child details first!");
                    break;
                case 5:
                    System.out.println(" Exiting... Stay Healthy!");
                    break;
                default:
                    System.out.println(" Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }

    // Enter child details
    static void enterDetails(Scanner sc) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter Child Name: ");
        childName = sc.nextLine();
        System.out.print("Enter Age (in years): ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Parent's Name: ");
        parentName = sc.nextLine();
        dataEntered = true;
        System.out.println(" Child details saved successfully!");
    }

    // Add vaccination
    static void addVaccination(Scanner sc) {
        System.out.println("\nAvailable Vaccines:");
        System.out.println("1. Polio");
        System.out.println("2. BCG");
        System.out.println("3. DTP");
        System.out.println("4. Hepatitis");
        System.out.println("5. Measles");
        System.out.print("Select vaccine number to mark as done: ");
        int v = sc.nextInt();

        if (v >= 1 && v <= 5) {
            if (!vaccinated[v - 1]) {
                vaccinated[v - 1] = true;
                System.out.println("Vaccine recorded successfully!");
            } else {
                System.out.println(" This vaccine is already marked as done!");
            }
        } else {
            System.out.println(" Invalid choice!");
        }
    }

    // Show vaccination history
    static void showHistory() {
        String[] vaccines = {"Polio", "BCG", "DTP", "Hepatitis", "Measles"};
        System.out.println("\n=== Vaccination History of " + childName + " ===");
        for (int i = 0; i < 5; i++) {
            System.out.println(vaccines[i] + ": " + (vaccinated[i] ? "Done" : " Pending"));
        }
    }

    // Next due vaccine
    static void nextDueVaccine() {
        String[] vaccines = {"Polio", "BCG", "DTP", "Hepatitis", "Measles"};
        for (int i = 0; i < 5; i++) {
            if (!vaccinated[i]) {
                System.out.println(" Next Due Vaccine: " + vaccines[i]);
                return;
            }
        }
        System.out.println(" All vaccines are completed!");
    }
}
