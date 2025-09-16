/* 
 
 23) WAP showing the concept of Banking management system.Key Points to be included : 
a) User needs to enter some basic details(like mail-Id, password, full name and age).
b) Shows menu displaying the options of opening:
b.i. Joint account
b.i.1. Details of spouse
b.i.2. Age of spouse
b.i.3. Minimum amount to be deposited 5000/-
b.ii. Saving account
b.ii.1. Nominee name
b.ii.2. Nominee age
b.ii.3. Minimum amount to be deposited 2000/-
b.iii. Child account
b.iii.1. Child Name
b.iii.2. Guardian/Father’s age
b.iii.3. Minimum amount to be deposited 1000/-
C) Shows menu displaying the options of (Asks for password to perform the operation): 
a.i. Deposit
a.i.1. Joint Account
a.i.2. Saving Account
a.i.3. Child Account
a.ii. Withdraw
a.ii.1. Joint Account
a.ii.2. Saving Account
a.ii.3. Child Account
D) Display details of :
a) Account Holder
b) Transaction performed
c) Deactivate Account
Note: Every time you need to clear the screen after performing specific menu option
Menu will be colorful
Password Not shown on the screen while writing
*/
/*
import java.io.Console;
import java.util.Scanner;

public class Q23 {
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
        System.out.println(BLUE + "=== Welcome to Banking System ===" + RESET);
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


*/
/*
import java.io.Console;
import java.util.Scanner;
import java.io.*;

public class Q23 {
    // ANSI Color Codes for colorful menu
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    // user details
    static String email, password, fullName;
    static int age;

    //bank details
    static double jointBalance = 0, savingBalance = 0, childBalance = 0;
    static boolean jointActive = false, savingActive = false, childActive = false;

    // Store nominee/spouse/child details
    static String spouseName, nomineeName, childName;
    static int spouseAge, nomineeAge, guardianAge;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();

        // === USER REGISTRATION ===
        System.out.println(BLUE + "=== Welcome to Banking System ===" + RESET);

        // email validation
        while (true) {
            System.out.print("Enter your Email-Id: ");
            email = sc.nextLine();
            if (email.contains("@.com")) {
                break;
            } else {
                System.out.println(RED + "Invalid Email! Must contain '@'.com" + RESET);
            }
        }

        // password input with masking
        if (console != null) {
            char[] pwdArray = console.readPassword("Enter your Password: ");
            password = new String(pwdArray);
        } else {
            // Fallback if console is not available (like IDE)
            password = readPassword("Enter your Password: ");
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

    // custom method for password masking with '*'
    private static String readPassword(String prompt) throws IOException {
        System.out.print(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder password = new StringBuilder();
        while (true) {
            int ch = in.read();
            if (ch == '\n' || ch == '\r') {
                break;
            } else if (ch == '\b') { // backspace
                if (password.length() > 0) {
                    password.deleteCharAt(password.length() - 1);
                    System.out.print("\b \b");
                }
            } else {
                password.append((char) ch);
                System.out.print("*");
            }
        }
        System.out.println();
        return password.toString();
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
*/
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q23 {
    // ANSI Color Codes for colorful menu
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    // user details
    static String email, password, fullName;
    static int age;

    // bank details
    static double jointBalance = 0, savingBalance = 0, childBalance = 0;
    static boolean jointActive = false, savingActive = false, childActive = false;

    // Store nominee/spouse/child details
    static String spouseName, nomineeName, childName;
    static int spouseAge, nomineeAge, guardianAge;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // === USER REGISTRATION ===
        System.out.println(BLUE + "=== Welcome to Banking System ===" + RESET);

        // email validation
        while (true) {
            System.out.print("Enter your Email-Id: ");
            email = sc.nextLine();
            if (email.contains("@")) {
                break;
            } else {
                System.out.println(RED + "Invalid Email! Must contain '@.com'" + RESET);
            }
        }

        // password input with masking (always using custom method)
        password = readPassword("Enter your Password: ");

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
                case 5:
                    System.out.println(GREEN + "Thank you for using Banking System!" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice!" + RESET);
            }
            pause(sc);
        }
    }

    // custom method for password masking with '*'
    private static String readPassword(String prompt) throws IOException {
        System.out.print(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder password = new StringBuilder();
        while (true) {
            int ch = in.read();
            if (ch == '\n' || ch == '\r') {
                break;
            } else if (ch == '\b') { // backspace
                if (password.length() > 0) {
                    password.deleteCharAt(password.length() - 1);
                    System.out.print("\b \b");
                }
            } else {
                password.append((char) ch);
                System.out.print("*");
            }
        }
        System.out.println();
        return password.toString();
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
    static void bankingOperations(Scanner sc) throws IOException {
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
    static boolean verifyPassword(Scanner sc) throws IOException {
        String pass = readPassword("Enter password to continue: ");
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
*/
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q23 {
    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    // user details
    static String email, password, fullName;
    static int age;

    // bank details
    static double jointBalance = 0, savingBalance = 0, childBalance = 0;
    static boolean jointActive = false, savingActive = false, childActive = false;

    // nominee/spouse/child details
    static String spouseName, nomineeName, childName;
    static int spouseAge, nomineeAge, guardianAge;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // === USER REGISTRATION ===
        System.out.println(BLUE + "=== Welcome to Banking System ===" + RESET);

        // email validation (only @gmail.com allowed)
        while (true) {
            System.out.print("Enter your Gmail Id: ");
            email = sc.nextLine();
            if (email.endsWith("@gmail.com")) {
                break;
            } else {
                System.out.println(RED + "Invalid Email! Must end with '@gmail.com'" + RESET);
            }
        }

        // password input with real-time masking
        password = readPassword("Enter your Password: ");

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
                case 5:
                    System.out.println(GREEN + "Thank you for using Banking System!" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice!" + RESET);
            }
            pause(sc);
        }
    }

    // === custom password masking ===
    private static String readPassword(String prompt) throws IOException {
        System.out.print(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder password = new StringBuilder();
        while (true) {
            int ch = in.read();
            if (ch == '\n' || ch == '\r') {
                break;
            } else if (ch == '\b') { // backspace support
                if (password.length() > 0) {
                    password.deleteCharAt(password.length() - 1);
                    System.out.print("\b \b");
                }
            } else {
                password.append((char) ch);
                System.out.print("*"); // show * instead of real character
            }
        }
        System.out.println();
        return password.toString();
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
        }
    }*/
   /* import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q23 {
    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    // user details
    static String email, password, fullName;
    static int age;

    // bank details
    static double jointBalance = 0, savingBalance = 0, childBalance = 0;
    static boolean jointActive = false, savingActive = false, childActive = false;

    // nominee/spouse/child details
    static String spouseName, nomineeName, childName;
    static int spouseAge, nomineeAge, guardianAge;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // === USER REGISTRATION ===
        System.out.println(BLUE + "=== Welcome to Banking System ===" + RESET);

        // email validation (only @gmail.com allowed)
        while (true) {
            System.out.print("Enter your Gmail Id: ");
            email = sc.nextLine();
            if (email.endsWith("@gmail.com")) {
                break;
            } else {
                System.out.println(RED + "Invalid Email! Must end with '@gmail.com'" + RESET);
            }
        }

        // password input with real-time masking
        password = readPassword("Enter your Password: ");

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
                case 5:
                    System.out.println(GREEN + "Thank you for using Banking System!" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice!" + RESET);
            }
            pause(sc);
        }
    }

    // === custom password masking ===
    private static String readPassword(String prompt) throws IOException {
        System.out.print(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder password = new StringBuilder();
        while (true) {
            int ch = in.read();
            if (ch == '\n' || ch == '\r') {
                break;
            } else if (ch == '\b') { // backspace support
                if (password.length() > 0) {
                    password.deleteCharAt(password.length() - 1);
                    System.out.print("\b \b");
                }
            } else {
                password.append((char) ch);
                System.out.print("*"); // show * instead of real character
            }
        }
        System.out.println();
        return password.toString();
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
    static void bankingOperations(Scanner sc) throws IOException {
        if (!verifyPassword()) return;

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
    static boolean verifyPassword() throws IOException {
        String pass = readPassword("Enter password to continue: ");
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
*/
import java.util.Scanner;

public class Q23 {
    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    static Scanner sc = new Scanner(System.in);

    // === General Positive Age Validation ===
    static int validateAge(String prompt) {
        int age;
        while (true) {
            System.out.print(prompt);
            age = sc.nextInt();
            sc.nextLine();
            if (age > 0) return age;
            else System.out.println(RED + "Age must be positive!" + RESET);
        }
    }

    // === Validate Adult Age (>=18) ===
    static int validateAdultAge(String prompt) {
        int age;
        while (true) {
            System.out.print(prompt);
            age = sc.nextInt();
            sc.nextLine();
            if (age >= 18) return age;
            else System.out.println(RED + "Age must be 18 or above!" + RESET);
        }
    }

    // === Validate Child Age (<=18) ===
    static int validateChildAge(String prompt) {
        int age;
        while (true) {
            System.out.print(prompt);
            age = sc.nextInt();
            sc.nextLine();
            if (age > 0 && age <= 18) return age;
            else System.out.println(RED + "Child age must be between 1 and 18!" + RESET);
        }
    }

    // === Validate Guardian Age (>=21) ===
    static int validateGuardianAge(String prompt) {
        int age;
        while (true) {
            System.out.print(prompt);
            age = sc.nextInt();
            sc.nextLine();
            if (age >= 21) return age;
            else System.out.println(RED + "Guardian must be 21 or above!" + RESET);
        }
    }

    // === Main Function ===
    public static void main(String[] args) {
        System.out.println(YELLOW + "=== Welcome to Banking Management System ===" + RESET);

        // User details
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        int age = validateAdultAge("Enter your Age: ");  // main user must be 18+
        System.out.print("Enter your Email: ");
        String email = sc.nextLine();
        System.out.print("Enter your Password: ");
        String password = sc.nextLine();

        System.out.println(GREEN + "Account created successfully for " + name + RESET);

        // Now open account options
        openAccount();
    }

    // === Open Account Function ===
    static void openAccount() {
        System.out.println("\nChoose Account Type:");
        System.out.println("1. Joint Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Minor Account");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: // Joint Account
                System.out.print("Enter Spouse Name: ");
                String spouseName = sc.nextLine();
                int spouseAge = validateAdultAge("Enter Spouse Age: "); // must be >= 18
                System.out.print("Enter Minimum Deposit Amount: ");
                double jointDeposit = sc.nextDouble();
                System.out.println(GREEN + "Joint Account Created with Spouse: " + spouseName + ", Age: " + spouseAge + RESET);
                break;

            case 2: // Saving Account
                System.out.print("Enter Nominee Name: ");
                String nomineeName = sc.nextLine();
                int nomineeAge = validateAdultAge("Enter Nominee Age: "); // must be >= 18
                System.out.print("Enter Minimum Deposit Amount: ");
                double savingDeposit = sc.nextDouble();
                System.out.println(GREEN + "Saving Account Created with Nominee: " + nomineeName + ", Age: " + nomineeAge + RESET);
                break;

            case 3: // Minor Account
                System.out.print("Enter Child Name: ");
                String childName = sc.nextLine();
                int childAge = validateChildAge("Enter Child Age: "); // must be <= 18
                System.out.print("Enter Guardian Name: ");
                String guardianName = sc.nextLine();
                int guardianAge = validateGuardianAge("Enter Guardian Age: "); // must be >= 21
                System.out.print("Enter Minimum Deposit Amount: ");
                double minorDeposit = sc.nextDouble();
                System.out.println(GREEN + "Minor Account Created for Child: " + childName + ", Age: " + childAge +
                        " with Guardian: " + guardianName + ", Age: " + guardianAge + RESET);
                break;

            default:
                System.out.println(RED + "Invalid Choice!" + RESET);
        }
    }
}
