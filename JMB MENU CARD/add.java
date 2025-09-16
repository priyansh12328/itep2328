import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class add {

    // Text Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    // Background Colors
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Welcome banner
        System.out.println(PURPLE + BOLD + "\n======================================");
        System.out.println("          WELCOME TO JMB HOTEL       ");
        System.out.println("======================================\n" + RESET);

        // Customer details
        System.out.print(YELLOW + "Enter your Name: " + RESET);
        String customerName = sc.nextLine();

        int people = getValidNumber(sc, "Enter number of People: ");

        int mainChoice;
        do {
            System.out.println(CYAN + "\nChoose Your Main Menu:" + RESET);
            System.out.println(GREEN + "1. Breakfast Menu" + RESET);
            System.out.println(GREEN + "2. Vegetarian Thali Menu" + RESET);
            System.out.print(YELLOW + "Enter choice (1/2): " + RESET);
            mainChoice = sc.nextInt();
            sc.nextLine();
            if (mainChoice != 1 && mainChoice != 2) {
                System.out.println(RED + "Invalid Option! Try again." + RESET);
            }
        } while (mainChoice != 1 && mainChoice != 2);

        double total = 0;
        if (mainChoice == 1) {
            total = breakfastMenu(sc, people);
        } else {
            total = vegThaliMenu(sc, people);
        }

        // GST Calculation
        double gst = total * 0.05;
        double grandTotal = total + gst;

        // Print Invoice
        printBill(customerName, people, total, gst, grandTotal);
    }

    // Get valid integer
    public static int getValidNumber(Scanner sc, String message) {
        int num;
        while (true) {
            System.out.print(YELLOW + message + RESET);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine();
                if (num > 0) return num;
                else System.out.println(RED + "Enter a positive number!" + RESET);
            } else {
                System.out.println(RED + "Invalid input! Enter a number." + RESET);
                sc.nextLine();
            }
        }
    }

    // ===========================
    // Breakfast Menu
    // ===========================
    public static double breakfastMenu(Scanner sc, int people) {
        char choice;
        double price = 0;
        do {
            System.out.println(CYAN + BOLD + "\n******** BREAKFAST MENU ********" + RESET);
            System.out.println(YELLOW + "A. Poha + Jalebi + Tea/Coffee - Rs. 200");
            System.out.println("B. Bread + Heavy Snacks + Tea/Coffee - Rs. 230");
            System.out.println("C. Heavy Snacks + Tea/Coffee - Rs. 250" + RESET);

            System.out.print(GREEN + "Choose your Breakfast Option (A/B/C): " + RESET);
            choice = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            if (choice == 'A') price = 200;
            else if (choice == 'B') price = 230;
            else if (choice == 'C') price = 250;
            else System.out.println(RED + "Invalid! Try again." + RESET);

        } while (choice != 'A' && choice != 'B' && choice != 'C');

        System.out.println(GREEN + "Would you like to add Ice Cream (Rs. 50)? (1-Yes, 0-No)" + RESET);
        int ice = sc.nextInt();
        if (ice == 1) price += 50;

        return price * people;
    }

    // ===========================
    // Vegetarian Thali Menu
    // ===========================
    public static double vegThaliMenu(Scanner sc, int people) {
        char choice;
        double price = 0;
        do {
            System.out.println(CYAN + BOLD + "\n******** VEGETARIAN THALI MENU ********" + RESET);
            System.out.println(YELLOW + "A. Rs. 310 - Soup/Drink, 1 Veg Dish, Paneer Dish, Roti/Naan, Papad");
            System.out.println("B. Rs. 360 - Soup/Drink, 2 Veg Dish, Paneer Dish, Roti/Naan, Salad");
            System.out.println("C. Rs. 410 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Rice");
            System.out.println("D. Rs. 470 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Rice, Ice Cream");
            System.out.println("E. Rs. 600 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Curd Dish, Rice, Ice Cream");
            System.out.println("F. Rs. 700 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Curd Dish, Rice, Ice Cream + Starter" + RESET);

            System.out.print(GREEN + "Choose your Thali Option (A-F): " + RESET);
            choice = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            if (choice == 'A') price = 310;
            else if (choice == 'B') price = 360;
            else if (choice == 'C') price = 410;
            else if (choice == 'D') price = 470;
            else if (choice == 'E') price = 600;
            else if (choice == 'F') price = 700;
            else System.out.println(RED + "Invalid! Try again." + RESET);

        } while (choice < 'A' || choice > 'F');

        chooseSoupOrDrink(sc);
        choosePaneerDish(sc);
        chooseVegetable(sc);
        chooseDal(sc);
        chooseCurdDish(sc);
        chooseRice(sc);
        chooseRoti(sc);
        chooseDessert(sc);

        System.out.println(GREEN + "Would you like to add a Mocktail (Rs. 100)? (1-Yes, 0-No)" + RESET);
        int mock = sc.nextInt();
        if (mock == 1) price += 100;

        return price * people;
    }

    // ===========================
    // Sub-Menu Selections
    // ===========================
    public static void chooseSoupOrDrink(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Soup or Welcome Drink:", 
            new String[]{"Tomato Soup", "Veg Manchow", "Lemon Coriander", "Hot & Sour Veg", "Welcome Drink"});
    }

    public static void choosePaneerDish(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Paneer Dish:", 
            new String[]{"Paneer Butter Masala", "Paneer Kadai", "Paneer Punjabi", "Paneer Kolhapuri", "Paneer Chatpatta"});
    }

    public static void chooseVegetable(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Vegetable Dish:", 
            new String[]{"Nav Ratan Korma", "Methi Mutter Malai", "Mix Veg", "Corn Palak", "Bhindi Masala"});
    }

    public static void chooseDal(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Dal:", 
            new String[]{"Dal Fry", "Dal Tadka", "Dal Makhani", "Dal Panchrangi"});
    }

    public static void chooseCurdDish(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Curd Dish:", 
            new String[]{"Boondi Raita", "Aloo Raita", "Mix Raita", "Fruit Raita"});
    }

    public static void chooseRice(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Rice:", 
            new String[]{"Jeera Rice", "Veg Pulao", "Veg Fried Rice", "Veg Biryani"});
    }

    public static void chooseRoti(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Roti Type:", 
            new String[]{"Roti", "Naan", "Missi Roti", "Methi Pooni"});
    }

    public static void chooseDessert(Scanner sc) {
        chooseMenuOption(sc, "\nChoose Dessert:", 
            new String[]{"Gulab Jamun", "Rasgulla", "Kesar Halwa", "Ice Cream"});
    }

    public static void chooseMenuOption(Scanner sc, String title, String[] options) {
        int choice = -1;
        do {
            System.out.println(YELLOW + title + RESET);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print(GREEN + "Enter your choice: " + RESET);
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice >= 1 && choice <= options.length) {
                    break;
                } else {
                    System.out.println(RED + "Invalid choice! Try again." + RESET);
                }
            } else {
                System.out.println(RED + "Enter a valid number!" + RESET);
                sc.nextLine();
            }
        } while (true);
    }

    // ===========================
    // Print Bill
    // ===========================
    public static void printBill(String name, int people, double total, double gst, double grand) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, EEEE");

        System.out.println(BG_PURPLE + BOLD + "\n================ INVOICE ================" + RESET);
        System.out.println(BG_BLUE + BLUE + "Hotel: " + RESET + "Jmb HOTEL");
        System.out.println(BG_BLUE + BLUE + "Customer Name: " + RESET + name);
        System.out.println(BG_BLUE + BLUE + "Booking Date: " + RESET + today.format(formatter));
        System.out.println(BG_BLUE + BLUE + "Number of Guests: " + RESET + people);
        System.out.println("----------------------------------------");
        System.out.println(GREEN + "Total (Before GST): Rs. " + total + RESET);
        System.out.println(GREEN + "GST (5%): Rs. " + gst + RESET);
        System.out.println(YELLOW + BOLD + "Grand Total: Rs. " + grand + RESET);
        System.out.println(BG_PURPLE + BOLD + "========================================" + RESET);
        System.out.println(PURPLE + "Thank You! Visit Again!" + RESET);
    }
}
