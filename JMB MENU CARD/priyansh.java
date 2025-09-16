// File: priyansh.java
// Java 8 compatible. Single-file console program for JMB Hotel menu & billing.
// - Two root menus: Vegetarian Menu and Breakfast Menu
// - All submenus printed with System.out.println (SOP)
// - No ArrayList/Collections; uses arrays and simple variables
// - ANSI colors for terminals that support them

import java.util.Scanner;

public class priyansh {

    // ANSI helpers
    public static final String ESC = "\u001B";
    public static final String RESET = ESC + "[0m";
    public static final String BOLD = ESC + "[1m";

    public static final String BG_CARD = ESC + "[48;2;245;240;230m";
    public static final String BG_HEADER_VEG = ESC + "[48;2;139;69;19m"; // brown-red
    public static final String BG_HEADER_BF  = ESC + "[48;2;34;139;34m";  // green
    public static final String FG_WHITE = ESC + "[38;2;255;255;255m";
    public static final String FG_BLACK = ESC + "[38;2;0;0;0m";

    // basic box chars (unicode)
    public static final String TL = "\u250C", TR = "\u2510", BL = "\u2514", BR = "\u2518";
    public static final String HR = "\u2500", VL = "\u2502", TLEFT = "\u251C", TRIGHT = "\u2524";

    // scanner
    private static final Scanner scanner = new Scanner(System.in);

    // storage for selections (no ArrayList)
    private static final int MAX_SELS = 300;
    private static String[] selTitle = new String[MAX_SELS];
    private static double[] selPrice = new double[MAX_SELS];
    private static String[][] selExtras = new String[MAX_SELS][200]; // each selection can have up to 200 lines of extras
    private static int[] selExtrasCount = new int[MAX_SELS];
    private static int selCount = 0;

    private static int partySize = 1;

    // ---------- Menu content (explicit items) ----------
    // We'll keep the menus in arrays so we can print selections easily,
    // but the menus themselves are displayed by printing each element (SOP-style).
    // This balances extreme verbosity and maintainability.

    // Vegetarian thalis metadata
    private static final int[] VEG_IDS = {1,2,3,4,5,6};
    private static final String[] VEG_NAMES = {
        "Thali 1 (Rs.310)",
        "Thali 2 (Rs.360)",
        "Thali 3 (Rs.410)",
        "Thali 4 (Rs.470)",
        "Thali 5 (Rs.600)",
        "Thali 6 (Rs.700)"
    };
    private static final double[] VEG_PRICE = {310,360,410,470,600,700};
    // For each thali we mark which submenus are required (1 = yes, 0 = no).
    // order: drinkOrSoup, starter, paneer, veg, curd, roti, dal, rice, snacks
    private static final int[][] VEG_FEATURES = {
        {1,0,0,1,0,1,1,1,0}, // thali1
        {1,1,0,1,1,1,1,1,0}, // thali2
        {1,1,1,1,1,1,1,1,0}, // thali3
        {1,1,1,1,1,1,1,1,1}, // thali4
        {1,1,1,1,1,1,1,1,1}, // thali5
        {1,1,1,1,1,1,1,1,1}  // thali6
    };

    // Mocktails
    private static final String[] MOCKTAILS = {
        "Blue Lagoon",
        "Virgin Pinacolada",
        "Virgin Mojito",
        "Strawberry Delight",
        "Bubble Gum",
        "Kesar Pista (Cold)",
        "Butter Milk",
        "Fresh Lime Water",
        "Rasna Water",
        "Orange Pink City"
    };

    // Soups
    private static final String[] SOUPS = {
        "Tomato Soup",
        "Hot & Sour Veg",
        "Veg Manchow",
        "Lemon Coriander"
    };

    // Starters (detailed)
    private static final String[] STARTERS = {
        "Mix Veg Pakoda",
        "Veg Finger",
        "Gobi Manchurian",
        "Methi Kabab",
        "Hara Bhara Kabab",
        "Paneer Chilli",
        "Paneer Tikka",
        "Paneer Pudina Tikka",
        "Paneer Achari Tikka",
        "Paneer 65",
        "Dragon Paneer",
        "Mixed Vegetable Cutlet",
        "Spring Roll",
        "Crispy Corn",
        "Veg Seekh Kabab"
    };

    // Paneer dishes
    private static final String[] PANEER_DISHES = {
        "Paneer Butter Masala",
        "Paneer Kadai",
        "Paneer Punjabi",
        "Methi Paneer",
        "Paneer Palak",
        "Corn Paneer",
        "Paneer Mutter",
        "Paneer Kolhapuri",
        "Paneer Do Pyaza",
        "Paneer Tikka Masala",
        "Paneer Chatpata"
    };

    // Vegetables (main veg dishes)
    private static final String[] VEGETABLES = {
        "Navratan Korma",
        "Aloo Mutter",
        "Mix Veg",
        "Green Chana (Seasonal)",
        "Corn Palak",
        "Aloo 65",
        "Aloo Capsicum",
        "Aloo Do Pyaza",
        "Aloo Gobhi",
        "Gobhi Mutter",
        "Kadhi Punjabi",
        "Veg Kofta",
        "Methi Mutter Malai",
        "Navratan Korma (Rich)",
        "Chana Masala"
    };

    // Dals
    private static final String[] DALS = {
        "Dal Fry",
        "Dal Tadka",
        "Dal Makhani",
        "Dal Panchrangi"
    };

    // Rices
    private static final String[] RICES = {
        "Jeera Rice",
        "Veg Pulao",
        "Veg Fried Rice",
        "Veg Biryani",
        "Peas Pulao"
    };

    // Rotis / Breads
    private static final String[] ROTIS = {
        "Roti (Plain)",
        "Butter Roti",
        "Tandoori Roti",
        "Butter Naan",
        "Plain Naan",
        "Missi Roti",
        "Paratha",
        "Methi Paratha",
        "Kulcha"
    };

    // Curd dishes / raitas
    private static final String[] CURDS = {
        "Boondi Raita",
        "Fruit Raita",
        "Aloo Raita",
        "Mix Veg Raita",
        "Dahi Vada",
        "Lassi"
    };

    // Sweets & Ice cream
    private static final String[] SWEETS = {
        "Gulab Jamun",
        "Jalebi",
        "Moong Dal Halwa",
        "Shreekhand",
        "Aam Ras (Seasonal)",
        "Rasgulla",
        "Vanilla Ice Cream",
        "Butterscotch Ice Cream",
        "Sitafal Basundi"
    };

    // Chinese & Continental
    private static final String[] CHINESE_CONTI = {
        "Veg Manchurian",
        "Veg Noodles",
        "Veg Fried Rice",
        "Veg Singapore Noodles",
        "Paneer Manchurian (Chinese style)",
        "Grilled Veg Platter (Continental)"
    };

    // Snacks (a la carte)
    private static final String[] SNACKS = {
        "Samosa",
        "Kachori",
        "Pav Bhaji (small)",
        "Pav Bhaji (full)",
        "Vada Sambar",
        "Paratha with Dahi",
        "Idli Sambar",
        "Bread Pakoda",
        "Pani Puri (chaat)"
    };

    // Breakfast heavy snacks
    private static final String[] HEAVY_SNACKS = {
        "Pav Bhaji",
        "Vada Sambar",
        "Paratha with Dahi",
        "Samosa",
        "Aloo Paratha (with curd)",
        "Misal Pav"
    };

    // Breakfast plans
    private static final int[] BF_IDS = {1,2,3};
    private static final String[] BF_NAMES = {"Plan A (Rs.200)","Plan B (Rs.230)","Plan C (Rs.250)"};
    private static final double[] BF_PRICE = {200,230,250};
    private static final int[] BF_HEAVY_COUNT = {0,1,2};

    // ---------- small helper utilities (Java 8 safe) ----------
    private static String repeat(String s, int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder(s.length()*n);
        for (int i=0;i<n;i++) sb.append(s);
        return sb.toString();
    }

    private static String padRight(String s, int w) {
        if (s == null) s = "";
        int len = s.length();
        if (len >= w) return s.substring(0,w);
        StringBuilder sb = new StringBuilder(s);
        for (int i=0;i<w-len;i++) sb.append(' ');
        return sb.toString();
    }

    private static String center(String s, int w) {
        if (s == null) s = "";
        int len = s.length();
        if (len >= w) return s;
        int left = (w-len)/2;
        int right = w-len-left;
        return repeat(" ", left) + s + repeat(" ", right);
    }

    private static int parseIntSafe(String in) {
        try {
            return Integer.parseInt(in.trim());
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }
    }

    // add extra to selection record
    private static void addExtraToSel(int selIdx, String extra) {
        if (selIdx < 0 || selIdx >= MAX_SELS) return;
        int c = selExtrasCount[selIdx];
        if (c >= selExtras[selIdx].length) return;
        selExtras[selIdx][c] = extra;
        selExtrasCount[selIdx] = c+1;
    }

    // choose from an array with printing SOP (returns index, -1 allowed)
    private static int chooseFromArray(String header, String[] arr, boolean allowBack) {
        while (true) {
            System.out.println("\n---- " + header + " ----");
            for (int i=0;i<arr.length;i++) {
                System.out.println((i+1) + ". " + arr[i]);
            }
            if (allowBack) System.out.println("0. Back");
            System.out.print("Enter number: ");
            String ln = scanner.nextLine().trim();
            int n = parseIntSafe(ln);
            if (allowBack && n == 0) return -1;
            if (n >= 1 && n <= arr.length) return n-1;
            System.out.println("Invalid input. Try again.");
        }
    }

    // ---------- main flow ----------
    public static void main(String[] args) {
        // Welcome card
        printWelcomeCard();

        // Ask party size
        while (true) {
            System.out.print("Enter number of people in your party: ");
            String ln = scanner.nextLine().trim();
            int n = parseIntSafe(ln);
            if (n > 0) { partySize = n; break; }
            System.out.println("Please enter a valid positive integer.");
        }

        // main loop: two root choices only
        mainLoop:
        while (true) {
            System.out.println();
            System.out.println(BG_HEADER_VEG + FG_WHITE + BOLD + " 1) VEGETARIAN MENU " + RESET + "    " + BG_HEADER_BF + FG_WHITE + BOLD + " 2) BREAKFAST MENU " + RESET);
            System.out.println("0) Finish and print bill");
            System.out.print("Enter 1 for Vegetarian Menu, 2 for Breakfast Menu, 0 to finish: ");
            String ch = scanner.nextLine().trim();
            if ("0".equals(ch)) break mainLoop;
            else if ("1".equals(ch)) handleVegetarianMenuFlow();
            else if ("2".equals(ch)) handleBreakfastFlow();
            else System.out.println("Invalid option. Enter 1, 2, or 0.");
        }

        // final bill
        printFinalBill();
        System.out.println("\nThank you — JMB Hotel.");
    }

    // ---------- print welcome card ----------
    private static void printWelcomeCard() {
        int width = 86;
        String top = TL + repeat(HR, width) + TR;
        String bottom = BL + repeat(HR, width) + BR;
        System.out.println(BG_CARD + top + RESET);
        System.out.println(BG_CARD + VL + center(BOLD + "WELCOME TO JMB HOTEL - PARTY MENU & BILLING" + RESET, width) + VL + RESET);
        System.out.println(BG_CARD + bottom + RESET);
    }

    // ---------- Vegetarian menu flow ----------
    private static void handleVegetarianMenuFlow() {
        // Print all thalis (SOP-style)
        System.out.println("\n========== VEGETARIAN THALIS ==========");
        // Each thali printed with full ingredients summary
        System.out.println("1. Thali 1 - Rs.310 per person");
        System.out.println("   Includes: Welcome Drink/Soup, Vegetable Dish, Roti/Naan/Paratha, Dal, Rice, Sweet Dish, Ice Cream");
        System.out.println("2. Thali 2 - Rs.360 per person");
        System.out.println("   Includes: Welcome Drink/Soup, Starter, Paneer Dish, Vegetable, Dal, Rice, Curd Dish, Sweet");
        System.out.println("3. Thali 3 - Rs.410 per person");
        System.out.println("   Includes: Welcome Drink/Soup, Starter, Paneer Dish, Vegetable, Dal, Rice, Curd Dish, Sweet");
        System.out.println("4. Thali 4 - Rs.470 per person");
        System.out.println("   Includes: Welcome Drink/Soup, 2 Starters, Paneer Dish, Vegetable, Dal, Rice, Curd, Sweet, Extra Snack/Chinese");
        System.out.println("5. Thali 5 - Rs.600 per person");
        System.out.println("   Includes: Welcome Drink/Soup, 2 Starters, 2 Paneer, 2 Veg Dishes, Dal, Rice, Curd, Sweet, Ice Cream");
        System.out.println("6. Thali 6 - Rs.700 per person");
        System.out.println("   Includes: Top Package - All Items (2 Starters, 2 Paneer, 2 Veg, Dal, Rice, Curd, Sweets, Ice Cream)");

        System.out.println("0. Back to main menu");

        while (true) {
            System.out.print("Enter thali number to select (or 0 to go back): ");
            String ln = scanner.nextLine().trim();
            int t = parseIntSafe(ln);
            if (t == 0) return;
            int idx = -1;
            for (int i=0;i<VEG_IDS.length;i++) if (VEG_IDS[i] == t) idx = i;
            if (idx == -1) { System.out.println("Invalid thali number. Try again."); continue; }

            // Show detailed items included and then prompt for choices as required
            System.out.println("\nYou selected: " + VEG_NAMES[idx] + " (Rs. " + VEG_PRICE[idx] + " per person)");
            System.out.println("Detailed items to choose:");
            if (VEG_FEATURES[idx][0] == 1) System.out.println(" - Welcome Drink or Soup (choose mocktail or soup)");
            if (VEG_FEATURES[idx][1] == 1) System.out.println(" - Starter (choose one)");
            if (VEG_FEATURES[idx][2] == 1) System.out.println(" - Paneer Dish (choose one)");
            if (VEG_FEATURES[idx][3] == 1) System.out.println(" - Vegetable Dish (choose one)");
            if (VEG_FEATURES[idx][6] == 1) System.out.println(" - Dal (choose one)");
            if (VEG_FEATURES[idx][7] == 1) System.out.println(" - Rice (choose one)");
            if (VEG_FEATURES[idx][5] == 1) System.out.println(" - Bread (choose one: Roti/Naan/Paratha)");
            if (VEG_FEATURES[idx][4] == 1) System.out.println(" - Curd Dish (choose one)");
            if (VEG_FEATURES[idx][8] == 1) System.out.println(" - Snack or Chinese/Continental (choose one)");
            System.out.println(" - Sweet & Ice Cream (included)");

            System.out.print("Confirm add this thali for the entire party? (yes/no): ");
            String conf = scanner.nextLine().trim().toLowerCase();
            if (!"yes".equals(conf)) { System.out.println("Not added."); continue; }

            // Add selection record
            if (selCount >= MAX_SELS) {
                System.out.println("Reached maximum selections allowed.");
                return;
            }
            selTitle[selCount] = VEG_NAMES[idx] + " x" + partySize + " persons";
            selPrice[selCount] = VEG_PRICE[idx] * partySize;
            selExtrasCount[selCount] = 0;

            // Now go through required sub-choices in order

            // 1) Welcome Drink or Soup
            if (VEG_FEATURES[idx][0] == 1) {
                System.out.println("\nChoose Welcome Drink or Soup:");
                System.out.println("1. Mocktail (list)");
                System.out.println("2. Soup (list)");
                System.out.print("Enter 1 for Mocktail, 2 for Soup: ");
                String dch = scanner.nextLine().trim();
                if ("1".equals(dch)) {
                    // print mocktails by SOP lines
                    System.out.println("\n--- MOCKTAILS ---");
                    System.out.println("1. Blue Lagoon");
                    System.out.println("2. Virgin Pinacolada");
                    System.out.println("3. Virgin Mojito");
                    System.out.println("4. Strawberry Delight");
                    System.out.println("5. Bubble Gum");
                    System.out.println("6. Kesar Pista (Cold)");
                    System.out.println("7. Butter Milk");
                    System.out.println("8. Fresh Lime Water");
                    System.out.println("9. Rasna Water");
                    System.out.println("10. Orange Pink City");
                    System.out.print("Choose mocktail number: ");
                    int m = chooseNumberFrom(1, MOCKTAILS.length);
                    addExtraToSel(selCount, "Welcome Drink: " + MOCKTAILS[m-1]);
                } else {
                    // print soups
                    System.out.println("\n--- SOUPS ---");
                    System.out.println("1. Tomato Soup");
                    System.out.println("2. Hot & Sour Veg");
                    System.out.println("3. Veg Manchow");
                    System.out.println("4. Lemon Coriander");
                    System.out.print("Choose soup number: ");
                    int s = chooseNumberFrom(1, SOUPS.length);
                    addExtraToSel(selCount, "Soup: " + SOUPS[s-1]);
                }
            }

            // 2) Starter
            if (VEG_FEATURES[idx][1] == 1) {
                // print starters SOP
                System.out.println("\n--- STARTERS ---");
                System.out.println("1. Mix Veg Pakoda");
                System.out.println("2. Veg Finger");
                System.out.println("3. Gobi Manchurian");
                System.out.println("4. Methi Kabab");
                System.out.println("5. Hara Bhara Kabab");
                System.out.println("6. Paneer Chilli");
                System.out.println("7. Paneer Tikka");
                System.out.println("8. Paneer Pudina Tikka");
                System.out.println("9. Paneer Achari Tikka");
                System.out.println("10. Paneer 65");
                System.out.println("11. Dragon Paneer");
                System.out.println("12. Mixed Vegetable Cutlet");
                System.out.println("13. Spring Roll");
                System.out.println("14. Crispy Corn");
                System.out.println("15. Veg Seekh Kabab");
                System.out.print("Choose starter number: ");
                int st = chooseNumberFrom(1, STARTERS.length);
                addExtraToSel(selCount, "Starter: " + STARTERS[st-1]);
            }

            // 3) Paneer dish
            if (VEG_FEATURES[idx][2] == 1) {
                System.out.println("\n--- PANEER DISHES ---");
                System.out.println("1. Paneer Butter Masala");
                System.out.println("2. Paneer Kadai");
                System.out.println("3. Paneer Punjabi");
                System.out.println("4. Methi Paneer");
                System.out.println("5. Paneer Palak");
                System.out.println("6. Corn Paneer");
                System.out.println("7. Paneer Mutter");
                System.out.println("8. Paneer Kolhapuri");
                System.out.println("9. Paneer Do Pyaza");
                System.out.println("10. Paneer Tikka Masala");
                System.out.println("11. Paneer Chatpata");
                System.out.print("Choose paneer dish number: ");
                int p = chooseNumberFrom(1, PANEER_DISHES.length);
                addExtraToSel(selCount, "Paneer Dish: " + PANEER_DISHES[p-1]);
            }

            // 4) Vegetable dish
            if (VEG_FEATURES[idx][3] == 1) {
                System.out.println("\n--- VEGETABLE DISHES ---");
                // print each veg SOP
                System.out.println("1. Navratan Korma");
                System.out.println("2. Aloo Mutter");
                System.out.println("3. Mix Veg");
                System.out.println("4. Green Chana (Seasonal)");
                System.out.println("5. Corn Palak");
                System.out.println("6. Aloo 65");
                System.out.println("7. Aloo Capsicum");
                System.out.println("8. Aloo Do Pyaza");
                System.out.println("9. Aloo Gobhi");
                System.out.println("10. Gobhi Mutter");
                System.out.println("11. Kadhi Punjabi");
                System.out.println("12. Veg Kofta");
                System.out.println("13. Methi Mutter Malai");
                System.out.println("14. Navratan Korma (Rich)");
                System.out.println("15. Chana Masala");
                System.out.print("Choose vegetable dish number: ");
                int v = chooseNumberFrom(1, VEGETABLES.length);
                addExtraToSel(selCount, "Vegetable Dish: " + VEGETABLES[v-1]);
            }

            // 5) Dal
            if (VEG_FEATURES[idx][6] == 1) {
                System.out.println("\n--- DALS ---");
                System.out.println("1. Dal Fry");
                System.out.println("2. Dal Tadka");
                System.out.println("3. Dal Makhani");
                System.out.println("4. Dal Panchrangi");
                System.out.print("Choose dal number: ");
                int d = chooseNumberFrom(1, DALS.length);
                addExtraToSel(selCount, "Dal: " + DALS[d-1]);
            }

            // 6) Rice
            if (VEG_FEATURES[idx][7] == 1) {
                System.out.println("\n--- RICES ---");
                System.out.println("1. Jeera Rice");
                System.out.println("2. Veg Pulao");
                System.out.println("3. Veg Fried Rice");
                System.out.println("4. Veg Biryani");
                System.out.println("5. Peas Pulao");
                System.out.print("Choose rice number: ");
                int r = chooseNumberFrom(1, RICES.length);
                addExtraToSel(selCount, "Rice: " + RICES[r-1]);
            }

            // 7) Roti / Bread
            if (VEG_FEATURES[idx][5] == 1) {
                System.out.println("\n--- ROTI / BREAD ---");
                System.out.println("1. Roti (Plain)");
                System.out.println("2. Butter Roti");
                System.out.println("3. Tandoori Roti");
                System.out.println("4. Butter Naan");
                System.out.println("5. Plain Naan");
                System.out.println("6. Missi Roti");
                System.out.println("7. Paratha");
                System.out.println("8. Methi Paratha");
                System.out.println("9. Kulcha");
                System.out.print("Choose bread number: ");
                int br = chooseNumberFrom(1, ROTIS.length);
                addExtraToSel(selCount, "Bread: " + ROTIS[br-1]);
            }

            // 8) Curd dish
            if (VEG_FEATURES[idx][4] == 1) {
                System.out.println("\n--- CURD / RAITA ---");
                System.out.println("1. Boondi Raita");
                System.out.println("2. Fruit Raita");
                System.out.println("3. Aloo Raita");
                System.out.println("4. Mix Veg Raita");
                System.out.println("5. Dahi Vada");
                System.out.println("6. Lassi");
                System.out.print("Choose curd dish number: ");
                int cr = chooseNumberFrom(1, CURDS.length);
                addExtraToSel(selCount, "Curd Dish: " + CURDS[cr-1]);
            }

            // 9) Snacks / Chinese / Continental
            if (VEG_FEATURES[idx][8] == 1) {
                System.out.println("\nExtra category: 1) Snacks  2) Chinese & Continental");
                System.out.print("Enter 1 or 2: ");
                String cat = scanner.nextLine().trim();
                if ("1".equals(cat)) {
                    // print snacks SOP
                    System.out.println("\n--- SNACKS ---");
                    System.out.println("1. Samosa");
                    System.out.println("2. Kachori");
                    System.out.println("3. Pav Bhaji (small)");
                    System.out.println("4. Pav Bhaji (full)");
                    System.out.println("5. Vada Sambar");
                    System.out.println("6. Paratha with Dahi");
                    System.out.println("7. Idli Sambar");
                    System.out.println("8. Bread Pakoda");
                    System.out.println("9. Pani Puri (chaat)");
                    System.out.print("Choose snack number: ");
                    int sn = chooseNumberFrom(1, SNACKS.length);
                    addExtraToSel(selCount, "Snack: " + SNACKS[sn-1]);
                } else {
                    // print chinese/conti SOP
                    System.out.println("\n--- CHINESE & CONTINENTAL ---");
                    System.out.println("1. Veg Manchurian");
                    System.out.println("2. Veg Noodles");
                    System.out.println("3. Veg Fried Rice");
                    System.out.println("4. Veg Singapore Noodles");
                    System.out.println("5. Paneer Manchurian (Chinese)");
                    System.out.println("6. Grilled Veg Platter (Continental)");
                    System.out.print("Choose chinese/conti number: ");
                    int cc = chooseNumberFrom(1, CHINESE_CONTI.length);
                    addExtraToSel(selCount, "Chinese/Conti: " + CHINESE_CONTI[cc-1]);
                }
            }

            // default sweet
            addExtraToSel(selCount, "Sweet & Ice Cream: Included");

            System.out.printf("Added %s -> ₹%.2f\n", selTitle[selCount], selPrice[selCount]);
            selCount++;

            // ask to add more thalis or back
            System.out.print("Add another thali? (yes/no): ");
            String more = scanner.nextLine().trim().toLowerCase();
            if (!"yes".equals(more)) return;
        }
    }

    // ---------- Breakfast flow ----------
    private static void handleBreakfastFlow() {
        // show plans with SOP
        System.out.println("\n========== BREAKFAST PLANS ==========");
        System.out.println("1. Plan A - Rs.200 per person");
        System.out.println("   Includes: Welcome Drink, Jalebi, Breakfast Item, Tea/Coffee");
        System.out.println("2. Plan B - Rs.230 per person");
        System.out.println("   Includes: Welcome Drink, Jalebi, Breakfast Item, 1 Heavy Snack, Tea/Coffee");
        System.out.println("3. Plan C - Rs.250 per person");
        System.out.println("   Includes: Welcome Drink, Jalebi, Breakfast Item, 2 Heavy Snacks, Tea/Coffee");
        System.out.println("0. Back to main menu");

        while (true) {
            System.out.print("Enter plan number to add (or 0 to go back): ");
            String ln = scanner.nextLine().trim();
            int p = parseIntSafe(ln);
            if (p == 0) return;
            int idx = -1;
            for (int i=0;i<BF_IDS.length;i++) if (BF_IDS[i] == p) idx = i;
            if (idx == -1) { System.out.println("Invalid plan number. Try again."); continue; }

            System.out.println("\nSelected: " + BF_NAMES[idx] + " (Rs. " + BF_PRICE[idx] + " per person)");
            System.out.print("Confirm add this plan for the entire party? (yes/no): ");
            String conf = scanner.nextLine().trim().toLowerCase();
            if (!"yes".equals(conf)) { System.out.println("Not added."); continue; }

            // add selection
            if (selCount >= MAX_SELS) {
                System.out.println("Reached max selections.");
                return;
            }
            selTitle[selCount] = BF_NAMES[idx] + " x" + partySize + " persons";
            selPrice[selCount] = BF_PRICE[idx] * partySize;
            selExtrasCount[selCount] = 0;

            // Tea or Coffee
            System.out.println("Choose drink preference: 1. Coffee  2. Chai");
            System.out.print("Enter 1 or 2: ");
            String dc = scanner.nextLine().trim();
            if ("1".equals(dc)) addExtraToSel(selCount, "Drink preference: Coffee");
            else addExtraToSel(selCount, "Drink preference: Chai");

            // Heavy snacks if any
            int heavy = BF_HEAVY_COUNT[idx];
            for (int i=0;i<heavy;i++) {
                // print heavy snack choices SOP
                System.out.println("\nChoose Heavy Snack #" + (i+1) + ":");
                System.out.println("1. Pav Bhaji");
                System.out.println("2. Vada Sambar");
                System.out.println("3. Paratha with Dahi");
                System.out.println("4. Samosa");
                System.out.println("5. Aloo Paratha (with curd)");
                System.out.println("6. Misal Pav");
                System.out.print("Enter number: ");
                int hs = chooseNumberFrom(1, HEAVY_SNACKS.length);
                addExtraToSel(selCount, "Heavy Snack: " + HEAVY_SNACKS[hs-1]);
            }

            // default breakfast items (Jalebi etc.)
            addExtraToSel(selCount, "Jalebi: Included");
            addExtraToSel(selCount, "Breakfast item: Standard (Poha/Bread as per plan)");

            System.out.printf("Added %s -> ₹%.2f\n", selTitle[selCount], selPrice[selCount]);
            selCount++;

            System.out.print("Add another breakfast plan? (yes/no): ");
            String more = scanner.nextLine().trim().toLowerCase();
            if (!"yes".equals(more)) return;
        }
    }

    // ---------- helper to choose number with bounds ----------
    private static int chooseNumberFrom(int min, int max) {
        while (true) {
            String ln = scanner.nextLine().trim();
            int n = parseIntSafe(ln);
            if (n >= min && n <= max) return n;
            System.out.print("Invalid. Enter a number between " + min + " and " + max + ": ");
        }
    }

    // ---------- final bill printing ----------
    private static void printFinalBill() {
        System.out.println("\n=======================================================");
        System.out.println("                    JMB HOTEL FINAL BILL               ");
        System.out.println("=======================================================");
        if (selCount == 0) {
            System.out.println("No items ordered.");
            System.out.println("=======================================================");
            return;
        }
        double subtotal = 0.0;
        for (int i=0;i<selCount;i++) {
            System.out.printf("%d) %s  -> Rs. %.2f\n", i+1, selTitle[i], selPrice[i]);
            for (int j=0;j<selExtrasCount[i];j++) {
                System.out.println("     - " + selExtras[i][j]);
            }
            System.out.println();
            subtotal += selPrice[i];
        }
        System.out.printf("Subtotal: Rs. %.2f\n", subtotal);
        double gst = subtotal * 0.05; // sample GST 5%
        System.out.printf("GST (5%%): Rs. %.2f\n", gst);
        System.out.printf("Total Payable: Rs. %.2f\n", subtotal + gst);
        System.out.println("=======================================================");

        // colored invoice card (centered)
        printInvoiceCard(subtotal, gst, subtotal+gst);
    }

    private static void printInvoiceCard(double subtotal, double gst, double total) {
        int width = 86;
        String top = TL + repeat(HR, width) + TR;
        String bottom = BL + repeat(HR, width) + BR;
        System.out.println(BG_CARD + top + RESET);
        printCardLine(center("JMB HOTEL - PARTY INVOICE", width));
        printCardLine("");
        printCardLine("Party Size: " + partySize);
        printCardLine("");
        for (int i=0;i<selCount;i++) {
            printCardLine(selTitle[i] + "  -> Rs. " + String.format("%.2f", selPrice[i]));
            for (int j=0;j<selExtrasCount[i];j++) {
                String ex = selExtras[i][j];
                if (ex.length() <= 70) printCardLine("  * " + ex);
                else {
                    printCardLine("  * " + ex.substring(0,70));
                    printCardLine("    " + ex.substring(70));
                }
            }
            printCardLine("");
        }
        printCardLine(String.format("Subtotal: Rs. %.2f", subtotal));
        printCardLine(String.format("GST (5%%): Rs. %.2f", gst));
        printCardLine(String.format("TOTAL: Rs. %.2f", total));
        printCardLine("");
        printCardLine("Booking confirmed only with advance deposit.");
        printCardLine("Thank you for choosing JMB Hotel!");
        System.out.println(BG_CARD + bottom + RESET);
    }

    private static void printCardLine(String content) {
        int width = 86;
        if (content == null) content = "";
        if (content.length() >= width) {
            System.out.println(BG_CARD + VL + content.substring(0,width) + VL + RESET);
            return;
        }
        int left = (width - content.length())/2;
        int right = width - content.length() - left;
        String inside = repeat(" ", left) + content + repeat(" ", right);
        System.out.println(BG_CARD + VL + inside + VL + RESET);
    }
}
