import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ad {

    // Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Welcome banner
        System.out.println(PURPLE + BOLD + "\n======================================");
        System.out.println("          WELCOME TO PARTY TIME        ");
        System.out.println("======================================\n" + RESET);

        // Customer details
        System.out.print(YELLOW + "Enter your Name: " + RESET);
        String customerName = sc.nextLine();

        System.out.print(YELLOW + "Enter number of People: " + RESET);
        int people = sc.nextInt();
        sc.nextLine();

        System.out.println(CYAN + "\nChoose Your Main Menu:" + RESET);
        System.out.println(GREEN + "1. Breakfast Menu" + RESET);
        System.out.println(GREEN + "2. Vegetarian Thali Menu" + RESET);

        System.out.print(YELLOW + "Enter choice (1/2): " + RESET);
        int mainChoice = sc.nextInt();
        sc.nextLine();

        double total = 0;
        if (mainChoice == 1) {
            total = breakfastMenu(sc, people);
        } else if (mainChoice == 2) {
            total = vegThaliMenu(sc, people);
        } else {
            System.out.println(RED + "Invalid Option!" + RESET);
            return;
        }

        // GST Calculation
        double gst = total * 0.05;
        double grandTotal = total + gst;

        // Print Invoice
        printBill(customerName, people, total, gst, grandTotal);
    }

    // ===========================
    // Breakfast Menu
    // ===========================
    public static double breakfastMenu(Scanner sc, int people) {
        System.out.println(CYAN + BOLD + "\n******** BREAKFAST MENU ********" + RESET);
        System.out.println(YELLOW + "A. Poha + Jalebi + Tea/Coffee - Rs. 200");
        System.out.println("B. Bread + Heavy Snacks + Tea/Coffee - Rs. 230");
        System.out.println("C. Heavy Snacks + Tea/Coffee - Rs. 250" + RESET);

        System.out.print(GREEN + "Choose your Breakfast Option (A/B/C): " + RESET);
        char choice = sc.next().toUpperCase().charAt(0);
        sc.nextLine();

        double price = 0;
        if (choice == 'A') price = 200;
        else if (choice == 'B') price = 230;
        else if (choice == 'C') price = 250;
        else System.out.println(RED + "Invalid!" + RESET);

        System.out.println(GREEN + "Would you like to add Ice Cream (Rs. 50)? (1-Yes, 0-No)" + RESET);
        int ice = sc.nextInt();
        if (ice == 1) price += 50;

        return price * people;
    }

    // ===========================
    // Vegetarian Thali Menu
    // ===========================
    public static double vegThaliMenu(Scanner sc, int people) {
        System.out.println(CYAN + BOLD + "\n******** VEGETARIAN THALI MENU ********" + RESET);
        System.out.println(YELLOW + "A. Rs. 310 - Soup/Drink, 1 Veg Dish, Paneer Dish, Roti/Naan, Papad");
        System.out.println("B. Rs. 360 - Soup/Drink, 2 Veg Dish, Paneer Dish, Roti/Naan, Salad");
        System.out.println("C. Rs. 410 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Rice");
        System.out.println("D. Rs. 470 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Rice, Ice Cream");
        System.out.println("E. Rs. 600 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Curd Dish, Rice, Ice Cream");
        System.out.println("F. Rs. 700 - Soup/Drink, 2 Veg Dish, Paneer Dish, Dal, Curd Dish, Rice, Ice Cream + Starter" + RESET);

        System.out.print(GREEN + "Choose your Thali Option (A-F): " + RESET);
        char choice = sc.next().toUpperCase().charAt(0);
        sc.nextLine();

        double price = 0;
        switch (choice) {
            case 'A': price = 310; break;
            case 'B': price = 360; break;
            case 'C': price = 410; break;
            case 'D': price = 470; break;
            case 'E': price = 600; break;
            case 'F': price = 700; break;
            default: System.out.println(RED + "Invalid!" + RESET);
        }

        // Show Menu Choices Step by Step
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
        System.out.println(YELLOW + "\nChoose Soup or Welcome Drink:" + RESET);
        System.out.println("1. Tomato Soup\n2. Veg Manchow\n3. Lemon Coriander\n4. Hot & Sour Veg\n5. Welcome Drink");
        sc.nextInt(); sc.nextLine();
    }

    public static void choosePaneerDish(Scanner sc) {
        System.out.println(YELLOW + "\nChoose Paneer Dish:" + RESET);
        System.out.println("1. Paneer Butter Masala\n2. Paneer Kadai\n3. Paneer Punjabi\n4. Paneer Kolhapuri\n5. Paneer Chatpatta");
        sc.nextInt(); sc.nextLine();
    }

    public static void chooseVegetable(Scanner sc) {
        System.out.println(YELLOW + "\nChoose Vegetable Dish:" + RESET);
        System.out.println("1. Nav Ratan Korma\n2. Methi Mutter Malai\n3. Mix Veg\n4. Corn Palak\n5. Bhindi Masala");
        sc.nextInt(); sc.nextLine();
    }

    public static void chooseDal(Scanner sc) {
        System.out.println(YELLOW + "\nChoose Dal:" + RESET);
        System.out.println("1. Dal Fry\n2. Dal Tadka\n3. Dal Makhani\n4. Dal Panchrangi");
        sc.nextInt(); sc.nextLine();
    }

    public static void chooseCurdDish(Scanner sc) {
        System.out.println(YELLOW + "\nChoose Curd Dish:" + RESET);
        System.out.println("1. Boondi Raita\n2. Aloo Raita\n3. Mix Raita\n4. Fruit Raita");
        sc.nextInt(); sc.nextLine();
    }

    public static void chooseRice(Scanner sc) {
        System.out.println(YELLOW + "\nChoose Rice:" + RESET);
        System.out.println("1. Jeera Rice\n2. Veg Pulao\n3. Veg Fried Rice\n4. Veg Biryani");
        sc.nextInt(); sc.nextLine();
    }

    public static void chooseRoti(Scanner sc) {
        System.out.println(YELLOW + "\nChoose Roti Type:" + RESET);
        System.out.println("1. Roti\n2. Naan\n3. Missi Roti\n4. Methi Pooni");
        sc.nextInt(); sc.nextLine();
    }

    public static void chooseDessert(Scanner sc) {
        System.out.println(YELLOW + "\nChoose Dessert:" + RESET);
        System.out.println("1. Gulab Jamun\n2. Rasgulla\n3. Kesar Halwa\n4. Ice Cream");
        sc.nextInt(); sc.nextLine();
    }

    // ===========================
    // Print Bill
    // ===========================
    public static void printBill(String name, int people, double total, double gst, double grand) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, EEEE");

        System.out.println(PURPLE + BOLD + "\n================ INVOICE ================" + RESET);
        System.out.println(BLUE + "Hotel: " + RESET + "Party Time Restaurant");
        System.out.println(BLUE + "Customer Name: " + RESET + name);
        System.out.println(BLUE + "Booking Date: " + RESET + today.format(formatter));
        System.out.println(BLUE + "Number of Guests: " + RESET + people);
        System.out.println("----------------------------------------");
        System.out.println(GREEN + "Total (Before GST): Rs. " + total + RESET);
        System.out.println(GREEN + "GST (5%): Rs. " + gst + RESET);
        System.out.println(YELLOW + BOLD + "Grand Total: Rs. " + grand + RESET);
        System.out.println(PURPLE + BOLD + "========================================" + RESET);
        System.out.println(PURPLE + "Thank You! Visit Again!" + RESET);
    }
}
