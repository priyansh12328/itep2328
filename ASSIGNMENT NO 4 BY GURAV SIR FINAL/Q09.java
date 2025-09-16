/*
priyansh


*/
import java.io.Console;
import java.util.Scanner;

public class Q09 {
    // ANSI Color Codes for colorful menu (chat gpt copy paste )
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    // user k bare m jankari lo 
    static String email, password, fullName;
    static int age;

    //bank details
    static double jointBalance = 0, savingBalance = 0, childBalance = 0;
    static boolean jointActive = false, savingActive = false, childActive = false;

    // Store nominee/spouse/child details
    static String spouseName, nomineeName, childName;
    static int spouseAge, nomineeAge, guardianAge;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();

        // === USER REGISTRATION ===
        System.out.println(BLUE + "=== Welcome to HDFC BANK ===" + RESET);
        System.out.print("Enter your Email-Id: ");
        email = sc.nextLine();

        if (console != null) {
            char[] pwdArray = console.readPassword("Enter your Password: ");
            password = new String(pwdArray);
        } else {
            System.out.print("Enter your Password: ");
            password = sc.nextLine();
        }

        System.out.print("Enter your Full Name: ");
        fullName = sc.nextLine();

        System.out.print("Enter your Age: ");
        age = sc.nextInt();
        sc.nextLine();

        // === MENU LOOP ===
        while (true) {
            clearScreen();
            System.out.println(YELLOW + "===== Main Menu =====" + RESET);
            System.out.println("1. Open Account");
            System.out.println("2. Banking Operations");
            System.out.println("3. Display Details");
            System.out.println("4. Deactivate Account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: openAccount(sc); break;
                case 2: bankingOperations(sc); break;
                case 3: displayDetails(); break;
                case 4: deactivateAccount(); break;
                case 5: System.out.println(GREEN + "Thank you for using Banking System!" + RESET); return;
                default: System.out.println(RED + "Invalid choice!" + RESET);
            }
            pause(sc);
        }
    }

    // === Open Account Menu ===
    static void openAccount(Scanner sc) {
        System.out.println(CYAN + "=== Open Account ===" + RESET);
        System.out.println("1. Joint Account (Min: 5000)");
        System.out.println("2. Saving Account (Min: 2000)");
        System.out.println("3. Child Account (Min: 1000)");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1:
                System.out.print("Enter Spouse Name: ");
                spouseName = sc.nextLine();
                System.out.print("Enter Spouse Age: ");
                spouseAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Initial Deposit (>=5000): ");
                jointBalance = sc.nextDouble();
                sc.nextLine();
                if (jointBalance >= 5000) {
                    jointActive = true;
                    System.out.println(GREEN + "Joint Account Opened Successfully!" + RESET);
                } else {
                    System.out.println(RED + "Minimum 5000 required!" + RESET);
                }
                break;
            case 2:
                System.out.print("Enter Nominee Name: ");
                nomineeName = sc.nextLine();
                System.out.print("Enter Nominee Age: ");
                nomineeAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Initial Deposit (>=2000): ");
                savingBalance = sc.nextDouble();
                sc.nextLine();
                if (savingBalance >= 2000) {
                    savingActive = true;
                    System.out.println(GREEN + "Saving Account Opened Successfully!" + RESET);
                } else {
                    System.out.println(RED + "Minimum 2000 required!" + RESET);
                }
                break;
            case 3:
                System.out.print("Enter Child Name: ");
                childName = sc.nextLine();
                System.out.print("Enter Guardian Age: ");
                guardianAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Initial Deposit (>=1000): ");
                childBalance = sc.nextDouble();
                sc.nextLine();
                if (childBalance >= 1000) {
                    childActive = true;
                    System.out.println(GREEN + "Child Account Opened Successfully!" + RESET);
                } else {
                    System.out.println(RED + "Minimum 1000 required!" + RESET);
                }
                break;
            default:
                System.out.println(RED + "Invalid choice!" + RESET);
        }
    }

    // === Banking Operations (Deposit/Withdraw) ===
    static void bankingOperations(Scanner sc) {
        if (!verifyPassword(sc)) return;

        System.out.println(CYAN + "=== Banking Operations ===" + RESET);
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Enter choice: ");
        int op = sc.nextInt();
        sc.nextLine();

        System.out.println("1. Joint Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Child Account");
        System.out.print("Select account: ");
        int acc = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        switch (op) {
            case 1: deposit(acc, amount); break;
            case 2: withdraw(acc, amount); break;
            default: System.out.println(RED + "Invalid Operation!" + RESET);
        }
    }

    static void deposit(int acc, double amt) {
        switch (acc) {
            case 1: if (jointActive) jointBalance += amt; break;
            case 2: if (savingActive) savingBalance += amt; break;
            case 3: if (childActive) childBalance += amt; break;
            default: System.out.println(RED + "Invalid account!" + RESET);
        }
        System.out.println(GREEN + "Deposit Successful!" + RESET);
    }

    static void withdraw(int acc, double amt) {
        switch (acc) {
            case 1: if (jointActive && jointBalance >= amt) jointBalance -= amt; break;
            case 2: if (savingActive && savingBalance >= amt) savingBalance -= amt; break;
            case 3: if (childActive && childBalance >= amt) childBalance -= amt; break;
            default: System.out.println(RED + "Invalid account or Insufficient balance!" + RESET);
        }
        System.out.println(GREEN + "Withdraw Successful!" + RESET);
    }

    // === Display Account Details ===
    static void displayDetails() {
        System.out.println(CYAN + "=== Account Details ===" + RESET);
        System.out.println("Name: " + fullName + " | Age: " + age + " | Email: " + email);
        if (jointActive) System.out.println("Joint Account: Balance=" + jointBalance + " | Spouse=" + spouseName);
        if (savingActive) System.out.println("Saving Account: Balance=" + savingBalance + " | Nominee=" + nomineeName);
        if (childActive) System.out.println("Child Account: Balance=" + childBalance + " | Child=" + childName);
    }

    // === Deactivate Accounts ===
    static void deactivateAccount() {
        jointActive = savingActive = childActive = false;
        jointBalance = savingBalance = childBalance = 0;
        System.out.println(RED + "All accounts deactivated!" + RESET);
    }

    // === Password verification ===
    static boolean verifyPassword(Scanner sc) {
        System.out.print("Enter password to continue: ");
        String pass = sc.nextLine();
        if (pass.equals(password)) return true;
        System.out.println(RED + "Incorrect Password!" + RESET);
        return false;
    }

    // === Utility Functions ===
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(Scanner sc) {
        System.out.println(YELLOW + "\nPress Enter to continue..." + RESET);
        sc.nextLine();
    }
}
