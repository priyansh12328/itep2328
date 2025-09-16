import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ad1 {
    // Text Colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    // Backgrounds
    public static final String BG_WHITE = "\u001B[47m";
    public static final String BG_BLUE = "\u001B[44m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Welcome
        System.out.println(PURPLE + BOLD + "\n======================================");
        System.out.println("          WELCOME TO JMB HOTEL        ");
        System.out.println("======================================\n" + RESET);

        System.out.print(YELLOW + "Enter your Name: " + RESET);
        String customerName = sc.nextLine().trim();

        int partyPeople = getPositiveInt(sc, "Enter number of people in the party: ");

        // Booking date (user can enter a booking date different from today)
        String bookingDate = getValidDateString(sc, "Enter Booking Date (dd-MM-yyyy): ");

        // Choose main menu
        int mainChoice = 0;
        do {
            System.out.println(CYAN + "\nChoose Your Main Menu:" + RESET);
            System.out.println(GREEN + "1. Breakfast Menu" + RESET);
            System.out.println(GREEN + "2. Vegetarian Thali Menu" + RESET);
            mainChoice = getPositiveInt(sc, "Enter choice (1 or 2): ");
            if (mainChoice != 1 && mainChoice != 2) {
                System.out.println(RED + "Invalid Option. Please enter 1 or 2." + RESET);
            }
        } while (mainChoice != 1 && mainChoice != 2);

        // We'll accumulate bill lines in a StringBuilder and track total.
        StringBuilder billLines = new StringBuilder();
        double totalBeforeGST = 0.0;

        if (mainChoice == 1) {
            // Breakfast - show full breakfast menu and let user pick items and quantities
            double subtotal = handleBreakfastMenu(sc, billLines);
            totalBeforeGST += subtotal;
        } else {
            // Vegetarian Thali - choose thali type, ask quantities, show included items and ask for choices where needed
            ThaliResult tr = handleVegThaliMenu(sc);
            // multiply by quantity asked
            int thaliQty = tr.quantity;
            double thaliUnitPrice = tr.unitPrice;
            // Add lines for thali (per-unit displayed)
            billLines.append(String.format("%-35s %8s %6s %10s\n", tr.thaliName, "Rate", "Qty", "Amount"));
            billLines.append(String.format("%-35s %8.2f %6d %10.2f\n", tr.thaliName, thaliUnitPrice, thaliQty, thaliUnitPrice * thaliQty));
            totalBeforeGST += thaliUnitPrice * thaliQty;

            // Append described chosen items (soup/drink, veg dishes, etc.) with quantity (usually equal to thaliQty)
            // For each sub-selection provided in tr.chosenItems[], add to bill as separate lines with 0 cost (these are part of thali)
            for (int i = 0; i < tr.chosenCount; i++) {
                String item = tr.chosenItems[i];
                if (item != null && item.length() > 0) {
                    billLines.append(String.format("%-35s %8s %6d %10s\n", "  (Included) " + item, "-", thaliQty, "-"));
                }
            }

            // If free thalis to add (promotion)
            if (thaliQty > 100) {
                billLines.append(String.format("%-35s %8s %6d %10s\n", "FREE OFFER: 5 Free Thalis", "-", 5, "FREE"));
            }
            // Note: any extras like icecream are charged; include them from tr.extras
            if (tr.extraCharge > 0) {
                billLines.append(String.format("%-35s %8.2f %6d %10.2f\n", "Extras (Ice Cream or Starter)", tr.extraCharge, 1, tr.extraCharge));
                totalBeforeGST += tr.extraCharge;
            }
        }

        // Ask user if they want any additional items (from full menu) - optional
        System.out.println("\nDo you want to add any extra single items (snacks/starters/curd/sweets)? (1-Yes / 0-No)");
        int addExtras = getZeroOne(sc);
        if (addExtras == 1) {
            double extrasTotal = handleExtraItems(sc, billLines);
            totalBeforeGST += extrasTotal;
        }

        // Promotion: If more than 100 thalis ordered earlier, add 5 free thalis in invoice (we handled display above).
        // GST and final total
        double gst = roundTwoDecimals(totalBeforeGST * 0.05);
        double grandTotal = roundTwoDecimals(totalBeforeGST + gst);

        // current date-time as order creation
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Random bill number
        int billNo = new Random().nextInt(900000) + 100000; // 6-digit

        // Print professional bill in white bg / black text in a square box
        printReceiptBox(customerName, partyPeople, bookingDate, now.format(dtf), billNo, billLines.toString(),
                totalBeforeGST, gst, grandTotal);

        System.out.println("\n" + GREEN + "Thank you! Your professional invoice has been printed above." + RESET);
        sc.close();
    }

    // ------------ Utility & Handlers --------------

    public static int getPositiveInt(Scanner sc, String prompt) {
        int v = -1;
        while (v <= 0) {
            System.out.print(YELLOW + prompt + RESET);
            if (sc.hasNextInt()) {
                v = sc.nextInt();
                sc.nextLine();
                if (v <= 0) {
                    System.out.println(RED + "Please enter a positive integer." + RESET);
                }
            } else {
                System.out.println(RED + "Invalid input. Enter a number." + RESET);
                sc.nextLine();
            }
        }
        return v;
    }

    public static int getZeroOne(Scanner sc) {
        int v = -1;
        while (v != 0 && v != 1) {
            System.out.print(YELLOW + "Enter 1 for Yes, 0 for No: " + RESET);
            if (sc.hasNextInt()) {
                v = sc.nextInt();
                sc.nextLine();
                if (v != 0 && v != 1) System.out.println(RED + "Please enter 1 or 0." + RESET);
            } else {
                System.out.println(RED + "Invalid input." + RESET);
                sc.nextLine();
            }
        }
        return v;
    }

    public static String getValidDateString(Scanner sc, String prompt) {
        String s;
        while (true) {
            System.out.print(YELLOW + prompt + RESET);
            s = sc.nextLine().trim();
            // Basic check for format dd-MM-yyyy (not full validation)
            if (s.matches("\\d{2}-\\d{2}-\\d{4}")) {
                return s;
            } else {
                System.out.println(RED + "Invalid format. Use dd-MM-yyyy." + RESET);
            }
        }
    }

    // Handles breakfast menu; returns subtotal for selected breakfast items
    public static double handleBreakfastMenu(Scanner sc, StringBuilder billLines) {
        // Define breakfast items with unit prices (index 1..3)
        String[] breakfastNames = new String[] {
                "", // dummy 0
                "Poha + Jalebi + Tea/Coffee",
                "Bread + Heavy Snacks + Tea/Coffee",
                "Heavy Snacks + Tea/Coffee"
        };
        double[] breakfastPrice = new double[] { 0, 200.0, 230.0, 250.0 };

        int choice = -1;
        do {
            System.out.println(CYAN + "\nBREAKFAST MENU" + RESET);
            for (int i = 1; i <= 3; i++) {
                System.out.printf("%d. %s - Rs. %.2f\n", i, breakfastNames[i], breakfastPrice[i]);
            }
            choice = getPositiveInt(sc, "Choose Breakfast Option (1-3): ");
            if (choice < 1 || choice > 3) {
                System.out.println(RED + "Invalid choice. Choose 1-3." + RESET);
            }
        } while (choice < 1 || choice > 3);

        int qty = getPositiveInt(sc, "Enter quantity for the selected breakfast (how many plates): ");
        double lineTotal = breakfastPrice[choice] * qty;
        billLines.append(String.format("%-35s %8.2f %6d %10.2f\n", breakfastNames[choice], breakfastPrice[choice], qty, lineTotal));
        return lineTotal;
    }

    // Result holder for thali selection (no classes allowed so simple structure)
    static class ThaliResult {
        String thaliName;
        double unitPrice;
        int quantity;
        String[] chosenItems = new String[20]; // hold chosen included items descriptions
        int chosenCount = 0;
        double extraCharge = 0.0; // for charged extras like ice cream or starter
    }

    public static ThaliResult handleVegThaliMenu(Scanner sc) {
        ThaliResult tr = new ThaliResult();
        // Thali descriptions and prices
        String[] thaliNames = new String[] {
            "", 
            "Thali 1 (Rs.310) - Soup/Drink, 1 Veg, Paneer, Roti/Naan, Papad",
            "Thali 2 (Rs.360) - Soup/Drink, 2 Veg, Paneer, Roti/Naan, Salad",
            "Thali 3 (Rs.410) - Soup/Drink, 2 Veg, Paneer, Dal, Rice",
            "Thali 4 (Rs.470) - Soup/Drink, 2 Veg, Paneer, Dal, Rice, Ice Cream(charged included)",
            "Thali 5 (Rs.600) - Soup/Drink, 2 Veg, Paneer, Dal, Curd, Rice, Ice Cream",
            "Thali 6 (Rs.700) - Soup/Drink, 2 Veg, Paneer, Dal, Curd, Rice, Ice Cream + Starter"
        };
        double[] thaliPrice = new double[] {0, 310, 360, 410, 470, 600, 700};

        int choice = -1;
        do {
            System.out.println(CYAN + "\nVEGETARIAN THALI MENU" + RESET);
            for (int i = 1; i <= 6; i++) {
                System.out.printf("%d. %s\n", i, thaliNames[i]);
            }
            choice = getPositiveInt(sc, "Choose Thali Option (1-6): ");
            if (choice < 1 || choice > 6) {
                System.out.println(RED + "Invalid choice. Choose 1-6." + RESET);
            }
        } while (choice < 1 || choice > 6);

        tr.thaliName = "Thali " + choice;
        tr.unitPrice = thaliPrice[choice];

        // number of thalis
        tr.quantity = getPositiveInt(sc, "Enter number of Thalis you want to order: ");

        // If more than 100 thalis => add 5 free
        if (tr.quantity > 100) {
            // we don't modify price; we will display free 5 in invoice
            // nothing else to do here
        }

        // All thalis include choice between soup OR welcome drink (per your instruction)
        System.out.println("\nThali includes Soup OR Welcome Drink. Choose one:");
        String soup = chooseFromList(sc, "Select 1 option:", new String[] {
            "Tomato Soup", "Veg Manchow", "Lemon Coriander", "Hot & Sour Veg", "Welcome Drink"
        });
        tr.chosenItems[tr.chosenCount++] = soup;

        // Paneer dish selection (choose one)
        String paneer = chooseFromList(sc, "Choose Paneer Dish (one):", new String[] {
            "Paneer Butter Masala", "Paneer Kadai", "Paneer Punjabi", "Paneer Kolhapuri", "Paneer Chatpatta"
        });
        tr.chosenItems[tr.chosenCount++] = paneer;

        // Veg dish(s) selection: some thalis have 1 veg, others have 2 veg
        int vegCount = (choice == 1) ? 1 : 2; // Thali 1 has 1 veg, others have 2 as per earlier mapping
        for (int i = 1; i <= vegCount; i++) {
            String veg = chooseFromList(sc, "Choose Vegetable Dish #" + i + ":", new String[] {
                "Nav Ratan Korma", "Methi Mutter Malai", "Mix Veg", "Corn Palak", "Bhindi Masala", "Aloo Mutter"
            });
            tr.chosenItems[tr.chosenCount++] = veg;
        }

        // Dal (if applicable for thali 3,4,5,6)
        if (choice >= 3) {
            String dal = chooseFromList(sc, "Choose Dal:", new String[] {
                "Dal Fry", "Dal Tadka", "Dal Makhani", "Dal Panchrangi"
            });
            tr.chosenItems[tr.chosenCount++] = dal;
        }

        // Curd dish (if applicable thali 5 or 6)
        if (choice == 5 || choice == 6) {
            String curd = chooseFromList(sc, "Choose Curd Dish:", new String[] {
                "Boondi Raita", "Aloo Raita", "Mix Raita", "Fruit Raita"
            });
            tr.chosenItems[tr.chosenCount++] = curd;
        }

        // Rice (if thali includes rice; thali 3-6 include rice)
        if (choice >= 3) {
            String rice = chooseFromList(sc, "Choose Rice:", new String[] {
                "Jeera Rice", "Veg Pulao", "Veg Fried Rice", "Veg Biryani"
            });
            tr.chosenItems[tr.chosenCount++] = rice;
        }

        // Roti type (all thalis)
        String roti = chooseFromList(sc, "Choose Roti Type:", new String[] {
            "Roti", "Naan", "Missi Roti", "Methi Puri"
        });
        tr.chosenItems[tr.chosenCount++] = roti;

        // Dessert: thali 4,5,6 include Ice Cream (but earlier we treated D includes ice cream included)
        if (choice == 4 || choice == 5 || choice == 6) {
            // Ice cream is included for these; just note it as included
            tr.chosenItems[tr.chosenCount++] = "Ice Cream (Included)";
        } else {
            // For thali 1-3 ask if customer wants dessert as extra (chargeable)
            System.out.println("\nDo you want to add Ice Cream as extra Rs.50? (1-Yes / 0-No)");
            int ice = getZeroOne(sc);
            if (ice == 1) {
                tr.extraCharge += 50.0;
                tr.chosenItems[tr.chosenCount++] = "Ice Cream (Extra)";
            }
        }

        // For thali 6 there is a Starter included; treat it as included
        if (choice == 6) {
            tr.chosenItems[tr.chosenCount++] = "Starter (Included)";
        }

        // Note: no mocktail option per latest instruction (removed)

        return tr;
    }

    // Helper that displays options and returns chosen string; input validated
    public static String chooseFromList(Scanner sc, String prompt, String[] options) {
        int choice = -1;
        do {
            System.out.println(YELLOW + prompt + RESET);
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d. %s\n", i + 1, options[i]);
            }
            choice = getPositiveInt(sc, "Enter choice (1-" + options.length + "): ");
            if (choice < 1 || choice > options.length) {
                System.out.println(RED + "Invalid choice. Try again." + RESET);
            }
        } while (choice < 1 || choice > options.length);
        return options[choice - 1];
    }

    // Extra single item additions (starters/snacks/curd/sweets)
    public static double handleExtraItems(Scanner sc, StringBuilder billLines) {
        double extrasTotal = 0.0;
        boolean more = true;
        while (more) {
            System.out.println(CYAN + "\nExtra Items Menu (choose one):" + RESET);
            System.out.println("1. Paneer Tikka (Rs.120)\n2. Veg Manchurian (Rs.100)\n3. Sweets - Gulab Jamun (Rs.40)\n4. Fruit Salad (Rs.60)\n5. Boondi Raita (Rs.50)");
            int c = getPositiveInt(sc, "Enter your choice (1-5): ");
            double price = 0;
            String name = "";
            switch (c) {
                case 1: name = "Paneer Tikka"; price = 120; break;
                case 2: name = "Veg Manchurian"; price = 100; break;
                case 3: name = "Gulab Jamun (Sweet)"; price = 40; break;
                case 4: name = "Fruit Salad"; price = 60; break;
                case 5: name = "Boondi Raita"; price = 50; break;
                default:
                    System.out.println(RED + "Invalid choice." + RESET);
                    continue;
            }
            int qty = getPositiveInt(sc, "Enter quantity: ");
            double line = price * qty;
            billLines.append(String.format("%-35s %8.2f %6d %10.2f\n", name, price, qty, line));
            extrasTotal += line;

            System.out.println("\nAdd more extras? (1-Yes / 0-No)");
            int moreChoice = getZeroOne(sc);
            if (moreChoice == 0) more = false;
        }
        return extrasTotal;
    }

    // Print receipt inside a box with white background
    public static void printReceiptBox(String customerName, int partyPeople, String bookingDate,
                                       String creationDateTime, int billNo, String billBody,
                                       double totalBeforeGST, double gst, double grandTotal) {

        String title = " JMB HOTEL ,INDORE - INVOICE ";
        String hotelName = "Jmb HOTEL";

        // We'll create the content lines first
        StringBuilder content = new StringBuilder();
        content.append(String.format("Hotel: %s\n", hotelName));
        content.append(String.format("Bill No: %d\n", billNo));
        content.append(String.format("Customer: %s\n", customerName));
        content.append(String.format("Party Size: %d\n", partyPeople));
        content.append(String.format("Booking Date: %s\n", bookingDate));
        content.append(String.format("Order Creation Date/Time: %s\n", creationDateTime));
        content.append("\n--- ITEMS ---\n");
        content.append(String.format("%-35s %8s %6s %10s\n", "Item", "Rate", "Qty", "Amount"));
        content.append(billBody);
        content.append("\n----------------------------------------------\n");
        content.append(String.format("%-35s %8s %6s %10.2f\n", "Total (Before GST)", "", "", totalBeforeGST));
        content.append(String.format("%-35s %8s %6s %10.2f\n", "GST (5%)", "", "", gst));
        content.append(String.format("%-35s %8s %6s %10.2f\n", "GRAND TOTAL", "", "", grandTotal));
        content.append("\nNote: If you ordered more than 100 thalis, 5 free thalis added as offer (shown above if applicable).\n");
        content.append("\nThank you for choosing Party Time!\n");

        // Now print a square box with white background and black text.
        String[] lines = content.toString().split("\n");
        int maxLen = 0;
        for (String s : lines) if (s.length() > maxLen) maxLen = s.length();
        int boxWidth = maxLen + 4; // padding

        // Top border
        System.out.println(BG_WHITE + BLACK + BOLD);
        printRepeated(" ", 2); // small top padding
        printBoxLine(boxWidth);

        // title centered
        printBoxLineText(centerText(title, boxWidth - 2));

        // blank
        printBoxLineText("");
        // content lines
        for (String s : lines) {
            printBoxLineText(s);
        }

        // bottom border
        printBoxLine(boxWidth);
        printRepeated(" ", 2);
        System.out.println(RESET); // reset colors
    }

    // Helpers for box
    public static void printBoxLine(int width) {
        System.out.print("  "); // left padding for visual
        System.out.print("+");
        for (int i = 0; i < width - 2; i++) System.out.print("-");
        System.out.println("+");
    }

    public static void printBoxLineText(String text) {
        int width = text == null ? 0 : text.length() + 2;
        // We need boxWidth from earlier; to keep simple, we'll calculate actual width using max of line lengths by padding outside.
        // Instead we print with a fixed overall width computed in caller (boxWidth). We'll approximate:  max width used earlier.
        // For simplicity reuse same logic:
        // (This method is invoked only after determining overall width in caller.)
        // To maintain alignment, we'll build a formatted line with left padding and right padding.
        int globalWidth = 80; // fallback width
        // Determine globalWidth by measuring console approach is hard here; so instead print with one space and text and pad to 70 chars.
        int target = 70;
        String t = text == null ? "" : text;
        if (t.length() > target - 2) {
            t = t.substring(0, target - 5) + "...";
        }
        System.out.print("  "); // left visual padding
        System.out.print("| ");
        System.out.print(t);
        // pad:
        for (int i = 0; i < target - 2 - t.length(); i++) System.out.print(" ");
        System.out.println(" |");
    }

    public static void printRepeated(String s, int count) {
        for (int i = 0; i < count; i++) System.out.print(s);
    }

    public static String centerText(String text, int width) {
        if (text == null) return "";
        int pad = Math.max(0, (width - 2 - text.length()) / 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pad; i++) sb.append(" ");
        sb.append(text);
        return sb.toString();
    }

    public static double roundTwoDecimals(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
