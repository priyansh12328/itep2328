import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * JMBMenuBillingFull.java
 * Single-file Java 8 compatible, console-based menu & billing program for JMB Hotel.
 *
 * - Full vegetarian thalis & breakfast flows
 * - Numbered choices everywhere (1,2,3,...)
 * - Colored menu-card invoice (ANSI backgrounds)
 * - Add multiple thalis/plans, choose sub-items per thali
 *
 * Terminal must support ANSI colors for the colored output.
 */
public class JMBMenuBillingFull {

    // ANSI helpers
    public static final String ESC = "\u001B";
    public static final String RESET = ESC + "[0m";
    public static final String BOLD = ESC + "[1m";

    // Card & header backgrounds (truecolor)
    public static final String BG_CARD = ESC + "[48;2;245;240;230m";     // card background (light cream)
    public static final String BG_BROWNRED = ESC + "[48;2;139;69;19m";   // vegetarian header (brown-red)
    public static final String BG_GREEN = ESC + "[48;2;34;139;34m";      // breakfast header (green)
    public static final String BG_ORANGE = ESC + "[48;2;255;140;0m";     // mocktail/paneer header (orange)
    public static final String BG_BLUE = ESC + "[48;2;30;144;255m";      // curd/sweets header (blue)

    // foregrounds
    public static final String FG_WHITE = ESC + "[38;2;255;255;255m";
    public static final String FG_BLACK = ESC + "[38;2;0;0;0m";

    // box drawing (unicode escapes)
    public static final String TL = "\u250C"; // ┌
    public static final String HR = "\u2500"; // ─
    public static final String TR = "\u2510"; // 
    public static final String VL = "\u2502"; // │
    public static final String BL = "\u2514"; // └
    public static final String BR = "\u2518"; // ┘
    public static final String TLEFT = "\u251C"; // ├
    public static final String TRIGHT = "\u2524"; // ┤

    // Scanner
    private static final Scanner scanner = new Scanner(System.in);

    // Data structures for selections and billing
    static class Selection {
        String title;
        double price;
        List<String> extras = new ArrayList<String>();
        Selection(String title, double price) { this.title = title; this.price = price; }
    }
    static List<Selection> selections = new ArrayList<Selection>();
    static double grandTotal = 0.0;
    static int partySize = 1;

    // Full menus (from your images) - numbered lists as arrays
    static final String[] VEGETABLES = {
        "Navratan Korma", "Aloo Mutter", "Mix Veg", "Green Chana (Seasonal)", "Corn Palak",
        "Aloo 65", "Aloo Capsicum", "Aloo Do Pyaza", "Aloo Gobhi", "Gobhi Mutter", "Kadhi Punjabi", "Veg Kofta"
    };

    static final String[] DALS = { "Dal Fry", "Dal Tadka", "Dal Makhani", "Dal Panchrangi" };

    static final String[] RICES = { "Jeera Rice", "Veg Pulao", "Veg Fried Rice", "Veg Biryani", "Peas Pulao" };

    static final String[] ROTIS = { "Roti (Plain)", "Butter Naan", "Plain Naan", "Paratha", "Missi Roti", "Kulcha" };

    static final String[] SNACKS = { "Idli/Vada Sambar", "Pav Bhaji", "Chhole Kulcha", "Muli Paratha", "Stuffed Paratha" };

    static final String[] STARTERS = {
        "Mix Veg Pakoda", "Veg Finger", "Gobi Manchurian", "Methi Kabab", "Hara Bhara Kabab", "Paneer Chilli",
        "Paneer Tikka", "Paneer Pudina Tikka", "Crispy Corn", "Spring Roll"
    };

    static final String[] MOCKTAILS = {
        "Blue Lagoon", "Virgin Pinacolada", "Virgin Mojito", "Strawberry Delight",
        "Bubble Gum", "Kesar Pista (Cold)", "Butter Milk", "Fresh Lime Water", "Rasna Water", "Orange Pink City"
    };

    static final String[] SOUPS = { "Tomato Soup", "Hot & Sour Veg", "Veg Manchow", "Lemon Coriander" };

    static final String[] PANEER_STARTERS = { "Paneer Chilli", "Paneer Tikka", "Paneer Pudina Tikka", "Paneer Achari Tikka" };

    static final String[] PANEER_DISHES = {
        "Paneer Butter Masala", "Paneer Kadai", "Paneer Punjabi", "Methi Paneer",
        "Paneer Palak", "Corn Paneer", "Paneer Mutter", "Paneer Kolhapuri", "Paneer Do Pyaza"
    };

    static final String[] CURD_DISHES = { "Boondi Raita", "Fruit Raita", "Aloo Raita", "Dahi Vada", "Lassi" };

    static final String[] SWEETS = {
        "Gulab Jamun", "Jalebi", "Moong Dal Halwa", "Shreekhand", "Aam Ras (Seasonal)",
        "Rasgulla", "Vanilla Ice Cream", "Butterscotch Ice Cream", "Sitafal Basundi"
    };

    static final String[] CHINESE_CONTI = { "Veg Manchurian", "Veg Noodles", "Veg Fried Rice", "Veg Singapore Noodles" };

    static final String[] HEAVY_SNACKS = { "Pav Bhaji", "Vada Sambar", "Paratha with Dahi", "Samosa" };

    // Thali metadata
    static class ThaliInfo {
        int id;
        String name;
        double pricePerPerson;
        boolean hasDrinkOrSoup, hasStarter, hasPaneer, hasVegDish, hasCurd, hasRotiOption, hasDal, hasRice, hasSnacks;
        ThaliInfo(int id, String name, double price,
                  boolean d, boolean s, boolean p, boolean v, boolean c, boolean r, boolean dal, boolean rice, boolean snacks) {
            this.id=id; this.name=name; this.pricePerPerson=price;
            this.hasDrinkOrSoup=d; this.hasStarter=s; this.hasPaneer=p; this.hasVegDish=v;
            this.hasCurd=c; this.hasRotiOption=r; this.hasDal=dal; this.hasRice=rice; this.hasSnacks=snacks;
        }
    }

    static final ThaliInfo[] VEG_THALIS = new ThaliInfo[] {
        new ThaliInfo(1, "Thali 1 (Rs.310)", 310, true, false, false, true, false, true, true, true, false),
        new ThaliInfo(2, "Thali 2 (Rs.360)", 360, true, true, false, true, true, true, true, true, false),
        new ThaliInfo(3, "Thali 3 (Rs.410)", 410, true, true, true, true, true, true, true, true, false),
        new ThaliInfo(4, "Thali 4 (Rs.470)", 470, true, true, true, true, true, true, true, true, true),
        new ThaliInfo(5, "Thali 5 (Rs.600)", 600, true, true, true, true, true, true, true, true, true),
        new ThaliInfo(6, "Thali 6 (Rs.700)", 700, true, true, true, true, true, true, true, true, true)
    };

    // Breakfast plans
    static class BreakfastPlan { int id; String name; double pricePerPerson; int heavySnackCount; BreakfastPlan(int id,String name,double p,int s){this.id=id;this.name=name;this.pricePerPerson=p;this.heavySnackCount=s;} }
    static final BreakfastPlan[] BF_PLANS = {
        new BreakfastPlan(1, "Plan 1 (Rs.200)", 200, 0),
        new BreakfastPlan(2, "Plan 2 (Rs.230)", 230, 1),
        new BreakfastPlan(3, "Plan 3 (Rs.250)", 250, 2)
    };

    // ---------- Utility helpers ----------
    static String repeat(String s, int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
    }

    static String stripAnsi(String s) {
        if (s == null) return "";
        return s.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    static String pad(String s, int width) {
        if (s == null) s = "";
        int visible = stripAnsi(s).length();
        if (visible < width) return s + repeat(" ", width - visible);
        return stripAnsi(s).substring(0, width);
    }

    static String center(String s, int width) {
        if (s == null) s = "";
        int visible = stripAnsi(s).length();
        if (visible >= width) return s;
        int left = (width - visible) / 2;
        int right = width - visible - left;
        return repeat(" ", left) + s + repeat(" ", right);
    }

    // Show numbered list and get choice (returns index 0..n-1, or -1 if back allowed and chosen)
    static int chooseFromList(String header, String[] items, boolean allowBack) {
        while (true) {
            System.out.println("\n--- " + header + " ---");
            for (int i = 0; i < items.length; i++) System.out.println((i+1) + ". " + items[i]);
            if (allowBack) System.out.println("0. Back");
            System.out.print("Enter number: ");
            String input = scanner.nextLine().trim();
            try {
                int ch = Integer.parseInt(input);
                if (allowBack && ch == 0) return -1;
                if (ch >= 1 && ch <= items.length) return ch-1;
            } catch (Exception ex) { /* ignore */ }
            System.out.println("Invalid input. Enter a number from the list.");
        }
    }

    // Choose multiple times (count) from list
    static List<String> chooseMultiple(String header, String[] items, int count) {
        List<String> chosen = new ArrayList<String>();
        if (count <= 0) return chosen;
        for (int i = 1; i <= count; i++) {
            int idx = chooseFromList(header + " (choice " + i + ")", items, false);
            chosen.add(items[idx]);
        }
        return chosen;
    }

    // Build a boxed column representation (array of lines)
    static String[] buildBox(String title, String[] lines, int width, String bgHeader, String fgHeader) {
        String top = TL + repeat(HR, width + 2) + TR;
        String sep = TLEFT + repeat(HR, width + 2) + TRIGHT;
        String bottom = BL + repeat(HR, width + 2) + BR;
        String[] box = new String[lines.length + 4];
        int i = 0;
        box[i++] = top;
        box[i++] = VL + " " + bgHeader + fgHeader + BOLD + pad(title, width) + RESET + " " + VL;
        box[i++] = sep;
        for (String line : lines) box[i++] = VL + " " + pad(line, width) + " " + VL;
        box[i] = bottom;
        return box;
    }

    // Print multiple boxes side-by-side inside a card background
    static void printBoxesInCard(String[][] boxes) {
        int maxLines = 0;
        for (String[] b : boxes) if (b.length > maxLines) maxLines = b.length;
        int boxLen = boxes[0][0].length();
        for (int r = 0; r < maxLines; r++) {
            StringBuilder row = new StringBuilder();
            row.append(BG_CARD); // card background for whole row
            for (String[] b : boxes) {
                if (r < b.length) row.append(b[r]);
                else row.append(repeat(" ", boxLen));
                row.append("  "); // gap between columns
            }
            row.append(RESET);
            System.out.println(row.toString());
        }
    }

    // ---------- Flow methods ----------
    public static void main(String[] args) {
        System.out.println(BOLD + "Welcome to JMB Hotel - Party Menu & Billing" + RESET);

        // Ask party size
        while (true) {
            System.out.print("Enter number of people in your party: ");
            String s = scanner.nextLine().trim();
            try {
                int n = Integer.parseInt(s);
                if (n <= 0) { System.out.println("Please enter at least 1."); continue; }
                partySize = n;
                break;
            } catch (Exception ex) { System.out.println("Enter a valid integer."); }
        }

        // Main menu loop
        while (true) {
            System.out.println("\nMain Menu - choose category:");
            System.out.println("1. Vegetarian Menu (Thalis)");
            System.out.println("2. Breakfast Menu");
            System.out.println("3. View Current Selections / Bill so far");
            System.out.println("0. Finish & Print Final Bill");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();
            if ("0".equals(choice)) break;
            if ("1".equals(choice)) handleVegetarianMenu();
            else if ("2".equals(choice)) handleBreakfastMenu();
            else if ("3".equals(choice)) printCurrentBill(false);
            else System.out.println("Invalid option. Try again.");
        }

        // Final bill
        printCurrentBill(true);
        System.out.println("Thank you! (JMB Hotel)");
    }

    // Vegetarian thali flow
    static void handleVegetarianMenu() {
        // Print thali boxes side-by-side (compact)
        String[] t1 = { "Thali 1 - Rs.310", "Includes: Drink/Soup, Veg, Roti, Dal, Rice, Sweet" };
        String[] t2 = { "Thali 2 - Rs.360", "Includes: Drink/Soup, Starter, Paneer, Veg, Dal, Rice, Curd, Sweet" };
        String[] t3 = { "Thali 3 - Rs.410", "Includes: Drink/Soup, Starter, Paneer, Veg, Dal, Rice, Curd, Sweet" };
        String[] t4 = { "Thali 4 - Rs.470", "Includes: Drink/Soup, 2 Starters, Paneer, Veg, Dal, Rice, Curd, Sweet, Snack" };
        String[] t5 = { "Thali 5 - Rs.600", "Includes more items (2 Paneer, 2 Veg, Curd, Sweet)" };
        String[] t6 = { "Thali 6 - Rs.700", "Top package with many items" };
        String[][] boxes = { buildBox("Thali 1", t1, 28, BG_BROWNRED, FG_WHITE),
                             buildBox("Thali 2", t2, 28, BG_BROWNRED, FG_WHITE),
                             buildBox("Thali 3", t3, 28, BG_BROWNRED, FG_WHITE),
                             buildBox("Thali 4", t4, 28, BG_BROWNRED, FG_WHITE) };
        printBoxesInCard(boxes);

        System.out.println("\nFull Thali list:");
        for (ThaliInfo t : VEG_THALIS) {
            System.out.println(t.id + ". " + t.name + "  (Rs. " + t.pricePerPerson + " per person)");
            List<String> desc = new ArrayList<String>();
            if (t.hasDrinkOrSoup) desc.add("Welcome Drink/Soup");
            if (t.hasStarter) desc.add("Starter");
            if (t.hasPaneer) desc.add("Paneer Dish");
            if (t.hasVegDish) desc.add("Vegetable Dish");
            if (t.hasDal) desc.add("Dal");
            if (t.hasRice) desc.add("Rice");
            if (t.hasRotiOption) desc.add("Roti/Naan/Paratha");
            if (t.hasCurd) desc.add("Curd Dish");
            if (t.hasSnacks) desc.add("Snacks/Chinese/Conti");
            System.out.println("   Includes: " + String.join(", ", desc));
        }
        System.out.println("0. Back to main menu");

        // choose thalis (allow multiple adds)
        while (true) {
            System.out.print("Enter Thali number to add to order (or 0 to go back): ");
            String in = scanner.nextLine().trim();
            try {
                int ch = Integer.parseInt(in);
                if (ch == 0) return;
                ThaliInfo chosen = null;
                for (ThaliInfo t : VEG_THALIS) if (t.id == ch) chosen = t;
                if (chosen == null) { System.out.println("Invalid thali number."); continue; }

                // Show full items that will be offered (high level)
                System.out.println("\nYou selected: " + chosen.name + " (Rs. " + chosen.pricePerPerson + " per person)");
                System.out.println("This thali will include:");
                List<String> full = new ArrayList<String>();
                if (chosen.hasDrinkOrSoup) full.add("Welcome Drink or Soup (choose now)");
                if (chosen.hasStarter) full.add("Starter (choose now)");
                if (chosen.hasPaneer) full.add("Paneer Dish (choose now)");
                if (chosen.hasVegDish) full.add("Vegetable Dish (choose now)");
                if (chosen.hasDal) full.add("Dal (choose now)");
                if (chosen.hasRice) full.add("Rice (choose now)");
                if (chosen.hasRotiOption) full.add("Roti/Naan/Paratha (choose now)");
                if (chosen.hasCurd) full.add("Curd Dish (choose now)");
                if (chosen.hasSnacks) full.add("Snacks or Chinese/Continental (choose now)");
                full.add("Sweet Dish & Ice Cream");
                for (String f : full) System.out.println(" - " + f);

                System.out.print("Confirm add this thali for the whole party? (yes/no): ");
                String confirm = scanner.nextLine().trim().toLowerCase();
                if (!"yes".equals(confirm)) { System.out.println("Cancelled."); continue; }

                Selection sel = new Selection(chosen.name + " x" + partySize + " persons", chosen.pricePerPerson * partySize);
                grandTotal += sel.price;

                // sub-choices
                if (chosen.hasDrinkOrSoup) {
                    System.out.println("\nChoose Welcome Drink or Soup:");
                    System.out.println("1. Mocktail");
                    System.out.println("2. Soup");
                    System.out.print("Enter 1 or 2: ");
                    String choice = scanner.nextLine().trim();
                    if ("1".equals(choice)) {
                        int idx = chooseFromList("Mocktails", MOCKTAILS, false);
                        sel.extras.add("Welcome Drink: " + MOCKTAILS[idx]);
                    } else {
                        int idx = chooseFromList("Soups", SOUPS, false);
                        sel.extras.add("Soup: " + SOUPS[idx]);
                    }
                }

                if (chosen.hasStarter) {
                    int idx = chooseFromList("Starters", STARTERS, false);
                    sel.extras.add("Starter: " + STARTERS[idx]);
                }

                if (chosen.hasPaneer) {
                    int idx = chooseFromList("Paneer Dishes", PANEER_DISHES, false);
                    sel.extras.add("Paneer Dish: " + PANEER_DISHES[idx]);
                }

                if (chosen.hasVegDish) {
                    int idx = chooseFromList("Vegetable Dishes", VEGETABLES, false);
                    sel.extras.add("Vegetable Dish: " + VEGETABLES[idx]);
                }

                if (chosen.hasDal) {
                    int idx = chooseFromList("Dals", DALS, false);
                    sel.extras.add("Dal: " + DALS[idx]);
                }

                if (chosen.hasRice) {
                    int idx = chooseFromList("Rice", RICES, false);
                    sel.extras.add("Rice: " + RICES[idx]);
                }

                if (chosen.hasRotiOption) {
                    int idx = chooseFromList("Roti/Bread choices", ROTIS, false);
                    sel.extras.add("Bread: " + ROTIS[idx]);
                }

                if (chosen.hasCurd) {
                    int idx = chooseFromList("Curd Dishes", CURD_DISHES, false);
                    sel.extras.add("Curd: " + CURD_DISHES[idx]);
                }

                if (chosen.hasSnacks) {
                    System.out.println("\nChoose extra category:");
                    System.out.println("1. Snacks");
                    System.out.println("2. Chinese & Continental");
                    System.out.print("Enter choice: ");
                    String z = scanner.nextLine().trim();
                    if ("1".equals(z)) {
                        int idx = chooseFromList("Snacks", SNACKS, false);
                        sel.extras.add("Snack: " + SNACKS[idx]);
                    } else {
                        int idx = chooseFromList("Chinese & Continental", CHINESE_CONTI, false);
                        sel.extras.add("Chinese/Conti: " + CHINESE_CONTI[idx]);
                    }
                }

                // sweet default (can be changed by asking if needed)
                sel.extras.add("Sweet & Ice Cream: Included");

                selections.add(sel);
                System.out.printf("Added %s -> ₹%.2f\n", sel.title, sel.price);

                System.out.print("Add another thali? (yes/no): ");
                String more = scanner.nextLine().trim().toLowerCase();
                if (!"yes".equals(more)) return;

            } catch (Exception ex) {
                System.out.println("Invalid input. Enter thali number.");
            }
        }
    }

    // Breakfast flow
    static void handleBreakfastMenu() {
        // show breakfast plans
        String[] b1 = { "Plan 1 - Rs.200", "Poha, Jalebi, Tea/Coffee" };
        String[] b2 = { "Plan 2 - Rs.230", "Poha, Bread Item, Sweet Dish, Tea/Coffee" };
        String[] b3 = { "Plan 3 - Rs.250", "Poha, Bread Item, Heavy Snacks, Tea/Coffee" };
        String[][] boxes = { buildBox("Plan 1", b1, 32, BG_GREEN, FG_WHITE),
                             buildBox("Plan 2", b2, 32, BG_GREEN, FG_WHITE),
                             buildBox("Plan 3", b3, 32, BG_GREEN, FG_WHITE) };
        printBoxesInCard(boxes);

        System.out.println("\nBreakfast Plans:");
        for (BreakfastPlan p : BF_PLANS) {
            System.out.println(p.id + ". " + p.name + " (Rs. " + p.pricePerPerson + " per person)");
            System.out.println("   Includes: Welcome Drink, Jalebi, Breakfast Item, Tea/Coffee" + (p.heavySnackCount>0? ", Heavy Snack(s)":""));
        }
        System.out.println("0. Back");

        while (true) {
            System.out.print("Enter plan number to add (or 0 to go back): ");
            String in = scanner.nextLine().trim();
            try {
                int ch = Integer.parseInt(in);
                if (ch == 0) return;
                BreakfastPlan chosen = null;
                for (BreakfastPlan p : BF_PLANS) if (p.id == ch) chosen = p;
                if (chosen == null) { System.out.println("Invalid plan number."); continue; }

                System.out.println("\nYou selected: " + chosen.name);
                System.out.print("Confirm add this plan for entire party? (yes/no): ");
                String confirm = scanner.nextLine().trim().toLowerCase();
                if (!"yes".equals(confirm)) { System.out.println("Cancelled."); continue; }

                Selection sel = new Selection(chosen.name + " x" + partySize + " persons", chosen.pricePerPerson * partySize);
                grandTotal += sel.price;

                // coffee or chai
                System.out.print("Do guests prefer Coffee or Chai? (1 Coffee / 2 Chai): ");
                String drink = scanner.nextLine().trim();
                if ("1".equals(drink)) sel.extras.add("Drink preference: Coffee");
                else sel.extras.add("Drink preference: Chai");

                // heavy snacks
                if (chosen.heavySnackCount > 0) {
                    List<String> hs = chooseMultiple("Heavy Snacks", HEAVY_SNACKS, chosen.heavySnackCount);
                    for (String h : hs) sel.extras.add("Heavy snack: " + h);
                }

                selections.add(sel);
                System.out.printf("Added %s -> ₹%.2f\n", sel.title, sel.price);

                System.out.print("Add another breakfast plan? (yes/no): ");
                String more = scanner.nextLine().trim().toLowerCase();
                if (!"yes".equals(more)) return;

            } catch (Exception ex) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    // Print current bill or final invoice
    static void printCurrentBill(boolean finalPrint) {
        System.out.println("\n====================================");
        System.out.println("           JMB Hotel Bill");
        System.out.println("====================================");
        if (selections.isEmpty()) {
            System.out.println("No items selected yet.");
        } else {
            double sum = 0.0;
            int idx = 1;
            for (Selection s : selections) {
                System.out.printf("%d) %s   -> ₹%.2f\n", idx++, s.title, s.price);
                for (String e : s.extras) System.out.println("     - " + e);
                sum += s.price;
                System.out.println();
            }
            System.out.printf("Subtotal: ₹%.2f\n", sum);
            double gst = sum * 0.05; // sample GST 5%
            System.out.printf("GST (5%%): ₹%.2f\n", gst);
            System.out.printf("Total Payable: ₹%.2f\n", sum + gst);
            grandTotal = sum + gst;
        }
        System.out.println("====================================");

        if (finalPrint && !selections.isEmpty()) {
            printColorCardInvoice();
        }
    }

    // Print colored invoice card
    static void printColorCardInvoice() {
        List<String> lines = new ArrayList<String>();
        lines.add(center("JMB HOTEL - PARTY BILL", 86));
        lines.add("");
        lines.add("Party Size: " + partySize);
        lines.add("");
        double subtotal = 0.0;
        for (Selection s : selections) {
            lines.add(s.title + "  -> ₹" + String.format("%.2f", s.price));
            subtotal += s.price;
            for (String e : s.extras) {
                String shortE = e.length() > 70 ? e.substring(0,67) + "..." : e;
                lines.add("   * " + shortE);
            }
            lines.add("");
        }
        lines.add(String.format("Subtotal: ₹%.2f", subtotal));
        double gst = subtotal * 0.05;
        lines.add(String.format("GST (5%%): %.2f", gst));
        lines.add(String.format("TOTAL: %.2f", subtotal + gst));
        lines.add("");
        lines.add("Booking confirmed only with advance deposit.");
        lines.add("Thank you for choosing JMB Hotel!");

        int width = 86;
        String top = TL + repeat(HR, width) + TR;
        String bottom = BL + repeat(HR, width) + BR;
        System.out.println(BG_CARD + top + RESET);
        for (String line : lines) {
            String padded = padInside(line, width);
            System.out.println(BG_CARD + VL + padded + VL + RESET);
        }
        System.out.println(BG_CARD + bottom + RESET);
    }

    static String padInside(String s, int width) {
        int visible = stripAnsi(s).length();
        if (visible >= width) return s.substring(0, width);
        int leftPad = (width - visible) / 2;
        int rightPad = width - visible - leftPad;
        return repeat(" ", leftPad) + s + repeat(" ", rightPad);
    }
}
