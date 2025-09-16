import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class jmb22 {

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

        System.out.print(YELLOW + "Enter Customer Name: " + RESET);
        String customerName = sc.nextLine().trim();

        System.out.print(YELLOW + "Enter Mobile Number: " + RESET);
        int mobileNo = sc.nextInt();

        System.out.print(YELLOW + "Enter Booking Date (dd-MM-yyyy): " + RESET);
        int bookingDate = sc.nextInt();

        int partySize = getPositiveInt(sc, YELLOW + "Enter number of people in the party: " + RESET);

        int billNo = rand.nextInt(900000) + 100000;

        String thaliName = "";
        int thaliPrice = 0;
        int thaliQty = 0;
        int freeThalis = 0;

        String soupDrink = "";
        String paneerDish = "";
        String vegDish1 = "";
        String vegDish2 = "";
        String dalDish = "";
        String riceDish = "";
        String rotiDish = "";
        String starterDish = "";
        String dessertType = "";
        String dessertVariant = "";
        String snack = "";
        String breakfastItem = "";
        int breakfastPrice = 0;
        int breakfastQty = 0;
        int freeBreakfastItems = 0;

        String snackItem = "";
        int snackPrice = 0;
     //   int snackQty = 0;
       // int freeSnackItems = 0;

        double subtotal = 0.0;
        boolean thaliOrdered = false;
        boolean breakfastOrdered = false;
        boolean snacksOrdered = false;

        boolean ordering = true;

        while (ordering) {
            System.out.println(CYAN + "\nMAIN MENU - Choose:" + RESET);
            System.out.println(GREEN + "1. Vegetarian Thali" + RESET);
            System.out.println(GREEN + "2. Breakfast & Snacks" + RESET);
            System.out.println(GREEN + "3. Exit & Print Bill" + RESET);

            int mainChoice = getIntInRange(sc, CYAN + "Enter main choice (1-3): " + RESET, 1, 3);

            if (mainChoice == 1) {
                thaliOrdered = true;
                System.out.println(BLUE + "\nVEGETARIAN THALI MENU:" + RESET);
                System.out.println(YELLOW + "1. Thali 1 - Rs.310" + RESET);
                System.out.println(YELLOW + "2. Thali 2 - Rs.360" + RESET);
                System.out.println(YELLOW + "3. Thali 3 - Rs.410" + RESET);
                System.out.println(YELLOW + "4. Thali 4 - Rs.470" + RESET);
                System.out.println(YELLOW + "5. Thali 5 - Rs.600" + RESET);
                System.out.println(YELLOW + "6. Thali 6 - Rs.700" + RESET);

                int thaliChoice = getIntInRange(sc, "Select Thali number (1-6): ", 1, 6);

                switch (thaliChoice) {
                    case 1: 
                        thaliName = "Thali 1"; 
                        thaliPrice = 310; 
                        System.out.println(CYAN + "Thali 1 includes:\n -1 Soup/Drink\n- 1 Paneer Dish\n -1 Veg Dish\n- 1 Dal\n- 1 Roti\n- 1 Rice \n1- Sweet Dish." + RESET);
                        break;
                    case 2: 
                        thaliName = "Thali 2"; 
                        thaliPrice = 360; 
                        System.out.println(CYAN + "Thali 2 includes:\n- 1 Soup/Drink\n- 1 Paneer Dish\n- 2 Veg Dishes\n -1 Dal\n-  Roti\n -1 Rice\n- 1 Sweet Dish." + RESET);
                        break;
                    case 3: 
                        thaliName = "Thali 3"; 
                        thaliPrice = 410; 
                        System.out.println(CYAN + "Thali 3 includes:\n- 1 Soup/Drink\n- 1 Starter\n- 1 Paneer Dish \n- 2 Veg Dishes\n- 1 Dal  \n -1 Roti- 1 Rice\n- 1 Sweet Dish." + RESET);
                        break;
                    case 4: 
                        thaliName = "Thali 4"; 
                        thaliPrice = 470; 
                        System.out.println(CYAN + "Thali 4 includes:\n- 1 Soup/Drink\n- 1 Starter\n- 1 Paneer Dish \n-2 Veg Dishes \n- 1 Dal \n- 1 Roti\n- 1 Rice \n- 1 Sweet Dish\n -1 Dessert." + RESET);
                        break;
                    case 5: 
                        thaliName = "Thali 5"; 
                        thaliPrice = 600; 
                        System.out.println(CYAN + "Thali 5 includes:\n- 1 Welcome Drink \n- 1 Starter \n-1 Paneer Dish \n- 2 Veg Dishes \n- 1 Dal \n- 1 Roti \n- 1 Rice \n- 1 Sweet Dish \n- 1 Dessert." + RESET);
                        break;
                    case 6: 
                        thaliName = "Thali 6"; 
                        thaliPrice = 700; 
                        System.out.println(CYAN + "Thali 6 includes: \n- 1 Welcome Drink \n- 2 Starters \n- 1 Paneer Dish \n- 2 Veg Dishes  \n-1 Dal  \n-1 Roti \n- 1 Rice \n- 1 Sweet Dish \n- 1 Dessert." + RESET);
                        break;
                }

                System.out.println(GREEN + "\nYou have selected: " + thaliName + " (Rs." + thaliPrice + ")" + RESET);
                System.out.print(YELLOW + "Is this thali right for you? (yes/no): " + RESET);
                String confirmation = sc.next().trim().toLowerCase();
                sc.nextLine(); // Consume newline

                if (!confirmation.equals("yes")) {
                    System.out.println(RED + "Selection cancelled. Returning to main menu." + RESET);
                    thaliOrdered = false;
                    continue; // Skip to the next loop iteration
                }
                
                thaliQty = getPositiveInt(sc, "Enter number of thalis: ");
                
                if (thaliQty < 25) {
                    freeThalis = 2;
                    System.out.println(GREEN + "Offer applied: 2 free thalis added." + RESET);
                }
                if (thaliQty > 100) {
                    freeThalis = 5;
                    System.out.println(GREEN + "Offer applied: 5 free thalis added." + RESET);
                }

                soupDrink = chooseSoupDrink(sc);
                paneerDish = choosePaneer(sc);
                vegDish1 = chooseVeg(sc, 1);
                vegDish2 = chooseVeg(sc, 2);
                dalDish = chooseDal(sc);
                starterDish = chooseStarter(sc);
                rotiDish = chooseRoti(sc);
                riceDish = chooseRice(sc);
                String[] dessert = chooseDessert(sc);
                dessertType = dessert[0];
                dessertVariant = dessert[1];
                snack = choosesnack(sc, 1);
                subtotal += thaliPrice * thaliQty;

            } else if (mainChoice == 2) {
                breakfastOrdered = true;
               // snacksOrdered = true;
                
                System.out.println(BLUE + "\nBREAKFAST MENU:" + RESET);
                System.out.println(YELLOW + "Breakfast 1 (Rs .200)" + RESET);
                System.out.println(YELLOW + "Breakfast 2 (Rs. 250)" + RESET);
                System.out.println(YELLOW + "Breakfast 3 (Rs. 320)" + RESET);

                int bch = getIntInRange(sc, "Choose breakfast type (1-3): ", 1, 3);
                switch (bch) {  //bch = breakfast choose 
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
                System.out.println(GREEN + "\nYou have selected: " + breakfastItem + " (Rs." + breakfastPrice + ")" + RESET);
                String confirmation = sc.next().trim().toLowerCase();
                sc.nextLine();
                if (!confirmation.equals("yes")) {
                    System.out.println(RED + "Selection cancelled. Returning to main menu." + RESET);
                    breakfastOrdered = false;    
                    continue; // Skip to the next loop iteration 
                }
                
                System.out.print(YELLOW + "Is this breakfast combo right for you? (yes/no): " + RESET);
                breakfastQty = getPositiveInt(sc, "Enter breakfast plates quantity: ");
                
                if (breakfastQty < 25) {
                    freeBreakfastItems = 2;
                    System.out.println(GREEN + "Offer applied: 2 free items added." + RESET);
                }

                subtotal += breakfastPrice * breakfastQty;
/* 
                System.out.println(BLUE + "\nSNACKS MENU:" + RESET);
                System.out.println(YELLOW + "1. Samosa (Rs. 30)" + RESET);
                System.out.println(YELLOW + "2. Fries (Rs. 120)" + RESET);
                System.out.println(YELLOW + "3. Kachori (Rs. 40)" + RESET);
                System.out.println(YELLOW + "4. Khaman (Rs. 100)" + RESET);

                int sch = getIntInRange(sc, "Choose snack type (1-4): ", 1, 4);
                switch (sch) {
                    case 1: 
                    snackItem = "Samosa"; snackPrice = 30; 
                    break;
                    case 2: 
                    snackItem = "Fries"; snackPrice = 120;
                    break;
                    case 3: 
                    snackItem = "Kachori"; snackPrice = 40; 
                    break;
                    case 4:
                         snackItem = "Khaman"; snackPrice = 100; break;
                }
                snackQty = getPositiveInt(sc, "Enter snack quantity: ");

                if (snackQty < 25) {
                    freeSnackItems = 2;
                    System.out.println(GREEN + "Offer applied: 2 free items added." + RESET);
                }
                subtotal += snackPrice * snackQty;

            } else {
                ordering = false;
            }*/
        }

        // --- Bill Generation with updated logic ---p
        double gstRate = 0;
        if (thaliOrdered) {
            gstRate = 0.18; 
        } else if (breakfastOrdered) {
            gstRate = 0.05; 
        }
        double gst = subtotal * gstRate;
        
        double discount = 0;
        double totalAfterGST = subtotal + gst;

        if (totalAfterGST > 5000) {
            discount = totalAfterGST * 0.10;
        }

        double grandTotal = totalAfterGST - discount;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String orderDateTime = sdf.format(new Date());

        System.out.println(WHITE_BG + BLACK);
        System.out.println("+------------------------------------------------------------+");
        System.out.printf("| %-55s%-12s |\n", "JMB HOTEL ,INDORE -- INVOICE", "");
        System.out.println("|------------------------------------------------------------|");
        System.out.printf("| Hotel: Jmb HOTEL%45s|\n", "");
        System.out.printf("| Bill No: %-52d|\n", billNo);
        System.out.printf("| Customer: %-48s|\n", customerName);
        System.out.printf("| Party Size: %-47d|\n", partySize);
        System.out.printf("| Booking Date: %-46s|\n", bookingDate);
        System.out.printf("| Order Creation Date/Time: %-36s|\n", orderDateTime);
        System.out.println("|------------------------------------------------------------|");

        System.out.printf("| %-60s|\n", "--- ITEMS ---");
        System.out.printf("| %-38s %-5s %-5s %-10s|\n", "Item", "Rate", "Qty", "Amount");
        System.out.println("|------------------------------------------------------------|");

        if (thaliOrdered) {
            System.out.printf("| %-38s %-5d %-5d %-10.2f|\n", thaliName, thaliPrice, thaliQty, (double)thaliPrice * thaliQty);
            if (freeThalis > 0) System.out.printf("| %-38s %-5s %-5d %-10s|\n", "FREE Thalis", "-", freeThalis, "FREE");
            
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Soup/Drink: " + soupDrink, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Paneer: " + paneerDish, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Veg Dish 1: " + vegDish1, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Veg Dish 2: " + vegDish2, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Dal: " + dalDish, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Starter: " + starterDish, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Roti: " + rotiDish, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Rice: " + riceDish, "", "", "");
            System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Dessert: " + dessertType + " - " + dessertVariant, "", "", "");
        }
        if (breakfastOrdered) {
            System.out.printf("| %-38s %-5d %-5d %-10.2f|\n", breakfastItem, breakfastPrice, breakfastQty, (double)breakfastPrice * breakfastQty);
            if (freeBreakfastItems > 0) System.out.printf("| %-38s %-5s %-5d %-10s|\n", "FREE Breakfast Items", "-", freeBreakfastItems, "FREE");
         System.out.printf("| %-38s %-5s %-5s %-10s|\n", "  - Heavy Snack: " + snack, "", "", "");
        
        }
      /*  if (snacksOrdered) {
            System.out.printf("| %-38s %-5d %-5d %-10.2f|\n", snackItem, snackPrice, snackQty, (double)snackPrice * snackQty);
            if (freeSnackItems > 0) System.out.printf("| %-38s %-5s %-5d %-10s|\n", "FREE Snack Items", "-", freeSnackItems, "FREE");
        }*/
        
        System.out.println("|------------------------------------------------------------|");//r
        System.out.printf("| %-48s %10.2f|\n", "Total (Before GST)", subtotal);
        System.out.printf("| %-48s %10.2f|\n", "GST (" + (int)(gstRate*100) + "%)", gst);
        
        if (discount > 0) {
            System.out.printf("| %-48s %10.2f|\n", "DISCOUNT (10%)", -discount);
        }

        System.out.printf("| %-48s %10.2f|\n", "GRAND TOTAL", grandTotal);
        System.out.println("|------------------------------------------------------------|");
        
        if (thaliQty < 25 && thaliQty > 0) {
             System.out.printf("| %-60s|\n", "Note: You got 2 free items because your quantity is less than 25");
        }
        if ((breakfastQty < 25 && breakfastQty > 0) || (snackQty < 25 && snackQty > 0)) {
            System.out.printf("| %-60s|\n", "Note: You got 2 free items because your quantity is less than 25");
        }
        if (discount > 0) {
            System.out.printf("| %-60s|\n", "Note: You got 10% off because your bill is more than 5000");
        }
        System.out.printf("| %-60s|\n", "Thank you for choosing Party Time!");
        System.out.println("+------------------------------------------------------------+" + RESET);

        sc.close();
    }

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
    
    // --- Thali Sub-menu Methods ---
    
    public static String chooseSoupDrink(Scanner sc) {
        System.out.println(BLUE + "Choose Soup/Drink:" + RESET);
        System.out.println(YELLOW + "1. Tomato Soup 2. Veg Manchow 3. Lemon Coriander 4. Hot & Sour Veg 5. Fresh Lime 6. Watermelon Juice 7. Mango Lassi 8. Strawberry Shake 9. Cold Coffee" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-9): ", 1, 9);
        switch (ch) {
            case 1: return "Tomato Soup";
            case 2: return "Veg Manchow";
            case 3: return "Lemon Coriander";
            case 4: return "Hot & Sour Veg";
            case 5: return "Fresh Lime";
            case 6: return "Watermelon Juice";
            case 7: return "Mango Lassi";
            case 8: return "Strawberry Shake";
            default: return "Cold Coffee";
        }
    }

    public static String choosePaneer(Scanner sc) {
        System.out.println(BLUE + "Choose Paneer Dish:" + RESET);
        System.out.println(YELLOW + "1. Butter Masala 2. Kadai 3. Punjabi 4. Kolhapuri" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1: return "Butter Masala";
            case 2: return "Kadai";
            case 3: return "Punjabi";
            default: return "Kolhapuri";
        }
    }

    public static String chooseVeg(Scanner sc, int num) {
        System.out.println(BLUE + "Choose Veg Dish #" + num + ":" + RESET);
        System.out.println(YELLOW + "1. Nav Ratan 2. Methi Mutter 3. Mix Veg 4. Aloo Mutter 5. Corn Palak 6. Bhindi Masala 7. Gujarati Aloo 8. Dum Aloo" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-8): ", 1, 8);
        switch (ch) {
            case 1: return "Nav Ratan";
            case 2: return "Methi Mutter";
            case 3: return "Mix Veg";
            case 4: return "Aloo Mutter";
            case 5: return "Corn Palak";
            case 6: return "Bhindi Masala";
            case 7: return "Gujarati Aloo";
            default: return "Dum Aloo";
        }
    }

    public static String chooseDal(Scanner sc) {
        System.out.println(BLUE + "Choose Dal:" + RESET);
        System.out.println(YELLOW + "1. Dal Fry 2. Dal Tadka 3. Dal Makhani" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        switch (ch) {
            case 1: return "Dal Fry";
            case 2: return "Dal Tadka";
            default: return "Dal Makhani";
        }
    }


    public static String chooseStarter(Scanner sc) {
        System.out.println(BLUE + "Choose Starter:" + RESET);
        System.out.println(YELLOW + "1. Veg Manchurian 2. Spring Roll 3. Paneer Tikka 4. Corn Balls" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1: return "Veg Manchurian";
            case 2: return "Spring Roll";
            case 3: return "Paneer Tikka";
            default: return "Corn Balls";
        }
    }

    public static String chooseRoti(Scanner sc) {
        System.out.println(BLUE + "Choose Roti:" + RESET);
        System.out.println(YELLOW + "1. Tandoori 2. Butter 3. Missi 4. Laccha" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1: return "Tandoori";
            case 2: return "Butter";
            case 3: return "Missi";
            default: return "Laccha";
        }
    }

    public static String chooseRice(Scanner sc) {
        System.out.println(BLUE + "Choose Rice:" + RESET);
        System.out.println(YELLOW + "1. Steamed 2. Jeera 3. Veg Pulao" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        switch (ch) {
            case 1: return "Steamed";
            case 2: return "Jeera";
            default: return "Veg Pulao";
        }
    }
      public static String choosesnack(Scanner sc , int num) {
        System.out.println(BLUE + "Choose snack:" + RESET);
        System.out.println(YELLOW + "1. samosa \n 2.Kachori \n  3. khaman \n 4. Pav Bhaji" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1: return "Samsosa";
            case 2: return "Kachori";
            case 3: return "khaman";
            default: return "Pavbhaji";
        }
    }

    public static String[] chooseDessert(Scanner sc) {
        System.out.println(BLUE + "Choose Dessert:" + RESET);
        System.out.println(YELLOW + "1. Ice Cream  2. Coffee  3. Sweet Dish" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        String type = "";
        String variant = "";

        switch (ch) {
            case 1:
                type = "Ice Cream";
                System.out.println(YELLOW + "Select Flavor: 1. Vanilla 2. Chocolate 3. Strawberry" + RESET);
                int f1 = getIntInRange(sc, "Enter flavor choice (1-3): ", 1, 3);
                switch (f1) {
                    case 1:
                         variant = "Vanilla";
                          break;
                    case 2:
                         variant = "Chocolate";
                          break;
                    default:
                         variant = "Strawberry";
                }
                break;
            case 2:
                type = "Coffee";
                System.out.println(YELLOW + "Select Type: 1. Cappuccino 2. Latte 3. Espresso" + RESET);
                int f2 = getIntInRange(sc, "Enter coffee type (1-3): ", 1, 3);
                switch (f2) {
                    case 1:
                         variant = "Cappuccino"; 
                         break;
                    case 2:
                         variant = "Latte";
                          break;
                    default: variant = "Espresso";
                }
                break;
            case 3:
                type = "Sweet Dish";
                System.out.println(YELLOW + "Select Sweet: 1. Gulab Jamun 2. Rasgulla 3. Kheer" + RESET);
                int f3 = getIntInRange(sc, "Enter sweet choice (1-3): ", 1, 3);
                switch (f3) {
                    case 1:
                         variant = "Gulab Jamun";
                          break;
                    case 2: variant = "Rasgulla"; 
                    break;
                    default: variant = "Kheer";
                }
                break;

        }

        return new String[]{type, variant};
    }
}