import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class jmb2328 {

    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE_BG = "\u001B[47m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(PURPLE + "==========================================" + RESET);
        System.out.println(PURPLE + "         WELCOME TO JMB HOTEL (JMB)       " + RESET);
        System.out.println(PURPLE + "==========================================" + RESET);

        // ✅ Customer name (only alphabets + spaces)
        String customerName = "";
        while (true) {
            System.out.print(YELLOW + "Enter Customer Name: " + RESET);
            customerName = sc.nextLine().trim();
            if (customerName.matches("[a-zA-Z ]+")) break;
            else System.out.println(RED + "Invalid name! Only alphabets allowed." + RESET);
        }

        // ✅ Mobile number (10 digits only)
        String mobileNo = "";
        while (true) {
            System.out.print(YELLOW + "Enter Mobile Number: " + RESET);
            mobileNo = sc.nextLine().trim();
            if (mobileNo.matches("\\d{10}")) break;
            else System.out.println(RED + "Invalid mobile number! Enter 10 digits only." + RESET);
        }

        // ✅ Booking date (dd-MM-yyyy)
        String bookingDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print(YELLOW + "Enter Booking Date (dd-MM-yyyy): " + RESET);
            bookingDate = sc.nextLine().trim();
            try {
                sdf.parse(bookingDate); // validation
                break;
            } catch (ParseException e) {
                System.out.println(RED + "Invalid date format! Use dd-MM-yyyy." + RESET);
            }
        }

        // ✅ Party size
        int partySize = getPositiveInt(sc, YELLOW + "Enter number of people in the party: " + RESET);

        int billNo = rand.nextInt(900000) + 100000;

        // ----- Variables for orders -----
        String thaliName = "";
        int thaliPrice = 0, thaliQty = 0, freeThalis = 0;

        String soupDrink = "", paneerDish = "", vegDish1 = "", vegDish2 = "", dalDish = "";
        String riceDish = "", rotiDish = "", starterDish = "", dessertType = "", dessertVariant = "", snack = "";

        String breakfastItem = "";
        int breakfastPrice = 0, breakfastQty = 0, freeBreakfastItems = 0;

        double subtotal = 0.0;
        boolean thaliOrdered = false, breakfastOrdered = false;
        boolean ordering = true;

        // ----- Main menu loop -----
        while (ordering) {
            System.out.println(CYAN + "\nMAIN MENU - Choose:" + RESET);
            System.out.println(GREEN + "1. Vegetarian Thali" + RESET);
            System.out.println(GREEN + "2. Breakfast" + RESET);
            System.out.println(GREEN + "3. Exit & Print Bill" + RESET);

            int mainChoice = getIntInRange(sc, CYAN + "Enter main choice (1-3): " + RESET, 1, 3);

            if (mainChoice == 1) { // Thali
                thaliOrdered = true;
                System.out.println(BLUE + "\nVEGETARIAN THALI MENU:" + RESET);
                System.out.println(YELLOW + "1. Thali 1 - Rs.310");
                System.out.println("2. Thali 2 - Rs.360");
                System.out.println("3. Thali 3 - Rs.410");
                System.out.println("4. Thali 4 - Rs.470");
                System.out.println("5. Thali 5 - Rs.600");
                System.out.println("6. Thali 6 - Rs.700" + RESET);

                int thaliChoice = getIntInRange(sc, "Select Thali number (1-6): ", 1, 6);
                switch (thaliChoice) {
                    case 1: thaliName = "Thali 1"; thaliPrice = 310; break;
                    case 2: thaliName = "Thali 2"; thaliPrice = 360; break;
                    case 3: thaliName = "Thali 3"; thaliPrice = 410; break;
                    case 4: thaliName = "Thali 4"; thaliPrice = 470; break;
                    case 5: thaliName = "Thali 5"; thaliPrice = 600; break;
                    case 6: thaliName = "Thali 6"; thaliPrice = 700; break;
                }

                System.out.print(YELLOW + "Confirm selection (yes/no): " + RESET);
                if (!sc.next().trim().equalsIgnoreCase("yes")) {
                    System.out.println(RED + "Selection cancelled. Returning to menu." + RESET);
                    sc.nextLine();
                    thaliOrdered = false;
                    continue;
                }
                sc.nextLine();

                thaliQty = getPositiveInt(sc, "Enter number of thalis: ");
                if (thaliQty < 25) { freeThalis = 2; }
                if (thaliQty > 100) { freeThalis = 5; }

                soupDrink = chooseSoupDrink(sc);
                paneerDish = choosePaneer(sc);
                vegDish1 = chooseVeg(sc, 1);
                vegDish2 = chooseVeg(sc, 2);
                dalDish = chooseDal(sc);
                starterDish = chooseStarter(sc);
                rotiDish = chooseRoti(sc);
                riceDish = chooseRice(sc);
                String[] dessert = chooseDessert(sc);
                dessertType = dessert[0]; dessertVariant = dessert[1];
                snack = choosesnack(sc, 1);

                subtotal += thaliPrice * thaliQty;

            } else if (mainChoice == 2) { // Breakfast
                breakfastOrdered = true;
                System.out.println(BLUE + "\nBREAKFAST MENU:" + RESET);
                System.out.println(YELLOW + "1. Poha + Jalebi + Tea/Coffee - Rs.200");
                System.out.println("2. Bread + Heavy Snacks + Tea/Coffee - Rs.250");
                System.out.println("3. Heavy Snacks + Tea/Coffee - Rs.320" + RESET);

                int bch = getIntInRange(sc, "Choose breakfast type (1-3): ", 1, 3);
                switch (bch) {
                    case 1: 
                    breakfastItem = "Poha + Jalebi + Tea/Coffee";
                     breakfastPrice = 200;
                      break;
                    case 2:
                         breakfastItem = "Bread + Heavy Snacks + Tea/Coffee"; 
                         breakfastPrice = 250;
                          break;
                    case 3:
                         breakfastItem = "Heavy Snacks + Tea/Coffee";
                          breakfastPrice = 320;
                           break;
                }

                System.out.print(YELLOW + "Confirm selection (yes/no): " + RESET);
                if (!sc.next().trim().equalsIgnoreCase("yes")) {
                    System.out.println(RED + "Selection cancelled. Returning to menu." + RESET);
                    sc.nextLine();
                    breakfastOrdered = false;
                    continue;
                }
                sc.nextLine();

                breakfastQty = getPositiveInt(sc, "Enter breakfast plates quantity: ");
                if (breakfastQty < 25) { freeBreakfastItems = 2; }
                subtotal += breakfastPrice * breakfastQty;

            } else {
                ordering = false;
            }
        }

        // ----- Bill Calculation -----
        double gstRate = 0;
        if (thaliOrdered) gstRate = 0.18;
        else if (breakfastOrdered) gstRate = 0.05;

        double gst = subtotal * gstRate;
        double discount = 0, totalAfterGST = subtotal + gst;
        if (totalAfterGST > 5000) discount = totalAfterGST * 0.10;
        double grandTotal = totalAfterGST - discount;

        String orderDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

        // ----- Print Bill -----
        System.out.println(WHITE_BG + BLACK);
        System.out.println("+------------------------------------------------------------+");
        System.out.printf("| %-55s%-12s |\n", "JMB HOTEL ,INDORE -- INVOICE", "");
        System.out.println("|------------------------------------------------------------|");
        System.out.printf("| Customer: %-48s|\n", customerName);
        System.out.printf("| Mobile: %-50s|\n", mobileNo);
        System.out.printf("| Booking Date: %-46s|\n", bookingDate);
        System.out.printf("| Party Size: %-47d|\n", partySize);
        System.out.printf("| Bill No: %-52d|\n", billNo);
        System.out.printf("| Order Creation Date/Time: %-36s|\n", orderDateTime);
        System.out.println("|------------------------------------------------------------|");
        System.out.printf("| %-60s|\n", "--- ITEMS ---");
        System.out.printf("| %-38s %-5s %-5s %-10s|\n", "Item", "Rate", "Qty", "Amount");
        System.out.println("|------------------------------------------------------------|");

        if (thaliOrdered) {
            System.out.printf("| %-38s %-5d %-5d %-10.2f|\n", thaliName, thaliPrice, thaliQty, (double) thaliPrice * thaliQty);
            if (freeThalis > 0) System.out.printf("| %-38s %-5s %-5d %-10s|\n", "FREE Thalis", "-", freeThalis, "FREE");
            System.out.printf("|  Soup/Drink: %-49s|\n", soupDrink);
            System.out.printf("|  Paneer: %-53s|\n", paneerDish);
            System.out.printf("|  Veg Dish 1: %-49s|\n", vegDish1);
            System.out.printf("|  Veg Dish 2: %-49s|\n", vegDish2);
            System.out.printf("|  Dal: %-56s|\n", dalDish);
            System.out.printf("|  Starter: %-52s|\n", starterDish);
            System.out.printf("|  Roti: %-55s|\n", rotiDish);
            System.out.printf("|  Rice: %-55s|\n", riceDish);
            System.out.printf("|  Dessert: %-52s|\n", dessertType + " - " + dessertVariant);
            System.out.printf("|  Snack: %-54s|\n", snack);
        }

        if (breakfastOrdered) {
            System.out.printf("| %-38s %-5d %-5d %-10.2f|\n", breakfastItem, breakfastPrice, breakfastQty, (double) breakfastPrice * breakfastQty);
            if (freeBreakfastItems > 0) System.out.printf("| %-38s %-5s %-5d %-10s|\n", "FREE Breakfast Items", "-", freeBreakfastItems, "FREE");
        }

        System.out.println("|------------------------------------------------------------|");
        System.out.printf("| %-48s %10.2f|\n", "Total (Before GST)", subtotal);
        System.out.printf("| %-48s %10.2f|\n", "GST (" + (int)(gstRate*100) + "%)", gst);
        if (discount > 0) System.out.printf("| %-48s %10.2f|\n", "DISCOUNT (10%)", -discount);
        System.out.printf("| %-48s %10.2f|\n", "GRAND TOTAL", grandTotal);
        System.out.println("|------------------------------------------------------------|");
        System.out.printf("| %-60s|\n", "Thank you for choosing JMB Hotel!");
        System.out.println("+------------------------------------------------------------+" + RESET);

        sc.close();
    }

    // ---------- Helper Methods ----------
    public static int getPositiveInt(Scanner sc, String prompt) {
        int v = -1;
        while (v <= 0) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                v = sc.nextInt();
                sc.nextLine();
                if (v <= 0) System.out.println(RED + "Enter a positive number." + RESET);
            } else {
                System.out.println(RED + "Invalid input." + RESET);
                sc.nextLine();
            }
        }
        return v;
    }

    public static int getIntInRange(Scanner sc, String prompt, int min, int max) {
        int v = Integer.MIN_VALUE;
        while (v < min || v > max) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                v = sc.nextInt();
                sc.nextLine();
                if (v < min || v > max) System.out.println(RED + "Enter a value between " + min + " and " + max + "." + RESET);
            } else {
                System.out.println(RED + "Invalid input." + RESET);
                sc.nextLine();
            }
        }
        return v;
    }

    // ---------- Menu Methods ----------
    public static String chooseSoupDrink(Scanner sc) {
        System.out.println(BLUE + "Choose Soup/Drink:" + RESET);
        System.out.println(YELLOW + "1. Tomato Soup\n 2. Veg Manchow \n 3. Lemon Coriander \n4. Hot & Sour Veg\n 5. Fresh Lime\n 6. Watermelon Juice\n 7. Mango Lassi\n 8. Strawberry Shake\n 9. Cold Coffee" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-9): ", 1, 9);
        switch (ch) {
            case 1:
                 return "Tomato Soup";
            case 2:
                 return "Veg Manchow";
            case 3:
                 return "Lemon Coriander";
            case 4:
                 return "Hot & Sour Veg";
            case 5:
                 return "Fresh Lime";
            case 6:
                 return "Watermelon Juice";
            case 7:
                 return "Mango Lassi";
            case 8:
                 return "Strawberry Shake";
            default:
                 return "Cold Coffee";
        }
    }

    public static String choosePaneer(Scanner sc) {
        System.out.println(BLUE + "Choose Paneer Dish:" + RESET);
        System.out.println(YELLOW + "1. Butter Masala \n 2. Kadai \n3. Punjabi\n 4. Kolhapuri" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1:
                 return "Butter Masala";
            case 2:
                 return "Kadai";
            case 3:
                 return "Punjabi";
            default:
                 return "Kolhapuri";
        }
    }

    public static String chooseVeg(Scanner sc, int num) {
        System.out.println(BLUE + "Choose Veg Dish #" + num + ":" + RESET);
        System.out.println(YELLOW + "1. Nav Ratan\n 2. Methi Mutter\n 3. Mix Veg\n 4. Aloo Mutter\n 5. Corn Palak\n 6. Bhindi Masala\n 7. Gujarati Aloo\n 8. Dum Aloo" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-8): ", 1, 8);
        switch (ch) {
            case 1: 
            return "Nav Ratan";
            case 2: 
            return "Methi Mutter";
            case 3: 
            return "Mix Veg";
            case 4:
                 return "Aloo Mutter";
            case 5:
                 return "Corn Palak";
            case 6:
                 return "Bhindi Masala";
            case 7:
                 return "Gujarati Aloo";
            default:
                 return "Dum Aloo";
        }
    }

    public static String chooseDal(Scanner sc) {
        System.out.println(BLUE + "Choose Dal:" + RESET);
        System.out.println(YELLOW + "1. Dal Fry 2. Dal Tadka 3. Dal Makhani" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        switch (ch) {
            case 1: 
            return "Dal Fry";
            case 2: 
            return "Dal Tadka";
            default:
                 return "Dal Makhani";
        }
    }

    public static String chooseStarter(Scanner sc) {
        System.out.println(BLUE + "Choose Starter:" + RESET);
        System.out.println(YELLOW + "1. Veg Manchurian 2. Spring Roll 3. Paneer Tikka 4. Corn Balls" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1: 
            return "Veg Manchurian";
            case 2:
                 return "Spring Roll";
            case 3:
                 return "Paneer Tikka";
            default:
                 return "Corn Balls";
        }
    }

    public static String chooseRoti(Scanner sc) {
        System.out.println(BLUE + "Choose Roti:" + RESET);
        System.out.println(YELLOW + "1. Tandoori \n 2. Butter\n  3. Missi\n 4. Laccha" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1: 
            return "Tandoori";
            case 2: 
            return "Butter";
            case 3: 
            return "Missi";
            default: 
            return "Laccha";
        }
    }

    public static String chooseRice(Scanner sc) {
        System.out.println(BLUE + "Choose Rice:" + RESET);
        System.out.println(YELLOW + "1. Steamed Rice \n 2. Jeera Rice \n 3. Veg Pulao" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        switch (ch) {
            case 1:
                 return "Steamed Rice";
            case 2: 
            return "Jeera Rice";
            default:
                 return "Veg Pulao";
        }
    }

    public static String[] chooseDessert(Scanner sc) {
        System.out.println(BLUE + "Choose Dessert:" + RESET);
        System.out.println(YELLOW + "1. Ice Cream \n 2. Gulab Jamun  \n 3. Cake" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        String type, variant = "";
        switch (ch) {
            case 1:
                type = "Ice Cream";
                System.out.println(YELLOW + "1. Vanilla\n 2. Strawberry \n 3. Chocolate" + RESET);
                int v = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
                if (v == 1) variant = "Vanilla"; else if (v == 2) variant = "Strawberry"; else variant = "Chocolate";
                break;
            case 2: type = "Gulab Jamun";
             variant = "Regular"; break;
            default: type = "Cake"; 
            variant = "Slice"; break;
        }
        return new String[]{type, variant};
    }

    public static String choosesnack(Scanner sc, int num) {
        System.out.println(BLUE + "Choose Heavy Snack #" + num + ":" + RESET);
        System.out.println(YELLOW + "1. Kachori \n 2. \n 3. Poha" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        switch (ch) {
            case 1:
                 return "Kachori";
            case 2:
                 return "Samosa";
            default:
                 return "Poha";
        }
    }
}
