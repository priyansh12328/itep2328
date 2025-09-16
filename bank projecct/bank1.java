import java.io.Console;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Q00023 {
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
    static int spouseAge, nomineeAge, guardianAge, childAge;

    // account numbers
    static String jointAccNo, savingAccNo, childAccNo;
    static final String IFSC = "BANK0001234";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println(BLUE + "=== Welcome to Banking System ===" + RESET);

        // email validation
        while (true) {
            System.out.print("Enter your Gmail Id: ");
            email = sc.nextLine();
            if (email.endsWith("@gmail.com")) break;
            else System.out.println(RED + "Invalid Email! Must end with '@gmail.com'" + RESET);
        }

        // password input with strength validation + masking
        password = readPassword("Enter your Password: ");

        // full name with validation
        fullName = validateName(sc, "Enter your Full Name: ");

        // validate main user age (must be >= 18)
        while (true) {
            System.out.print("Enter your Age: ");
            age = sc.nextInt();
            sc.nextLine();
            if (age >= 18) break;
            else System.out.println(RED + "Age must be 18 or above!" + RESET);
        }

        // === MENU LOOP ===
        while (true) {
            clearScreen();
            System.out.println(YELLOW + "===== Main Menu =====" + RESET);
            System.out.println("1. Open Account");
            System.out.println("2. Banking Operations");
            System.out.println("3. Display Passbook");
            System.out.println("4. Deactivate Account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: openAccount(sc); break;
                case 2: bankingOperations(sc); break;
                case 3: displayPassbook(); break;
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

    // === Password input with real-time masking and validation ===
    private static String readPassword(String prompt) {
        Console console = System.console();
        String pass;

        while (true) {
            if (console != null) {
                char[] pwdArray = console.readPassword(prompt);
                pass = new String(pwdArray);
            } else {
                // IDE fallback (Eclipse/IntelliJ)
                Scanner sc = new Scanner(System.in);
                System.out.print(prompt);
                pass = sc.nextLine();
            }

            if (isStrongPassword(pass)) break;
            else {
                System.out.println(RED + "Weak Password! Password must be at least 8 characters long, "
                        + "contain at least 1 digit and 1 special character." + RESET);
            }
        }
        return pass;
    }

    // === Strong Password Checker ===
    private static boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) hasDigit = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return hasDigit && hasSpecial;
    }

    // === Name Validation ===
    static String validateName(Scanner sc, String prompt) {
        String name;
        while (true) {
            System.out.print(prompt);
            name = sc.nextLine();
            if (name.matches("[a-zA-Z ]+")) { // only alphabets & spaces allowed
                break;
            } else {
                System.out.println(RED + "Invalid name! Only alphabets allowed." + RESET);
            }
        }
        return name;
    }

    // === Generate Random Account Number ===
    static String generateAccNo() {
        Random rand = new Random();
        long num = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(num);
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
            case 1: // Joint
                spouseName = validateName(sc, "Enter Spouse Name: ");
                while (true) {
                    System.out.print("Enter Spouse Age: ");
                    spouseAge = sc.nextInt();
                    sc.nextLine();
                    if (spouseAge >= 18) break;
                    else System.out.println(RED + "Spouse must be 18 or above!" + RESET);
                }
                System.out.print("Enter Initial Deposit (>=5000): ");
                jointBalance = sc.nextDouble();
                sc.nextLine();
                if (jointBalance >= 5000) {
                    jointActive = true;
                    jointAccNo = generateAccNo();
                    System.out.println(GREEN + "Joint Account Opened Successfully!" + RESET);
                    System.out.println("Account No: " + jointAccNo + " | IFSC: " + IFSC);
                } else {
                    System.out.println(RED + "Minimum 5000 required!" + RESET);
                }
                break;

            case 2: // Saving
                nomineeName = validateName(sc, "Enter Nominee Name: ");
                while (true) {
                    System.out.print("Enter Nominee Age: ");
                    nomineeAge = sc.nextInt();
                    sc.nextLine();
                    if (nomineeAge >= 18) break;
                    else System.out.println(RED + "Nominee must be 18 or above!" + RESET);
                }
                System.out.print("Enter Initial Deposit (>=2000): ");
                savingBalance = sc.nextDouble();
                sc.nextLine();
                if (savingBalance >= 2000) {
                    savingActive = true;
                    savingAccNo = generateAccNo();
                    System.out.println(GREEN + "Saving Account Opened Successfully!" + RESET);
                    System.out.println("Account No: " + savingAccNo + " | IFSC: " + IFSC);
                } else {
                    System.out.println(RED + "Minimum 2000 required!" + RESET);
                }
                break;

            case 3: // Child
                childName = validateName(sc, "Enter Child Name: ");
                while (true) {
                    System.out.print("Enter Child Age: ");
                    childAge = sc.nextInt();
                    sc.nextLine();
                    if (childAge > 0 && childAge <= 18) break;
                    else System.out.println(RED + "Child must be 1-18 years old!" + RESET);
                }
                while (true) {
                    System.out.print("Enter Guardian Age: ");
                    guardianAge = sc.nextInt();
                    sc.nextLine();
                    if (guardianAge >= 21) break;
                    else System.out.println(RED + "Guardian must be 21 or above!" + RESET);
                }
                System.out.print("Enter Initial Deposit (>=1000): ");
                childBalance = sc.nextDouble();
                sc.nextLine();
                if (childBalance >= 1000) {
                    childActive = true;
                    childAccNo = generateAccNo();
                    System.out.println(GREEN + "Child Account Opened Successfully!" + RESET);
                    System.out.println("Account No: " + childAccNo + " | IFSC: " + IFSC);
                } else {
                    System.out.println(RED + "Minimum 1000 required!" + RESET);
                }
                break;

            default:
                System.out.println(RED + "Invalid choice!" + RESET);
        }
    }

    // === Banking Operations ===
    static void bankingOperations(Scanner sc) {
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

    // === Passbook Display ===
    static void displayPassbook() {
        System.out.println(CYAN + "\n===== PASSBOOK =====" + RESET);
        System.out.println("Name: " + fullName + " | Age: " + age + " | Email: " + email);
        if (jointActive) {
            System.out.println("Joint Account => AccNo: " + jointAccNo + " | IFSC: " + IFSC +
                    " | Balance=" + jointBalance + " | Spouse=" + spouseName + " (Age: " + spouseAge + ")");
        }
        if (savingActive) {
            System.out.println("Saving Account => AccNo: " + savingAccNo + " | IFSC: " + IFSC +
                    " | Balance=" + savingBalance + " | Nominee=" + nomineeName + " (Age: " + nomineeAge + ")");
        }
        if (childActive) {
            System.out.println("Child Account => AccNo: " + childAccNo + " | IFSC: " + IFSC +
                    " | Balance=" + childBalance + " | Child=" + childName + " (Age: " + childAge + ")" +
                    " | Guardian Age=" + guardianAge);
        }
        System.out.println("==========================");
    }

    // === Deactivate Accounts ===
    static void deactivateAccount() {
        jointActive = savingActive = childActive = false;
        jointBalance = savingBalance = childBalance = 0;
        jointAccNo = savingAccNo = childAccNo = null;
        System.out.println(RED + "All accounts deactivated!" + RESET);
    }

    // === Password verification ===
    static boolean verifyPassword() {
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
