import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * Represents a simple banking management system.
 * This program allows a user to create one of three account types,
 * perform deposits and withdrawals, and display their details.
 * It simulates a console-based interface with colorful output.
 */
public class bank {

    // ANSI escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    // Bank details
    public static final String IFSC_CODE = "HDFC0001234";

    // A simple class to hold user information.
    static class User {
        String email;
        String password;
        String fullName;
        int age;
        String aadharNumber = "Not provided";
        String panNumber = "Not provided";
        boolean hasDebitCard = false;
    }

    // A class to represent a bank account.
    static class BankAccount {
        double balance;
        String accountType;
        String additionalDetails;
        String accountNumber;
    }

    // Static variables to hold the user and their account details for a single session.
    static User currentUser = new User();
    static BankAccount currentAccount = new BankAccount();
    static String transactionHistory = "No transactions yet.";

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    /**
     * Clears the console screen.
     */
    public static void clearScreen() {
        try {
            // ANSI escape codes to clear the screen
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            // Fallback for systems that don't support ANSI codes
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    /**
     * Main method to run the banking system.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        clearScreen();
        System.out.println(ANSI_CYAN + "=============================================");
        System.out.println("  " + ANSI_YELLOW + "Welcome to the Bank Management System" + ANSI_CYAN);
        System.out.println("=============================================" + ANSI_RESET);

        // Get basic user details
        getUserDetails();

        // Main loop for the banking operations
        boolean running = true;
        while (running) {
            clearScreen();
            showMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        openAccountMenu();
                        break;
                    case 2:
                        performTransactionMenu();
                        break;
                    case 3:
                        displayAccountDetails();
                        break;
                    case 4:
                        running = deactivateAccount();
                        break;
                    case 5:
                        applyForDebitCard();
                        break;
                    default:
                        System.out.println(ANSI_RED + "Invalid choice. Please try again." + ANSI_RESET);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid input. Please enter a number." + ANSI_RESET);
                scanner.nextLine(); // Consume the invalid input
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }

        scanner.close();
    }

    /**
     * Prompts the user for their initial details.
     */
    public static void getUserDetails() {
        System.out.println(ANSI_BLUE + "\nPlease enter your basic details:" + ANSI_RESET);

        System.out.print("Full Name: ");
        currentUser.fullName = scanner.nextLine();

        System.out.print("Age: ");
        while (true) {
            try {
                currentUser.age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid age. Please enter a number." + ANSI_RESET);
                scanner.nextLine(); // Consume invalid input
            }
        }

        System.out.print("Email ID: ");
        currentUser.email = scanner.nextLine();

        System.out.print("Create a password: ");
        currentUser.password = readPassword();
        System.out.println(ANSI_GREEN + "Thank you, " + currentUser.fullName + "! Your details are saved." + ANSI_RESET);
    }

    /**
     * Reads a password from the console without echoing characters.
     * This is a simple implementation for basic console environments.
     * It does not work on all systems and is not a secure way to handle passwords.
     * @return The entered password string.
     */
    private static String readPassword() {
        String password = "";
        while (true) {
            // Read a single character
            int ch;
            try {
                ch = System.in.read();
            } catch (Exception e) {
                break;
            }
            // If the character is a newline or carriage return, stop reading
            if (ch == '\n' || ch == '\r') {
                System.out.println();
                break;
            } else if (ch == 8 || ch == 127) { // Handle backspace
                if (password.length() > 0) {
                    password = password.substring(0, password.length() - 1);
                    System.out.print("\b \b");
                }
            } else {
                password += (char) ch;
                System.out.print("*");
            }
        }
        return password;
    }

    /**
     * Displays the main menu options.
     */
    public static void showMainMenu() {
        System.out.println(ANSI_CYAN + "=============================================");
        System.out.println(ANSI_YELLOW + "             Main Menu" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "=============================================");
        System.out.println(ANSI_PURPLE + "1. Open a New Account");
        System.out.println("2. Perform Transaction");
        System.out.println("3. Display Account Details");
        System.out.println("4. Deactivate Account");
        System.out.println("5. Apply for Debit Card" + ANSI_RESET);
        System.out.print(ANSI_GREEN + "Enter your choice: " + ANSI_RESET);
    }

    /**
     * Shows the menu for opening different account types.
     */
    public static void openAccountMenu() {
        if (currentAccount.accountType != null) {
            System.out.println(ANSI_RED + "You already have an active account." + ANSI_RESET);
            return;
        }

        clearScreen();
        System.out.println(ANSI_CYAN + "=============================================");
        System.out.println(ANSI_YELLOW + "             Open New Account" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "=============================================");
        System.out.println(ANSI_BLUE + "1. Joint Account (Min Deposit: 5000/-)");
        System.out.println("2. Savings Account (Min Deposit: 2000/-)");
        System.out.println("3. Child Account (Min Deposit: 1000/-)" + ANSI_RESET);
        System.out.print(ANSI_GREEN + "Enter your choice: " + ANSI_RESET);

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    createJointAccount();
                    break;
                case 2:
                    createSavingsAccount();
                    break;
                case 3:
                    createChildAccount();
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid choice. Account not created." + ANSI_RESET);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Invalid input. Account not created." + ANSI_RESET);
            scanner.nextLine(); // Consume invalid input
        }
    }

    /**
     * Generates a random 10-digit account number.
     * @return A string representing a random account number.
     */
    private static String generateAccountNumber() {
        long number = 1000000000L + (long) (random.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    /**
     * Creates a Joint Account.
     */
    public static void createJointAccount() {
        System.out.print(ANSI_BLUE + "Spouse's Full Name: " + ANSI_RESET);
        String spouseName = scanner.nextLine();
        System.out.print(ANSI_BLUE + "Spouse's Age: " + ANSI_RESET);
        int spouseAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print(ANSI_BLUE + "Initial Deposit (Minimum 5000): " + ANSI_RESET);
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (initialDeposit >= 5000) {
            currentAccount.accountType = "Joint Account";
            currentAccount.balance = initialDeposit;
            currentAccount.additionalDetails = "Spouse: " + spouseName + ", Age: " + spouseAge;
            currentAccount.accountNumber = generateAccountNumber();
            transactionHistory = "Account created with initial deposit of " + initialDeposit + "/-.";
            System.out.println(ANSI_GREEN + "\nJoint Account created successfully!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Initial deposit is less than the minimum required. Account not created." + ANSI_RESET);
        }
    }

    /**
     * Creates a Savings Account.
     */
    public static void createSavingsAccount() {
        System.out.print(ANSI_BLUE + "Nominee's Full Name: " + ANSI_RESET);
        String nomineeName = scanner.nextLine();
        System.out.print(ANSI_BLUE + "Nominee's Age: " + ANSI_RESET);
        int nomineeAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print(ANSI_BLUE + "Initial Deposit (Minimum 2000): " + ANSI_RESET);
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (initialDeposit >= 2000) {
            currentAccount.accountType = "Savings Account";
            currentAccount.balance = initialDeposit;
            currentAccount.additionalDetails = "Nominee: " + nomineeName + ", Age: " + nomineeAge;
            currentAccount.accountNumber = generateAccountNumber();
            transactionHistory = "Account created with initial deposit of " + initialDeposit + "/-.";
            System.out.println(ANSI_GREEN + "\nSavings Account created successfully!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Initial deposit is less than the minimum required. Account not created." + ANSI_RESET);
        }
    }

    /**
     * Creates a Child Account.
     */
    public static void createChildAccount() {
        System.out.print(ANSI_BLUE + "Child's Full Name: " + ANSI_RESET);
        String childName = scanner.nextLine();
        System.out.print(ANSI_BLUE + "Guardian/Father's Age: " + ANSI_RESET);
        int guardianAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print(ANSI_BLUE + "Initial Deposit (Minimum 1000): " + ANSI_RESET);
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (initialDeposit >= 1000) {
            currentAccount.accountType = "Child Account";
            currentAccount.balance = initialDeposit;
            currentAccount.additionalDetails = "Child Name: " + childName + ", Guardian's Age: " + guardianAge;
            currentAccount.accountNumber = generateAccountNumber();
            transactionHistory = "Account created with initial deposit of " + initialDeposit + "/-.";
            System.out.println(ANSI_GREEN + "\nChild Account created successfully!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Initial deposit is less than the minimum required. Account not created." + ANSI_RESET);
        }
    }

    /**
     * Shows the menu for performing a transaction.
     */
    public static void performTransactionMenu() {
        if (currentAccount.accountType == null) {
            System.out.println(ANSI_RED + "Please open an account first." + ANSI_RESET);
            return;
        }

        System.out.print("Please enter your password to continue: ");
        String enteredPassword = readPassword();

        if (enteredPassword.equals(currentUser.password)) {
            clearScreen();
            System.out.println(ANSI_CYAN + "=============================================");
            System.out.println(ANSI_YELLOW + "             Transaction Menu" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "=============================================");
            System.out.println(ANSI_BLUE + "1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Fund Transfer" + ANSI_RESET);
            System.out.print(ANSI_GREEN + "Enter your choice: " + ANSI_RESET);

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        depositFunds();
                        break;
                    case 2:
                        withdrawFunds();
                        break;
                    case 3:
                        fundTransfer();
                        break;
                    default:
                        System.out.println(ANSI_RED + "Invalid choice." + ANSI_RESET);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid input. Please enter a number." + ANSI_RESET);
                scanner.nextLine(); // Consume invalid input
            }
        } else {
            System.out.println(ANSI_RED + "Incorrect password. Transaction failed." + ANSI_RESET);
        }
    }

    /**
     * Handles depositing funds.
     */
    public static void depositFunds() {
        System.out.print(ANSI_BLUE + "Enter amount to deposit: " + ANSI_RESET);
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0) {
            currentAccount.balance += amount;
            if (transactionHistory.equals("No transactions yet.")) {
                transactionHistory = "Deposited " + amount + " to " + currentAccount.accountType + ".";
            } else {
                transactionHistory += "\nDeposited " + amount + " to " + currentAccount.accountType + ".";
            }
            System.out.println(ANSI_GREEN + "Deposit successful! New balance: " + currentAccount.balance + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Invalid amount." + ANSI_RESET);
        }
    }

    /**
     * Handles withdrawing funds.
     */
    public static void withdrawFunds() {
        System.out.print(ANSI_BLUE + "Enter amount to withdraw: " + ANSI_RESET);
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0 && amount <= currentAccount.balance) {
            currentAccount.balance -= amount;
            if (transactionHistory.equals("No transactions yet.")) {
                transactionHistory = "Withdrew " + amount + " from " + currentAccount.accountType + ".";
            } else {
                transactionHistory += "\nWithdrew " + amount + " from " + currentAccount.accountType + ".";
            }
            System.out.println(ANSI_GREEN + "Withdrawal successful! New balance: " + currentAccount.balance + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Insufficient funds or invalid amount." + ANSI_RESET);
        }
    }

    /**
     * Handles fund transfers.
     */
    public static void fundTransfer() {
        System.out.print(ANSI_BLUE + "Enter recipient's account number: " + ANSI_RESET);
        String recipientAccount = scanner.nextLine();
        System.out.print(ANSI_BLUE + "Enter amount to transfer: " + ANSI_RESET);
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0 && amount <= currentAccount.balance) {
            currentAccount.balance -= amount;
            if (transactionHistory.equals("No transactions yet.")) {
                transactionHistory = "Transferred " + amount + " to account " + recipientAccount + ".";
            } else {
                transactionHistory += "\nTransferred " + amount + " to account " + recipientAccount + ".";
            }
            System.out.println(ANSI_GREEN + "Transfer successful! New balance: " + currentAccount.balance + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Transfer failed. Insufficient funds or invalid amount." + ANSI_RESET);
        }
    }

    /**
     * Handles the debit card application with a simple KYC check.
     */
    public static void applyForDebitCard() {
        if (currentAccount.accountType == null) {
            System.out.println(ANSI_RED + "You must open an account before applying for a debit card." + ANSI_RESET);
            return;
        }

        if (currentUser.hasDebitCard) {
            System.out.println(ANSI_YELLOW + "You have already applied for a debit card." + ANSI_RESET);
            return;
        }

        System.out.print("Please enter your password to continue with KYC: ");
        String enteredPassword = readPassword();

        if (!enteredPassword.equals(currentUser.password)) {
            System.out.println(ANSI_RED + "Incorrect password. Application failed." + ANSI_RESET);
            return;
        }

        System.out.println(ANSI_BLUE + "\nTo complete the application, please provide KYC details." + ANSI_RESET);
        System.out.print("Enter Aadhar Card Number (12 digits): ");
        String aadhar = scanner.nextLine();

        System.out.print("Enter PAN Card Number (10 alphanumeric characters): ");
        String pan = scanner.nextLine();

        // Simple validation check for Aadhar and PAN length
        if (aadhar.length() == 12 && pan.length() == 10) {
            currentUser.aadharNumber = aadhar;
            currentUser.panNumber = pan;
            currentUser.hasDebitCard = true;
            System.out.println(ANSI_GREEN + "\nDebit card application submitted successfully!" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Your new debit card will be mailed to your address shortly." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Invalid Aadhar or PAN number. Application failed." + ANSI_RESET);
        }
    }

    /**
     * Displays all account and user details in a passbook-like format.
     */
    public static void displayAccountDetails() {
        clearScreen();
        System.out.println(ANSI_CYAN + "=============================================");
        System.out.println(ANSI_YELLOW + "             Passbook Details" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "=============================================" + ANSI_RESET);
        
        System.out.println(ANSI_BLUE + ">> Account Holder Details" + ANSI_RESET);
        System.out.println("---------------------------------------------");
        System.out.println(ANSI_PURPLE + "Name:" + ANSI_RESET + " " + currentUser.fullName);
        System.out.println(ANSI_PURPLE + "Age:" + ANSI_RESET + " " + currentUser.age);
        System.out.println(ANSI_PURPLE + "Email:" + ANSI_RESET + " " + currentUser.email);
        System.out.println(ANSI_PURPLE + "Aadhar Number:" + ANSI_RESET + " " + currentUser.aadharNumber);
        System.out.println(ANSI_PURPLE + "PAN Number:" + ANSI_RESET + " " + currentUser.panNumber);
        System.out.println();

        System.out.println(ANSI_BLUE + ">> Account Details" + ANSI_RESET);
        System.out.println("---------------------------------------------");
        if (currentAccount.accountType != null) {
            System.out.println(ANSI_PURPLE + "Account Type:" + ANSI_RESET + " " + currentAccount.accountType);
            System.out.println(ANSI_PURPLE + "Account Number:" + ANSI_RESET + " " + currentAccount.accountNumber);
            System.out.println(ANSI_PURPLE + "Bank IFSC:" + ANSI_RESET + " " + IFSC_CODE);
            System.out.println(ANSI_PURPLE + "Balance:" + ANSI_RESET + " " + currentAccount.balance + "/-");
            System.out.println(ANSI_PURPLE + "Additional Info:" + ANSI_RESET + " " + currentAccount.additionalDetails);
            System.out.println(ANSI_PURPLE + "Debit Card Status:" + ANSI_RESET + " " + (currentUser.hasDebitCard ? "Applied (will be delivered)" : "Not applied"));
        } else {
            System.out.println(ANSI_RED + "No account has been created yet." + ANSI_RESET);
        }
        System.out.println();
        
        System.out.println(ANSI_BLUE + ">> Transaction History" + ANSI_RESET);
        System.out.println("---------------------------------------------");
        System.out.println(ANSI_PURPLE + "All Transactions:\n" + ANSI_RESET + transactionHistory);
        System.out.println(ANSI_CYAN + "=============================================" + ANSI_RESET);
    }

    /**
     * Handles deactivating the account and exiting the program.
     * @return true if the program should continue, false to exit.
     */
    public static boolean deactivateAccount() {
        System.out.print(ANSI_RED + "Are you sure you want to deactivate your account? (yes/no): " + ANSI_RESET);
        String confirmation = scanner.nextLine().trim().toLowerCase();
        if (confirmation.equals("yes")) {
            System.out.println(ANSI_GREEN + "\nAccount has been deactivated. Goodbye!" + ANSI_RESET);
            return false;
        } else {
            System.out.println(ANSI_YELLOW + "\nDeactivation cancelled." + ANSI_RESET);
            return true;
        }
    }
}
