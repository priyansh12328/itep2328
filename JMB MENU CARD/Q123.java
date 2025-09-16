import java.util.Scanner;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
  JMBBilling.java
  Console-based restaurant billing that follows user's requirements:
  - Numeric selections (1..6)
  - No arrays
  - Colorful menus with ANSI colors
  - Thali selection drives included-item prompts (paneer, veg, dal, rice, roti, soup/drink, dessert)
  - Only Thali price is charged (other items recorded for kitchen)
  - Option to add Breakfast/Snacks/Chinese/Mocktail/Sweets counts (recorded, not charged)
  - Professional bill printed with white background simulation and proper alignment
*/

public class Q123 {

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

        // ====== Header & customer details ======
        System.out.println(PURPLE + BOLDString("==========================================") + RESET);
        System.out.println(PURPLE + BOLDString("         WELCOME TO JMB HOTEL (JMB)       ") + RESET);
        System.out.println(PURPLE + BOLDString("==========================================") + RESET);

        System.out.print(YELLOW + "Enter Customer Name: " + RESET);
        String customerName = sc.nextLine().trim();

        System.out.print(YELLOW + "Enter Booking Date (dd-MM-yyyy): " + RESET);
        String bookingDate = sc.nextLine().trim();

        int partySize = getPositiveInt(sc, YELLOW + "Enter number of people in the party: " + RESET);

        // Generate bill metadata
        int billNo = rand.nextInt(900000) + 100000;
        Date now = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        String today = sdfDate.format(now);
        String timeNow = sdfTime.format(now);

        // ====== Order storage (no arrays) ======
        // We will store selected names (Strings allowed) and counts as separate variables
        // Thali selection
        int thaliChoice = 0;
        String thaliName = "";
        int thaliPrice = 0;
        int thaliQty = 0;
        int freeThalis = 0;

        // Included selections (words stored individually)
        String selectedSoupOrDrink = "";
        String veg1 = "";
        String veg2 = "";
        String paneerSelected = "";
        String dalSelected = "";
        String riceSelected = "";
        String rotiSelected = "";
        String curdSelected = "";
        String starterSelected = "";
        String dessertType = ""; // "Ice Cream" or "Sweet"
        String dessertChoice = ""; // e.g. "Vanilla" or "Gulab Jamun"

        // Other categories recorded (counts only)
        int breakfastCount = 0;
        int snacksCount = 0;
        int chineseCount = 0;
        int mocktailCount = 0;
        int sweetsCount = 0;

        // Grand financials (only thali is charged)
        double subtotal = 0.0;
        double gst = 0.0;
        double grandTotal = 0.0;

        // ====== Start main selection flow (console) ======
        System.out.println(CYAN + "\nMAIN MENU - Choose: " + RESET);
        System.out.println(GREEN + "1. Vegetarian Thali" + RESET);
        System.out.println(GREEN + "2. Breakfast Thali" + RESET);
        System.out.println(GREEN + "3. Exit & Print Bill" + RESET);

        int mainChoice = 0;
        do {
            mainChoice = getIntInRange(sc, CYAN + "Enter main choice (1-3): " + RESET, 1, 3);
            if (mainChoice == 1) {
                // ---- Vegetarian Thali flow ----
                System.out.println(BLUE + "\nVEGETARIAN THALI MENU (choose 1-6):" + RESET);
                System.out.println(YELLOW + "1. Thali 1 - Rs.310 (Soup/Drink, 1 Veg, Paneer, Roti, Rice, Sweet)" + RESET);
                System.out.println(YELLOW + "2. Thali 2 - Rs.360 (Soup/Drink, 2 Veg, Paneer, Roti, Rice, Salad, Sweet)" + RESET);
                System.out.println(YELLOW + "3. Thali 3 - Rs.410 (Soup/Drink, 2 Veg, Paneer, Dal, Rice, Sweet)" + RESET);
                System.out.println(YELLOW + "4. Thali 4 - Rs.470 (Soup/Drink, 2 Veg, Paneer, Dal, Rice, IceCream/Coffee)" + RESET);
                System.out.println(YELLOW + "5. Thali 5 - Rs.600 (Soup/Drink, Starter, 2 Veg, Paneer, Dal, Curd, Rice, IceCream/Coffee)" + RESET);
                System.out.println(YELLOW + "6. Thali 6 - Rs.700 (Soup/Drink, Starter, 2 Veg, Paneer, Dal, Curd, Rice, IceCream/Coffee)" + RESET);

                thaliChoice = getIntInRange(sc, GREEN + "Select Thali number (1-6): " + RESET, 1, 6);

                // Describe selected thali and set price/name
                if (thaliChoice == 1) {
                    thaliName = "Thali 1";
                    thaliPrice = 310;
                    System.out.println(GREEN + "Thali 1 selected. Includes: Soup or Welcome Drink, 1 Vegetable dish, Paneer dish, Roti, Rice, Sweet." + RESET);
                } else if (thaliChoice == 2) {
                    thaliName = "Thali 2";
                    thaliPrice = 360;
                    System.out.println(GREEN + "Thali 2 selected. Includes: Soup/Drink, 2 Vegetable dishes, Paneer, Roti, Rice, Salad, Sweet." + RESET);
                } else if (thaliChoice == 3) {
                    thaliName = "Thali 3";
                    thaliPrice = 410;
                    System.out.println(GREEN + "Thali 3 selected. Includes: Soup/Drink, 2 Veg, Paneer, Dal, Rice, Sweet." + RESET);
                } else if (thaliChoice == 4) {
                    thaliName = "Thali 4";
                    thaliPrice = 470;
                    System.out.println(GREEN + "Thali 4 selected. Includes: Soup/Drink, 2 Veg, Paneer, Dal, Rice, Ice Cream or Coffee." + RESET);
                } else if (thaliChoice == 5) {
                    thaliName = "Thali 5";
                    thaliPrice = 600;
                    System.out.println(GREEN + "Thali 5 selected. Includes: Soup/Drink, Starter, 2 Veg, Paneer, Dal, Curd, Rice, Ice Cream or Coffee." + RESET);
                } else {
                    thaliName = "Thali 6";
                    thaliPrice = 700;
                    System.out.println(GREEN + "Thali 6 selected. Includes: Soup/Drink, Starter, 2 Veg, Paneer, Dal, Curd, Rice, Ice Cream or Coffee." + RESET);
                }

                // Confirm
                int like = getIntInRange(sc, CYAN + "Do you like this Thali? 1 = Yes, 0 = No : " + RESET, 0, 1);
                if (like == 0) {
                    System.out.println(RED + "Thali not confirmed. Returning to main menu." + RESET);
                    continue; // go back to main menu prompt
                }

                // Quantity
                thaliQty = getPositiveInt(sc, GREEN + "Enter number of thalis you want: " + RESET);
                if (thaliQty > 100) {
                    freeThalis = 5;
                    System.out.println(GREEN + "Offer applied: 5 free thalis added." + RESET);
                }

                // Now choose ITEMS included by this thali (record choices)
                // 1) Soup or Welcome Drink (choose one)
                System.out.println(BLUE + "\nChoose Soup or Welcome Drink (choose one):" + RESET);
                System.out.println(YELLOW + "1. Tomato Soup" + RESET);
                System.out.println(YELLOW + "2. Veg Manchow" + RESET);
                System.out.println(YELLOW + "3. Lemon Coriander" + RESET);
                System.out.println(YELLOW + "4. Hot & Sour Veg" + RESET);
                System.out.println(YELLOW + "5. Welcome Drink - Fresh Lime" + RESET);
                int sd = getIntInRange(sc, CYAN + "Enter choice (1-5): " + RESET, 1, 5);
                if (sd == 1) selectedSoupOrDrink = "Tomato Soup";
                else if (sd == 2) selectedSoupOrDrink = "Veg Manchow";
                else if (sd == 3) selectedSoupOrDrink = "Lemon Coriander";
                else if (sd == 4) selectedSoupOrDrink = "Hot & Sour Veg";
                else selectedSoupOrDrink = "Welcome Drink - Fresh Lime";

                // 2) Paneer Dish (choose one)
                System.out.println(BLUE + "\nChoose Paneer Dish (choose one from list):" + RESET);
                System.out.println(YELLOW + "1. Paneer Butter Masala" + RESET);
                System.out.println(YELLOW + "2. Paneer Kadai" + RESET);
                System.out.println(YELLOW + "3. Paneer Punjabi" + RESET);
                System.out.println(YELLOW + "4. Paneer Kolhapuri" + RESET);
                int pch = getIntInRange(sc, CYAN + "Enter choice (1-4): " + RESET, 1, 4);
                if (pch == 1) paneerSelected = "Paneer Butter Masala";
                else if (pch == 2) paneerSelected = "Paneer Kadai";
                else if (pch == 3) paneerSelected = "Paneer Punjabi";
                else paneerSelected = "Paneer Kolhapuri";

                // 3) Vegetable Dishes (thali 1 -> 1 veg, others -> 2 veg)
                if (thaliChoice == 1) {
                    System.out.println(BLUE + "\nChoose Vegetable Dish (1 selection):" + RESET);
                    System.out.println(YELLOW + "1. Nav Ratan Korma" + RESET);
                    System.out.println(YELLOW + "2. Methi Mutter Malai" + RESET);
                    System.out.println(YELLOW + "3. Mix Veg" + RESET);
                    System.out.println(YELLOW + "4. Aloo Mutter" + RESET);
                    int v1 = getIntInRange(sc, CYAN + "Enter choice (1-4): " + RESET, 1, 4);
                    veg1 = (v1 == 1) ? "Nav Ratan Korma" : (v1 == 2) ? "Methi Mutter Malai" : (v1 == 3) ? "Mix Veg" : "Aloo Mutter";
                    veg2 = ""; // not applicable
                } else {
                    System.out.println(BLUE + "\nChoose Vegetable Dish #1:" + RESET);
                    System.out.println(YELLOW + "1. Nav Ratan Korma" + RESET);
                    System.out.println(YELLOW + "2. Methi Mutter Malai" + RESET);
                    System.out.println(YELLOW + "3. Mix Veg" + RESET);
                    System.out.println(YELLOW + "4. Aloo Mutter" + RESET);
                    int v1 = getIntInRange(sc, CYAN + "Enter choice (1-4): " + RESET, 1, 4);
                    veg1 = (v1 == 1) ? "Nav Ratan Korma" : (v1 == 2) ? "Methi Mutter Malai" : (v1 == 3) ? "Mix Veg" : "Aloo Mutter";

                    System.out.println(BLUE + "\nChoose Vegetable Dish #2:" + RESET);
                    System.out.println(YELLOW + "1. Corn Palak" + RESET);
                    System.out.println(YELLOW + "2. Bhindi Masala" + RESET);
                    System.out.println(YELLOW + "3. Gujarati Aloo" + RESET);
                    System.out.println(YELLOW + "4. Dum Aloo" + RESET);
                    int v2 = getIntInRange(sc, CYAN + "Enter choice (1-4): " + RESET, 1, 4);
                    veg2 = (v2 == 1) ? "Corn Palak" : (v2 == 2) ? "Bhindi Masala" : (v2 == 3) ? "Gujarati Aloo" : "Dum Aloo";
                }

                // 4) Dal (if thali includes dal: thali 3,4,5,6)
                if (thaliChoice >= 3) {
                    System.out.println(BLUE + "\nChoose Dal:" + RESET);
                    System.out.println(YELLOW + "1. Dal Fry" + RESET);
                    System.out.println(YELLOW + "2. Dal Tadka" + RESET);
                    System.out.println(YELLOW + "3. Dal Makhani" + RESET);
                    int dch = getIntInRange(sc, CYAN + "Enter choice (1-3): " + RESET, 1, 3);
                    dalSelected = (dch == 1) ? "Dal Fry" : (dch == 2) ? "Dal Tadka" : "Dal Makhani";
                } else {
                    dalSelected = "";
                }

                // 5) Curd (if thali includes curd: thali 5 or 6)
                if (thaliChoice >= 5) {
                    System.out.println(BLUE + "\nChoose Curd Dish:" + RESET);
                    System.out.println(YELLOW + "1. Boondi Raita" + RESET);
                    System.out.println(YELLOW + "2. Aloo Raita" + RESET);
                    System.out.println(YELLOW + "3. Mix Raita" + RESET);
                    int cch = getIntInRange(sc, CYAN + "Enter choice (1-3): " + RESET, 1, 3);
                    curdSelected = (cch == 1) ? "Boondi Raita" : (cch == 2) ? "Aloo Raita" : "Mix Raita";
                } else {
                    curdSelected = "";
                }

                // 6) Rice (if included)
                if (thaliChoice >= 1) {
                    System.out.println(BLUE + "\nChoose Rice:" + RESET);
                    System.out.println(YELLOW + "1. Jeera Rice" + RESET);
                    System.out.println(YELLOW + "2. Veg Pulao" + RESET);
                    System.out.println(YELLOW + "3. Veg Fried Rice" + RESET);
                    System.out.println(YELLOW + "4. Veg Biryani" + RESET);
                    int rch = getIntInRange(sc, CYAN + "Enter choice (1-4): " + RESET, 1, 4);
                    riceSelected = (rch == 1) ? "Jeera Rice" : (rch == 2) ? "Veg Pulao" : (rch == 3) ? "Veg Fried Rice" : "Veg Biryani";
                } else {
                    riceSelected = "";
                }

                // 7) Roti
                System.out.println(BLUE + "\nChoose Roti Type:" + RESET);
                System.out.println(YELLOW + "1. Roti" + RESET);
                System.out.println(YELLOW + "2. Naan" + RESET);
                System.out.println(YELLOW + "3. Missi Roti" + RESET);
                System.out.println(YELLOW + "4. Methi Puri" + RESET);
                int ro = getIntInRange(sc, CYAN + "Enter choice (1-4): " + RESET, 1, 4);
                rotiSelected = (ro == 1) ? "Roti" : (ro == 2) ? "Naan" : (ro == 3) ? "Missi Roti" : "Methi Puri";

                // 8) Starter (if thali 5 or 6)
                if (thaliChoice >= 5) {
                    System.out.println(BLUE + "\nChoose Starter (one):" + RESET);
                    System.out.println(YELLOW + "1. Veg Pakoda" + RESET);
                    System.out.println(YELLOW + "2. Veg Cutlet" + RESET);
                    System.out.println(YELLOW + "3. Paneer Tikka" + RESET);
                    int sCh = getIntInRange(sc, CYAN + "Enter choice (1-3): " + RESET, 1, 3);
                    starterSelected = (sCh == 1) ? "Veg Pakoda" : (sCh == 2) ? "Veg Cutlet" : "Paneer Tikka";
                } else {
                    starterSelected = "";
                }

                // 9) Dessert for thali >=4 (IceCream or Sweet) - included, not extra priced
                if (thaliChoice >= 4) {
                    System.out.println(BLUE + "\nDessert included - choose type:" + RESET);
                    System.out.println(YELLOW + "1. Ice Cream" + RESET);
                    System.out.println(YELLOW + "2. Sweet" + RESET);
                    int des = getIntInRange(sc, CYAN + "Enter choice (1-2): " + RESET, 1, 2);
                    if (des == 1) {
                        dessertType = "Ice Cream";
                        System.out.println(YELLOW + "Ice Cream flavors: 1.Vanilla 2.Chocolate 3.Mango 4.Strawberry" + RESET);
                        int f = getIntInRange(sc, CYAN + "Choose flavor (1-4): " + RESET, 1, 4);
                        dessertChoice = (f == 1) ? "Vanilla" : (f == 2) ? "Chocolate" : (f == 3) ? "Mango" : "Strawberry";
                    } else {
                        dessertType = "Sweet";
                        System.out.println(YELLOW + "Sweets: 1.Gulab Jamun 2.Rasgulla 3.Jalebi 4.Barfi" + RESET);
                        int sf = getIntInRange(sc, CYAN + "Choose sweet (1-4): " + RESET, 1, 4);
                        dessertChoice = (sf == 1) ? "Gulab Jamun" : (sf == 2) ? "Rasgulla" : (sf == 3) ? "Jalebi" : "Barfi";
                    }
                } else {
                    dessertType = "Sweet (included)";
                    dessertChoice = "Sweet (as per menu)";
                }

                // After finishing thali included choices, allow user to add other categories (counts only)
                boolean adding = true;
                while (adding) {
                    System.out.println(CYAN + "\nDo you want to add other category counts? (1-Yes, 0-No)" + RESET);
                    int more = getIntInRange(sc, "Enter 1 or 0: ", 0, 1);
                    if (more == 0) { adding = false; break; }

                    System.out.println(BLUE + "\nAdd Categories (these counts will be recorded but NOT charged separately):" + RESET);
                    System.out.println(YELLOW + "1. Breakfast items (count)" + RESET);
                    System.out.println(YELLOW + "2. Snacks (count)" + RESET);
                    System.out.println(YELLOW + "3. Chinese/Continental items (count)" + RESET);
                    System.out.println(YELLOW + "4. Mocktails (count)" + RESET);
                    System.out.println(YELLOW + "5. Sweets/IceCream (count)" + RESET);
                    int cat = getIntInRange(sc, CYAN + "Enter category (1-5): " + RESET, 1, 5);
                    if (cat == 1) {
                        int c = getPositiveInt(sc, "Enter breakfast count to add: ");
                        breakfastCount += c;
                    } else if (cat == 2) {
                        int c = getPositiveInt(sc, "Enter snacks count to add: ");
                        snacksCount += c;
                    } else if (cat == 3) {
                        int c = getPositiveInt(sc, "Enter chinese/continental count to add: ");
                        chineseCount += c;
                    } else if (cat == 4) {
                        int c = getPositiveInt(sc, "Enter mocktail count to add: ");
                        mocktailCount += c;
                    } else {
                        int c = getPositiveInt(sc, "Enter sweets/icecream count to add: ");
                        sweetsCount += c;
                    }
                }

                // compute subtotal (only thali charged)
                subtotal += thaliQty * thaliPrice;
                System.out.println(GREEN + "\nThali and selections recorded." + RESET);
                // After finishing one thali process, ask if user wants to go back to main menu or exit to bill
                System.out.println(CYAN + "Do you want to go back to MAIN MENU to do another Thali or category? (1=MainMenu / 0=Proceed to Bill): " + RESET);
                int goBack = getIntInRange(sc, "", 0, 1);
                if (goBack == 1) {
                    System.out.println(GREEN + "Returning to main menu..." + RESET);
                    // loop continues to show main menu
                } else {
                    mainChoice = 3; // proceed to bill printing
                }

            } else if (mainChoice == 2) {
                // ---- Breakfast Thali flow (record counts but not charge) ----
                System.out.println(BLUE + "\nBREAKFAST MENU (Choose numbers):" + RESET);
                System.out.println(YELLOW + "1. Poha + Jalebi + Tea/Coffee" + RESET);
                System.out.println(YELLOW + "2. Bread + Heavy Snacks + Tea/Coffee" + RESET);
                System.out.println(YELLOW + "3. Heavy Snacks + Tea/Coffee" + RESET);
                int bch = getIntInRange(sc, "Choose breakfast type (1-3): ", 1, 3);
                int bq = getPositiveInt(sc, "Enter breakfast plates quantity: ");
                breakfastCount += bq;
                System.out.println(GREEN + bq + " breakfast plate(s) recorded (no separate charge)." + RESET);

                System.out.println(CYAN + "Back to main menu? (1=Yes / 0=Proceed to Bill): " + RESET);
                int cont = getIntInRange(sc, "", 0, 1);
                if (cont == 1) { System.out.println(GREEN + "Returning to main menu..." + RESET); }
                else { mainChoice = 3; }
            } else {
                // mainChoice == 3 -> exit & print bill
                break;
            }

            // If not exiting, print main menu again
            if (mainChoice != 3) {
                System.out.println(CYAN + "\nMAIN MENU - Choose next action:" + RESET);
                System.out.println(GREEN + "1. Vegetarian Thali" + RESET);
                System.out.println(GREEN + "2. Breakfast Thali" + RESET);
                System.out.println(GREEN + "3. Exit & Print Bill" + RESET);
            }
        } while (mainChoice != 3);

        // ====== Final calculations & print professional bill ======
        gst = roundTwoDecimals(subtotal * 0.05);
        grandTotal = subtotal + gst;

        // Print bill with white background simulation and alignment
        System.out.println(WHITE_BG + BLACK);
        System.out.println("==============================================================");
        System.out.printf("%-45s%-25s\n", "JMB HOTEL - PARTY TIME (INVOICE)", "Bill No: " + billNo);
        System.out.printf("%-45s%-25s\n", "Customer: " + customerName, "Booking Date: " + bookingDate);
        System.out.printf("%-45s%-25s\n", "Printed On: " + today + " " + timeNow, "Party Size: " + partySize);
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-3s %-35s %6s %10s\n", "No", "Item Description", "Qty", "Amount (Rs)");
        System.out.println("--------------------------------------------------------------");

        int line = 1;
        // Thali charged line
        if (thaliQty > 0) {
            double thaliLine = thaliQty * thaliPrice;
            System.out.printf("%-3d %-35s %6d %10.2f\n", line++, thaliName + " (" + thaliPrice + " per)", thaliQty, thaliLine);
            if (freeThalis > 0) {
                System.out.printf("%-3s %-35s %6d %10s\n", "", "FREE OFFER: Free Thalis", freeThalis, "FREE");
            }
        } else {
            System.out.printf("%-3s %-35s %6s %10s\n", "", "No Thali Ordered", "-", "-");
        }

        // Now show included items (recorded) — qty shows equal to thaliQty (if applicable)
        if (!selectedSoupOrDrink.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + selectedSoupOrDrink, thaliQty, "-");
        }
        if (!paneerSelected.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + paneerSelected, thaliQty, "-");
        }
        if (!veg1.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + veg1, thaliQty, "-");
        }
        if (!veg2.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + veg2, thaliQty, "-");
        }
        if (!dalSelected.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + dalSelected, thaliQty, "-");
        }
        if (!curdSelected.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + curdSelected, thaliQty, "-");
        }
        if (!riceSelected.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + riceSelected, thaliQty, "-");
        }
        if (!rotiSelected.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + rotiSelected, thaliQty, "-");
        }
        if (!starterSelected.equals("")) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + starterSelected, thaliQty, "-");
        }
        if (!dessertType.equals("")) {
            String dline = dessertType;
            if (!dessertChoice.equals("")) dline += " - " + dessertChoice;
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Included: " + dline, thaliQty, "-");
        }

        // Show additional recorded categories (counts only)
        if (breakfastCount > 0) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Recorded: Breakfast plates", breakfastCount, "-");
        }
        if (snacksCount > 0) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Recorded: Snacks", snacksCount, "-");
        }
        if (chineseCount > 0) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Recorded: Chinese/Continental", chineseCount, "-");
        }
        if (mocktailCount > 0) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Recorded: Mocktails", mocktailCount, "-");
        }
        if (sweetsCount > 0) {
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Recorded: Extra Sweets/IceCream", sweetsCount, "-");
        }

        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-40s %10.2f\n", "Subtotal (Thali only):", subtotal);
        System.out.printf("%-40s %10.2f\n", "GST (5%):", gst);
        System.out.printf("%-40s %10.2f\n", "GRAND TOTAL:", grandTotal);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Note: Only Thali price is charged. Other items recorded are included in Thali or recorded for kitchen.");
        System.out.println(GREEN + "Thank you for choosing JMB Hotel! Visit Again." + RESET);
        System.out.println(RESET); // reset colors
        sc.close();
    }

    // ====== Helper Methods (public static, no private methods) ======
    public static int getPositiveInt(Scanner sc, String prompt) {
        int v = -1;
        while (v <= 0) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                v = sc.nextInt();
                sc.nextLine();
                if (v <= 0) {
                    System.out.println(RED + "Enter a positive integer." + RESET);
                }
            } else {
                System.out.println(RED + "Invalid. Enter a number." + RESET);
                sc.nextLine();
            }
        }
        return v;
    }

    public static int getIntInRange(Scanner sc, String prompt, int min, int max) {
        int v = Integer.MIN_VALUE;
        while (v < min || v > max) {
            if (!prompt.isEmpty()) System.out.print(prompt);
            if (sc.hasNextInt()) {
                v = sc.nextInt();
                sc.nextLine();
                if (v < min || v > max) System.out.println(RED + "Enter a number between " + min + " and " + max + "." + RESET);
            } else {
                System.out.println(RED + "Invalid input. Enter a number." + RESET);
                sc.nextLine();
            }
        }
        return v;
    }

    public static double roundTwoDecimals(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    // Small helper to make bold-like headings (we can't truly bold in all consoles)
    public static String BOLDString(String s) {
        return "\u001B[1m" + s + "\u001B[0m";
    }

    public static double roundTwoDecimals(double val, boolean dummy) {
        // wrapper duplication if needed
        return roundTwoDecimals(val);
    }
}
