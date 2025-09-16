/*// ColoredMenu.java
// Java 8 compatible: prints a multi-column colored menu to terminal using ANSI escape codes.

public class ColoredMenu {
    // ANSI escape codes
    public static final String RESET  = "\u001B[0m";
    public static final String BOLD   = "\u001B[1m";

    public static final String BLACK  = "\u001B[30m";
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";
    public static final String MAGENTA= "\u001B[35m";
    public static final String CYAN   = "\u001B[36m";
    public static final String WHITE  = "\u001B[37m";

    public static final String BG_RED    = "\u001B[41m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE   = "\u001B[44m";
    public static final String BG_MAGENTA= "\u001B[45m";
    public static final String BG_CYAN   = "\u001B[46m";
    public static final String BG_WHITE  = "\u001B[47m";

    // simple repeat helper (works on Java 8)
    static String repeat(char ch, int count) {
        if (count <= 0) return "";
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) sb.append(ch);
        return sb.toString();
    }

    // strip ANSI escape sequences for length calculations
    static String stripAnsi(String s) {
        if (s == null) return "";
        // \u001B is the ESC char; regex escapes [ and digits
        return s.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    // pad right to a visible width (keeps ANSI sequences intact for non-truncated text)
    static String padRight(String text, int width) {
        if (text == null) text = "";
        int visibleLen = stripAnsi(text).length();
        if (visibleLen == width) return text;
        if (visibleLen < width) return text + repeat(' ', width - visibleLen);
        // if longer than width -> return truncated plain text (loses color for that truncated cell)
        return stripAnsi(text).substring(0, width);
    }

    public static void main(String[] args) {
        final int COL1 = 38, COL2 = 28, COL3 = 28, COL4 = 28;

        String[] vegetarian = {
            BOLD + "VEGETARIAN MENU" + RESET,
            "Timing: Max 3 hrs",
            "Extra per hour: 150/-",
            "",
            BOLD + "A - Rs.310/-" + RESET,
            "Soup/Welcome Drink",
            "Vegetable Dish",
            "Roti, Naan, Butter Paratha",
            "Pickle, Salad, Papad",
            "Sweet Dish",
            "",
            BOLD + "B - Rs.360/-" + RESET,
            "Soup/Welcome Drink",
            "Paneer Dish",
            "Vegetable Dish",
            "Dal",
            "Rice, Roti, Naan",
            "Pickle, Salad, Papad",
            "Sweet Dish",
            "",
            BOLD + "C - Rs.410/-" + RESET,
            "Soup/Welcome Drink",
            "Starter",
            "Paneer Dish",
            "Vegetable Dish",
            "Dal, Rice",
            "Roti, Naan, Paratha",
            "Pickle, Salad, Papad",
            "Sweet Dish",
            "",
            BOLD + "D - Rs.470/-" + RESET,
            "Soup/Welcome Drink",
            "2 Starter",
            "Paneer Dish",
            "Vegetable Dish",
            "Dal, Rice",
            "Roti, Naan, Paratha",
            "Pickle, Salad, Papad",
            "Ice Cream/Coffee",
            "",
            BOLD + "E - Rs.600/-" + RESET,
            "Soup/Welcome Drink",
            "2 Starter",
            "2 Paneer Dish",
            "Vegetable Dish",
            "Dal, Rice",
            "Roti, Naan, Paratha",
            "Pickle, Salad, Papad",
            "Curd Dish",
            "Ice Cream/Coffee",
            "",
            BOLD + "F - Rs.700/-" + RESET,
            "Soup/Welcome Drink",
            "2 Starter",
            "2 Paneer Dish",
            "2 Vegetable Dish",
            "Dal, Rice",
            "Roti, Naan, Paratha",
            "Pickle, Salad, Papad",
            "Curd Dish",
            "Ice Cream/Coffee"
        };

        String[] breakfast = {
            BOLD + "BREAKFAST MENU" + RESET,
            "",
            "A - Rs.200/-",
            "Poha",
            "Jalebi",
            "Tea or Coffee",
            "",
            "B - Rs.230/-",
            "Poha",
            "Bread Item",
            "Sweet Dish",
            "Tea or Coffee",
            "",
            "C - Rs.250/-",
            "Poha",
            "Bread Item",
            "Heavy Snacks",
            "Tea or Coffee",
            "",
            "Only For Ladies - 4 to 6pm",
            "(After 6pm: 20/- extra)"
        };

        String[] paneerSide = {
            BOLD + "MOCKTAIL" + RESET,
            "Blue Lagoon",
            "Orange Pink City",
            "Strawberry Delight",
            "Jal Jeera",
            "Fresh Lime Water",
            "Butter Milk",
            "Rasna Water",
            "",
            BOLD + "PANEER STARTERS" + RESET,
            "Paneer Chilli",
            "Paneer Tikka",
            "Paneer Pudina Tikka",
            "Paneer Achari Tikka",
            "Paneer 65",
            "Dragon Paneer",
            "",
            BOLD + "PANEER DISH" + RESET,
            "Paneer Butter Masala",
            "Paneer Kadai",
            "Paneer Punjabi",
            "Methi Paneer",
            "Paneer Palak",
            "Corn Paneer",
            "Paneer Mutter",
            "Paneer Kolhapuri",
            "Paneer Do Pyaza",
            "Paneer Chatpata",
            "Paneer Tikka Masala"
        };

        String[] extras = {
            BOLD + "CURD DISH" + RESET,
            "Boondi Raita",
            "Fruit Raita",
            "Aloo Raita",
            "Dahi Vada",
            "",
            BOLD + "SOUP" + RESET,
            "Tomato Soup",
            "Hot & Sour Veg",
            "Veg Manchow",
            "Lemon Coriander",
            "",
            BOLD + "SWEETS / ICE CREAM" + RESET,
            "Gulab Jamun",
            "Jalebi",
            "Moong Dal Halwa",
            "Shreekhand",
            "Aam Ras (seasonal)",
            "Rasgulla",
            "Vanilla",
            "Butter Scotch",
            "Sitafal Basundi"
        };

        int max = Math.max(Math.max(vegetarian.length, breakfast.length),
                           Math.max(paneerSide.length, extras.length));

        // Title block
        System.out.println();
        System.out.println(BG_RED + WHITE + BOLD + " COMPLETE MENU " + RESET);
        System.out.println();

        for (int i = 0; i < max; i++) {
            String c1 = i < vegetarian.length ? vegetarian[i] : "";
            String c2 = i < breakfast.length ? breakfast[i] : "";
            String c3 = i < paneerSide.length ? paneerSide[i] : "";
            String c4 = i < extras.length ? extras[i] : "";

            System.out.printf("%s%s%s%s\n",
                    padRight(YELLOW  + c1 + RESET, COL1),
                    padRight(CYAN    + c2 + RESET, COL2),
                    padRight(MAGENTA + c3 + RESET, COL3),
                    padRight(GREEN   + c4 + RESET, COL4));
        }

        System.out.println();
        System.out.println(BG_YELLOW + BLACK + " Booking will only be confirmed with advance deposit. 100% payment before event. " + RESET);
        System.out.println();
    }
}
*/
// ColoredMenu.java
// Full menu with truecolor headers (as in photo)

// ColoredMenu.java
// Fixed: uses Unicode escapes for box-drawing characters (avoids encoding corruption).
// Java 8 compatible.
/*
public class ColoredMenu {
    // ANSI helpers
    public static final String ESC = "\u001B";
    public static final String RESET = ESC + "[0m";
    public static final String BOLD  = ESC + "[1m";

    // Truecolor header backgrounds (RGB)
    public static final String BG_BROWNRED = ESC + "[48;2;139;69;19m";   // vegetarian-like
    public static final String BG_GREEN    = ESC + "[48;2;34;139;34m";   // breakfast-like
    public static final String BG_ORANGE   = ESC + "[48;2;255;140;0m";   // mocktail-like
    public static final String BG_BLUE     = ESC + "[48;2;30;144;255m";  // curd/sweets-like

    public static final String WHITE_FG = ESC + "[38;2;255;255;255m";
    public static final String BLACK_FG = ESC + "[38;2;0;0;0m";

    // Box-drawing characters (use Unicode escapes to avoid encoding issues)
    public static final String TOP_LEFT     = "\u250C"; // 
    public static final String HORIZONTAL   = "\u2500"; // 
    public static final String TOP_RIGHT    = "\u2510"; // 
    public static final String VERTICAL     = "\u2502"; // 
    public static final String BOTTOM_LEFT  = "\u2514"; // 
    public static final String BOTTOM_RIGHT = "\u2518"; // 
    public static final String T_LEFT       = "\u251C"; // 
    public static final String T_RIGHT      = "\u2524"; // 

    // repeat a string n times
    static String repeat(String s, int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
    }

    // remove ANSI sequences for length calculations
    static String stripAnsi(String s) {
        if (s == null) return "";
        return s.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    // pad to visible width (keeps ANSI escape sequences intact)
    static String pad(String s, int width) {
        if (s == null) s = "";
        int visible = stripAnsi(s).length();
        if (visible < width) return s + repeat(" ", width - visible);
        return stripAnsi(s).substring(0, width);
    }

    // build one boxed column as array of lines
    static String[] buildBox(String title, String[] lines, int width, String bgColor, String fgColor) {
        String top = TOP_LEFT + repeat(HORIZONTAL, width + 2) + TOP_RIGHT;
        String sep = T_LEFT + repeat(HORIZONTAL, width + 2) + T_RIGHT;
        String bottom = BOTTOM_LEFT + repeat(HORIZONTAL, width + 2) + BOTTOM_RIGHT;

        String[] box = new String[lines.length + 4]; // top, title, sep, content..., bottom
        int i = 0;
        box[i++] = top;
        box[i++] = VERTICAL + " " + bgColor + fgColor + BOLD + pad(title, width) + RESET + " " + VERTICAL;
        box[i++] = sep;
        for (String line : lines) {
            box[i++] = VERTICAL + " " + pad(line, width) + " " + VERTICAL;
        }
        box[i] = bottom;
        return box;
    }

    // print multiple boxes side by side (pads shorter boxes)
    static void printRowBoxes(String[][] boxes) {
        int maxLines = 0;
        for (String[] b : boxes) if (b.length > maxLines) maxLines = b.length;
        int boxLen = boxes[0][0].length(); // length of top line (all boxes use same width)

        for (int r = 0; r < maxLines; r++) {
            StringBuilder row = new StringBuilder();
            for (String[] b : boxes) {
                if (r < b.length) row.append(b[r]);
                else row.append(repeat(" ", boxLen));
                row.append("  "); // gap between boxes
            }
            System.out.println(row.toString());
        }
    }

    public static void main(String[] args) {
        final int width = 34; // adjust to match the visual width you want

        String[] vegetarian = {
            "A - Rs.310/-", "Soup/Welcome Drink", "Vegetable Dish", "Roti, Naan, Paratha", "Sweet Dish", "",
            "B - Rs.360/-", "Soup/Welcome Drink", "Paneer Dish", "Dal, Rice, Roti", "Sweet Dish", "",
            "C - Rs.410/-", "Soup/Welcome Drink", "Starter", "Paneer Dish", "Dal, Rice", "Sweet Dish", "",
            "D - Rs.470/-", "Soup/Welcome Drink", "2 Starter", "Paneer Dish", "Dal, Rice", "Ice Cream/Coffee", "",
            "E - Rs.600/-", "Soup/Welcome Drink", "2 Starter, 2 Paneer", "Veg Dish, Dal, Rice", "Curd Dish", "Ice Cream/Coffee", "",
            "F - Rs.700/-", "Soup/Welcome Drink", "2 Starter, 2 Paneer", "2 Veg Dish, Dal, Rice", "Curd Dish", "Ice Cream/Coffee"
        };

        String[] breakfast = {
            "A - Rs.200/-", "Poha, Jalebi", "Tea or Coffee", "",
            "B - Rs.230/-", "Poha, Bread Item", "Sweet Dish", "Tea or Coffee", "",
            "C - Rs.250/-", "Poha, Bread Item", "Heavy Snacks", "Tea or Coffee", "",
            "Ladies Special", "4 to 6pm only", "After 6pm +20/-"
        };

        String[] mocktailPaneer = {
            "MOCKTAIL", "Blue Lagoon", "Strawberry Delight", "Orange Pink City", "Jal Jeera", "Butter Milk", "Rasna Water", "",
            "PANEER STARTERS", "Paneer Chilli", "Paneer Tikka", "Paneer Pudina Tikka", "Paneer Achari Tikka", "Paneer 65", "Dragon Paneer", "",
            "PANEER DISH", "Paneer Butter Masala", "Paneer Kadai", "Paneer Punjabi", "Paneer Palak", "Paneer Mutter", "Paneer Kolhapuri", "Paneer Do Pyaza", "Paneer Chatpata", "Paneer Tikka Masala"
        };

        String[] extras = {
            "CURD DISH", "Boondi Raita", "Fruit Raita", "Aloo Raita", "Dahi Vada", "",
            "SOUP", "Tomato Soup", "Hot & Sour Veg", "Veg Manchow", "Lemon Coriander", "",
            "SWEETS/ICE CREAM", "Gulab Jamun", "Jalebi", "Moong Dal Halwa", "Shreekhand", "Aam Ras (Seasonal)", "Rasgulla", "Vanilla", "Butterscotch", "Sitafal Basundi"
        };

        String[] box1 = buildBox("VEGETARIAN MENU", vegetarian, width, BG_BROWNRED, WHITE_FG);
        String[] box2 = buildBox("BREAKFAST MENU", breakfast, width, BG_GREEN, WHITE_FG);
        String[] box3 = buildBox("MOCKTAIL & PANEER", mocktailPaneer, width, BG_ORANGE, BLACK_FG);
        String[] box4 = buildBox("CURD / SOUP / SWEETS", extras, width, BG_BLUE, WHITE_FG);

        printRowBoxes(new String[][] { box1, box2, box3, box4 });

        System.out.println();
        System.out.println(ESC + "[48;2;200;0;0m" + WHITE_FG + " Booking confirmed only with advance deposit (100% before event) " + RESET);
    }
}
*/
public class ColoredMenu {
    // 🎨 ANSI escape code base
    public static final String ESC = "\u001B";
    public static final String RESET = ESC + "[0m";   // reset colors
    public static final String BOLD  = ESC + "[1m";   // bold text

    // 🎨 Background colors (easy names instead of numbers)
    public static final String BG_BROWNRED = ESC + "[48;2;139;69;19m";   // Vegetarian menu
    public static final String BG_GREEN    = ESC + "[48;2;34;139;34m";   // Breakfast menu
    public static final String BG_ORANGE   = ESC + "[48;2;255;140;0m";   // Mocktail & Paneer
    public static final String BG_BLUE     = ESC + "[48;2;30;144;255m";  // Curd / Sweets
    public static final String BG_CARD     = ESC + "[48;2;240;240;220m"; // Whole card background

    // 🎨 Text colors
    public static final String WHITE_FG = ESC + "[38;2;255;255;255m";  
    public static final String BLACK_FG = ESC + "[38;2;0;0;0m";        

    // 🟦 Box border characters
    public static final String TOP_LEFT     = "\u250C"; 
    public static final String HORIZONTAL   = "\u2500"; 
    public static final String TOP_RIGHT    = "\u2510"; 
    public static final String VERTICAL     = "\u2502"; 
    public static final String BOTTOM_LEFT  = "\u2514"; 
    public static final String BOTTOM_RIGHT = "\u2518"; 
    public static final String T_LEFT       = "\u251C"; 
    public static final String T_RIGHT      = "\u2524"; 

    // repeat helper
    static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
    }

    // strip colors for length calculation
    static String stripAnsi(String s) {
        return s.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    // padding text inside box
    static String pad(String s, int width) {
        int visible = stripAnsi(s).length();
        if (visible < width) return s + repeat(" ", width - visible);
        return s.substring(0, width);
    }

    // build one box column
    static String[] buildBox(String title, String[] lines, int width, String bgColor, String fgColor) {
        String top = TOP_LEFT + repeat(HORIZONTAL, width + 2) + TOP_RIGHT;
        String sep = T_LEFT + repeat(HORIZONTAL, width + 2) + T_RIGHT;
        String bottom = BOTTOM_LEFT + repeat(HORIZONTAL, width + 2) + BOTTOM_RIGHT;

        String[] box = new String[lines.length + 4];
        int i = 0;
        box[i++] = top;
        box[i++] = VERTICAL + " " + bgColor + fgColor + BOLD + pad(title, width) + RESET + " " + VERTICAL;
        box[i++] = sep;
        for (String line : lines) {
            box[i++] = VERTICAL + " " + pad(line, width) + " " + VERTICAL;
        }
        box[i] = bottom;
        return box;
    }

    // print boxes side by side with card background
    static void printRowBoxes(String[][] boxes) {
        int maxLines = 0;
        for (String[] b : boxes) if (b.length > maxLines) maxLines = b.length;
        int boxLen = boxes[0][0].length();

        for (int r = 0; r < maxLines; r++) {
            StringBuilder row = new StringBuilder();
            row.append(BG_CARD);  // apply card background
            for (String[] b : boxes) {
                if (r < b.length) row.append(b[r]);
                else row.append(repeat(" ", boxLen));
                row.append("  "); // gap
            }
            row.append(RESET);
            System.out.println(row.toString());
        }
    }

    public static void main(String[] args) {
        final int width = 30;

        //  Vegetarian Menu
        String[] vegetarian = {
            "A - Rs.310/-", "Soup/Welcome Drink", "Vegetable Dish", "Roti, Naan, Paratha", "Sweet Dish", "",
            "B - Rs.360/-", "Soup/Welcome Drink", "Paneer Dish", "Dal, Rice, Roti", "Sweet Dish"
        };

        //  Breakfast Menu
        String[] breakfast = {
            "A - Rs.200/-", "Poha, Jalebi", "Tea or Coffee", "",
            "B - Rs.230/-", "Poha, Bread Item", "Sweet Dish", "Tea or Coffee"
        };

        //  Mocktail & Paneer
        String[] mocktailPaneer = {
            "MOCKTAIL", "Blue Lagoon", "Strawberry Delight", "Orange Pink City", "Jal Jeera", "",
            "PANEER STARTERS", "Paneer Chilli", "Paneer Tikka", "Paneer Pudina Tikka"
        };

        //  Curd / Soup / Sweets
        String[] extras = {
            "CURD DISH", "Boondi Raita", "Fruit Raita", "Aloo Raita", "",
            "SOUP", "Tomato Soup", "Veg Manchow", "Lemon Coriander", "",
            "SWEETS", "Gulab Jamun", "Jalebi", "Rasgulla"
        };

        // build boxes
        String[] box1 = buildBox("VEGETARIAN MENU", vegetarian, width, BG_BROWNRED, WHITE_FG);
        String[] box2 = buildBox("BREAKFAST MENU", breakfast, width, BG_GREEN, WHITE_FG);
        String[] box3 = buildBox("MOCKTAIL & PANEER", mocktailPaneer, width, BG_ORANGE, BLACK_FG);
        String[] box4 = buildBox("CURD / SOUP / SWEETS", extras, width, BG_BLUE, WHITE_FG);

        // print with card background
        printRowBoxes(new String[][] { box1, box2, box3, box4 });

        // footer note
        System.out.println();
        System.out.println(BG_CARD + BOLD + BLACK_FG +
                " Booking confirmed only with advance deposit (100% before event) " + RESET);
    }
}
