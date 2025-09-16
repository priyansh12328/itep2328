import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class jmb23282 {

    //  color codes
    public static final String WHITE = "\u001B[38;2;255;255;255m";
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE_BG = "\u001B[47m";
     public static final String MAROON_BG ="\u001B[48;2;122;28;28m"; //Dark brown 
      public static final String PITCH_BG = "\u001B[48;2;251;231;221m";//Peach brown 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(PURPLE + "==========================================" + RESET);
        System.out.println(PURPLE + "         WELCOME TO JMB HOTEL (JMB)       " + RESET);
        System.out.println(PURPLE + "==========================================" + RESET);

        //  Customer name (only alphabets + spaces)
        String customerName = "";
        while (true) {
            System.out.print(YELLOW + "Enter Customer Name: " + RESET);
            customerName = sc.nextLine().trim();
            if (customerName.matches("[a-zA-Z ]+")) break;
            else System.out.println(RED + "Invalid name! Only alphabets allowed." + RESET);
        }

        //  Mobile number (10 digits only)
        String mobileNo = "";
        while (true) {
            System.out.print(YELLOW + "Enter Mobile Number: " + RESET);
            mobileNo = sc.nextLine().trim();
            if (mobileNo.matches("\\d{10}")) break;
            else System.out.println(RED + "Invalid mobile number! Enter 10 digits only." + RESET);
        }

        //  Booking date (dd-MM-yyyy)
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

        //  Party size
        int partySize = getPositiveInt(sc, YELLOW + "Enter number of people in the party: " + RESET);

        int billNo = rand.nextInt(900000) + 100000;

        //  Variables for orders 
        String thaliName = "";
        int thaliPrice = 0, thaliQty = 0, freeThalis = 0;

        String soupDrink = "";
        String paneerDish = "";
        String vegDish1 = "";
        String vegDish2 = "";
        String dalDish = "";
        String riceDish = "";
        String rotiDish = "";
        String starterDish = "";
        String curdDish = "";
        String dessertType = "";
        String dessertVariant = "";
        String snack = "";
        String pastadish = "";
        String Chinese = "";
        String paneerStarter= "";
        String coffeechai = "";

        String breakfastItem = "";
        int breakfastPrice = 0, breakfastQty = 0, freeBreakfastItems = 0;

        double subtotal = 0.0;
        boolean thaliOrdered = false, breakfastOrdered = false;
       
       
     //    int kittybreakfastPrice = 0, kittybreakfastQty = 0, kittyfreeBreakfastItems = 0;
      //   boolean  kittyordered = false ;
         boolean ordering = true;
        // ----- Main menu loop -----
        while (ordering) {
            System.out.println(MAROON_BG + WHITE + "\nMAIN MENU - Choose:" + RESET);
            System.out.println(PITCH_BG + BLACK + "1. Vegetarian Thali" + RESET);
            System.out.println(PITCH_BG + BLACK  + "2. Breakfast" + RESET);
             System.out.println(PITCH_BG + BLACK  + "3. Kitty Party (Only for Ladies)" + RESET);
            System.out.println(PITCH_BG + BLACK  + "4. Exit & Print Bill" + RESET);

            int mainChoice = getIntInRange(sc, CYAN + "Enter main choice (1-4): " + RESET, 1, 4);

            if (mainChoice == 1) { // Thali
                thaliOrdered = true;
                System.out.println(WHITE + MAROON_BG + "\nVEGETARIAN THALI MENU:" + RESET);
                System.out.println(BLACK + PITCH_BG + "1. Thali 1 - Rs.310");
                System.out.println(BLACK + PITCH_BG + "2. Thali 2 - Rs.360");
                System.out.println(BLACK + PITCH_BG + "3. Thali 3 - Rs.410");
                System.out.println(BLACK + PITCH_BG + "4. Thali 4 - Rs.470");
                System.out.println(BLACK + PITCH_BG + "5. Thali 5 - Rs.600");
                System.out.println(BLACK + PITCH_BG + "6. Thali 6 - Rs.700" + RESET);

                int thaliChoice = getIntInRange(sc, "Select Thali number (1-6): ", 1, 6);
                switch (thaliChoice) {
                        case 1:
                            thaliName = "Thali 1"; 
                            thaliPrice = 310;
                            break;
                        case 2:
                            thaliName = "Thali 2"; 
                            thaliPrice = 360;
                            break;
                        case 3:
                            thaliName = "Thali 3";
                            thaliPrice = 410;
                            break;
                        case 4: 
                            thaliName = "Thali 4"; 
                            thaliPrice = 470;
                        break;
                        case 5:
                            thaliName = "Thali 5";
                            thaliPrice = 600; 
                            break;
                        case 6:
                            thaliName = "Thali 6";
                            thaliPrice = 700;
                            break;
                    }

                // Show items of Thali before confirmation
                showThaliItems(thaliName);

                System.out.print(YELLOW + PITCH_BG + "Do you want to confirm this Thali? (1 = Yes, 0 = No): " + RESET);
                int confirm = getIntInRange(sc, "", 0, 1);
                if (confirm == 0) {
                    System.out.println(RED + "Selection cancelled. Returning to menu." + RESET);
                    thaliOrdered = false;
                    continue;
                }

               // thaliQty = getPositiveInt(sc, "Enter number of thalis: ");
              //  if (thaliQty < 25) { freeThalis = 2; }
             //   if (thaliQty > 100) { freeThalis = 5; }

 thaliQty = getPositiveInt(sc, "Enter number of thalis: ");
 freeThalis = 0;
double discount = 0.0;

if (thaliQty > 25) {
    freeThalis = 2;
} else if (thaliQty ==100) {
    freeThalis = 3;
} else if (thaliQty> 100) {
    freeThalis = 2;              // 2 thali free
    discount = 0.10;             // 10% discount
}
 int paidThaliQty = thaliQty - freeThalis;
                if (paidThaliQty < 0) paidThaliQty = 0;

double totalAmount = paidThaliQty * thaliPrice;

// Apply discount if any
if (discount > 0) {
    totalAmount = totalAmount - (totalAmount * discount);
}
/*
// अब final bill print karna hai
System.out.println("Thalis Ordered: " + thaliQty);
System.out.println("Free Thalis: " + freeThalis);
if (discount > 0) {
    System.out.println("Discount Applied: " + (discount * 100) + "%");
}

System.out.println("Final Amount: Rs. " + totalAmount);

*/

                // Final Paid Qty
               

                soupDrink = chooseSoupDrink(sc);
                paneerDish = choosePaneer(sc);
                vegDish1 = chooseVeg(sc, 1);
                vegDish2 = chooseVeg(sc, 2);
                dalDish = chooseDal(sc);
                rotiDish = chooseRoti(sc);
                riceDish = chooseRice(sc);
                String[] dessert = chooseDessert(sc);
                dessertType = dessert[0]; dessertVariant = dessert[1];

                //  Starter & Curd only for Thali 5 and 6
                if (thaliChoice == 5 || thaliChoice == 6) {
                    starterDish = chooseStarter(sc);
                    curdDish = chooseCurd(sc);
                    paneerStarter = choosepaneerstarter(sc);
                }
                if(thaliChoice ==5 ){
                    pastadish = choosepasta(sc);
                }
                if(thaliChoice == 6){
                    Chinese =  chooseChinese(sc);
                      soupDrink = chooseSoupDrink(sc);

                }

                subtotal += thaliPrice * paidThaliQty;

            } else if (mainChoice == 2) {        // Breakfast
                breakfastOrdered = true;
                System.out.println(MAROON_BG + WHITE + "\nBREAKFAST MENU:" + RESET);
                System.out.println(PITCH_BG + BLACK + "1. Poha + Jalebi + Tea/Coffee - Rs.200");
                System.out.println(PITCH_BG+ BLACK +  "2. Bread + Heavy Snacks + Tea/Coffee - Rs.250");
                System.out.println(PITCH_BG + BLACK + "3. Heavy Snacks + Tea/Coffee - Rs.320" + RESET);

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
                /*
 showThaliItems(thaliName);

                System.out.print(YELLOW + PITCH_BG + "Do you want to confirm this Thali? (1 = Yes, 0 = No): " + RESET);
                int confirm = getIntInRange(sc, "", 0, 1);
                if (confirm == 0) {
                    System.out.println(RED + "Selection cancelled. Returning to menu." + RESET);
                    thaliOrdered = false;
                    continue;
                }
                showBreakfastitems(breakfastItem);
                 System.out.print(YELLOW + PITCH_BG + "Do you want to confirm this Breakfast? (1 = Yes, 0 = No): " + RESET);
                  int confirm = getIntInRange(sc, "", 0, 1);
                  if (confirm == 0) {
                    System.out.println(RED + "Selection cancelled. Returning to menu." + RESET);
                     breakfastOrdered = false;
                    continue;
                }

                */
      /*         showBreakfastitems(breakfastItem);
                 System.out.print(YELLOW + PITCH_BG + "Do you want to confirm this Breakfast? (1 = Yes, 0 = No): " + RESET);
                  int confirm = getIntInRange(sc, "", 0, 1);
                  if (confirm == 0) {
                    System.out.println(RED + "Selection cancelled. Returning to menu." + RESET);
                     breakfastOrdered = false;
                    continue;
                }
*/
                System.out.print(YELLOW + "Confirm selection (yes/no): " + RESET);
                if (!sc.next().trim().equalsIgnoreCase("yes")) {
                    System.out.println(RED + "Selection cancelled. Returning to menu." + RESET);
                    sc.nextLine();
                    breakfastOrdered = false;
                    continue;
                }
                sc.nextLine();

                breakfastQty = getPositiveInt(sc, "Enter breakfast plates quantity: ");
               // if (breakfastQty < 25) { freeBreakfastItems = 2; }

                // Final Paid Qty
                int paidBreakfastQty = breakfastQty - freeBreakfastItems;
                if (paidBreakfastQty < 0) paidBreakfastQty = 0;

                //  Compulsory snack selection for Breakfast 2 & 3
                if (bch == 2 || bch == 3) {
                    snack = choosesnack(sc, 1);
                }


                subtotal += breakfastPrice * paidBreakfastQty;

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

       // System.out.println(WHITE_BG + BLACK);
        System.out.println( WHITE+"+------------------------------------------------------------+");
        System.out.printf(PITCH_BG+"| %-55s%-12s |\n", "JMB HOTEL ,INDORE -- INVOICE", "");
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
            if (!thaliName.isEmpty())
                System.out.printf("| %-38s %-5d %-5d %-10.2f|\n", thaliName, thaliPrice, thaliQty - freeThalis, (double) thaliPrice * (thaliQty - freeThalis));
            if (freeThalis > 0)
                System.out.printf("| %-38s %-5s %-5d %-10s|\n", "FREE Thalis", "-", freeThalis, "FREE");

            if (!soupDrink.isEmpty()) System.out.printf("|  Soup/Drink: %-49s|\n", soupDrink);
            if (!paneerDish.isEmpty()) System.out.printf("|  Paneer: %-53s|\n", paneerDish);
            if (!vegDish1.isEmpty()) System.out.printf("|  Veg Dish 1: %-49s|\n", vegDish1);
            if (!vegDish2.isEmpty()) System.out.printf("|  Veg Dish 2: %-49s|\n", vegDish2);
            if (!dalDish.isEmpty()) System.out.printf("|  Dal: %-56s|\n", dalDish);
            if (!starterDish.isEmpty()) System.out.printf("|  Starter: %-52s|\n", starterDish);
            if (!curdDish.isEmpty()) System.out.printf("|  Curd: %-55s|\n", curdDish);
            if (!rotiDish.isEmpty()) System.out.printf("|  Roti: %-55s|\n", rotiDish);
            if (!riceDish.isEmpty()) System.out.printf("|  Rice: %-55s|\n", riceDish);
            if (!dessertType.isEmpty()) System.out.printf("|  Dessert: %-52s|\n", dessertType + " - " + dessertVariant);
             if (!Chinese.isEmpty()) System.out.printf("|  Chinese: %-55s|\n", Chinese);
      
      
        }

        if (breakfastOrdered) {
            if (!breakfastItem.isEmpty())
                System.out.printf("| %-38s %-5d %-5d %-10.2f|\n", breakfastItem, breakfastPrice, breakfastQty - freeBreakfastItems, (double) breakfastPrice * (breakfastQty - freeBreakfastItems));
            if (freeBreakfastItems > 0)
                System.out.printf("| %-38s %-5s %-5d %-10s|\n", "FREE Breakfast Items", "-", freeBreakfastItems, "FREE");

            if (!snack.isEmpty()) System.out.printf("|  Snack: %-54s|\n", snack);
        }

        System.out.println("|------------------------------------------------------------|");
        System.out.printf("| %-48s %10.2f|\n", "Total (Before GST)", subtotal);
        System.out.printf("| %-48s %10.2f|\n", "GST (" + (int)(gstRate*100) + "%)", gst);
        if (discount > 0) System.out.printf("| %-48s %10.2f|\n", "DISCOUNT (10%)", -discount);
        System.out.printf("| %-48s %10.2f|\n", "GRAND TOTAL", grandTotal);
        System.out.println("|------------------------------------------------------------|");
        System.out.printf(MAROON_BG +"| %-60s|\n", "Thank you for choosing JMB Hotel!");
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
            if (!prompt.isEmpty()) System.out.print(prompt);
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
    public static void showThaliItems(String thaliName) {
        System.out.println(GREEN + WHITE_BG+"\nItems included in " + thaliName + ":" + RESET);
        System.out.println(MAROON_BG+"- Soup/Drink");
        System.out.println(MAROON_BG+"- Paneer Dish");
        System.out.println(MAROON_BG+"- Two Veg Dishes");
        System.out.println(MAROON_BG+"- Dal");
        if (thaliName.equals("Thali 5") || thaliName.equals("Thali 6")) {
            System.out.println(MAROON_BG+"- Starter");
            System.out.println(MAROON_BG+"- Curd Dish");
        }
         if (thaliName.equals("Thali 5") ) {
            System.out.println(MAROON_BG+"- Pasta");
        }
        if (thaliName.equals("Thali 6") )
         {
            System.out.println(MAROON_BG+"- Paneer Starter");
        }
        
        
        System.out.println(MAROON_BG+"- Roti");
        System.out.println(MAROON_BG+"- Rice");
        System.out.println(MAROON_BG+"- Dessert");
    }

    public static String chooseSoupDrink(Scanner sc) {
        System.out.println(MAROON_BG + WHITE + "Choose Soup/Drink:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1. Tomato Soup\n 2. Veg Manchow \n 3. Lemon Coriander \n4. Hot & Sour Veg\n 5. Fresh Lime\n 6. Watermelon Juice\n 7. Mango Lassi\n 8. Strawberry Shake\n 9. Cold Coffee" + RESET);
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
        System.out.println(MAROON_BG + WHITE + "Choose Paneer Dish:" + RESET);
        System.out.println(BLACK + PITCH_BG + "1. Paneer Butter Masala \n 2. Paneer Punjabi \n 3. Paneer Palak \n 4. Paneer Mutter \n 5. Paneer Do Pyaza \n 6. Paneer Tikka Masala  \n 7. Panner Kadai Masala \n 8. Methi Paneer \n 9. Corn Paneer \n 10 Paneer Kolhapoori \n 11. Paneer Chatpata " + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-11): ", 1, 11);
        switch (ch) {
                        case 1:
                        return " Paneer Butter Masala";
                        case 2: 
                        return "Paneer Punjabi ";
                        case 3:
                        return "Paneer Palak ";
                         case 4:
                        return "Paneer Mutter  ";
                         case 5:
                        return "Paneer Do Pyaza";
                         case 6:
                        return "Paneer Tikka Masala ";
                         case 7:
                        return "Paneer Kadai  ";
                         case 8:
                        return "Methi Paneer";
                         case 9:
                        return "Corn Paneer ";
                         case 10:
                        return "Paneer Kolhapuri  ";
                         case 11:
                        return "Paneer Chatapata";
                        
                default:
                        return "Kolhapuri";
            }
    }

    public static String chooseVeg(Scanner sc, int num) {
        System.out.println( MAROON_BG + WHITE + "Choose Veg Dish " + num + ":" + RESET);
        System.out.println(PITCH_BG + BLACK + "1. Nav Ratan\n 2. Methi Mutter\n  3. Mix Veg \n 4. Aloo Mutter \n 5. Corn Palak\n 6. Bhindi Masala\n  7. Gujarati Aloo\n 8. Dum Aloo\n 9.veg kohlapuri \n 10. Green chana \n  11. Lahori aaloo \n 12. Aloo Capsicum \n 13. Aloo Da Pyaza \n 14. Aloo Gobhi \n 15. Gobhoi Mutter\n 16. Kadi Punjabi \n 17. Veg Kofta \n 18. Chana Masala \n 19 . Bhindi Masala \n 20. Jeera Aloo \n 21. Tinda Masala \n22. Aaloo Palak \n 23. Seasonal veg \n 24. Corn Capcicum \n 25. Aaloo 65  " + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-25): ", 1, 25);
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
         case 8: 
            return "Dum Aloo ";
             case 9: 
            return "veg kohlpoori ";
             case 10: 
            return "Green Chana";
             case 11: 
            return "Lahori Aaloo ";
             case 12: 
            return "Aaloo Capcicum ";
             case 13: 
            return "aaloo Da pyaaza ";
             case 14: 
            return "Aloo Gobhi ";
             case 15: 
            return "Gobhi mutter ";
             case 16: 
            return "Kadi Punjabi ";
             case 17: 
            return "Veg Kofta";
             case 18: 
            return "Chana Masala ";
             case 19: 
            return "Green Chana Seasonal ";
              case 20:
                 return "Jeera AAloo ";
                   case 21:
                 return "Tinda Masala";
                   case 22:
                 return "Aaloo Palak ";
                   case 23:
                 return "Seasonal Veg ";
                   case 24:
                 return "Corn capcicum ";
                   case 25:
                 return "Aloo 65";


            default:
                 return "Dum Aloo";
        }
    }

    public static String chooseDal(Scanner sc) {
        System.out.println(MAROON_BG + WHITE + "Choose Dal:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1. Tadka Dal\n2. Dal Makhani\n3. Panchmel Dal\n4. Moong Dal" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);
        switch (ch) {
            case 1:
                return "Tadka Dal";
            case 2:
                 return "Dal Makhani";
            case 3:
                 return "Panchmel Dal";
            default:
                 return "Moong Dal";
        }
    }

    public static String chooseRoti(Scanner sc) {
        System.out.println(WHITE + MAROON_BG + "Choose Roti:" + RESET);
        System.out.println( BLACK + PITCH_BG + "1. Roti " + RESET);
        System.out.println( BLACK + PITCH_BG + "2. Paratha " + RESET);
        System.out.println( BLACK + PITCH_BG + "3. Kulcha " + RESET);
        System.out.println( BLACK + PITCH_BG + "4. Naan " + RESET);
        System.out.println( BLACK + PITCH_BG + "5. Missi Roti " + RESET);
        System.out.println( BLACK + PITCH_BG + "6. Methi Poori " + RESET);

        int ch = getIntInRange(sc, "Enter choice (1-4): ", 1, 4);

        switch (ch) {
            case 1: 
            return "Roti";
            case 2: 
            return "Paratha";
            case 3:
                 return "Kulcha";
                case 4:
                    return "Naan";
                case 5:
                    return "Missi Roti";
                    case 6:
                    return "Methi Poori";
            default:
                 return "Roti";
        }
    }

    public static String chooseRice(Scanner sc) {
        System.out.println(WHITE + MAROON_BG + "Choose Rice:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1.Rice \n 2. Jeera Rice \n 3. Green Peas Pulao \n 4. Veg Pulao \n 5. Veg Fried Rice \n 6. Veg Biryani" + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-6): ", 1, 6);
        switch (ch) {
            case 1: 
            return " Rice";
            case 2:
                 return "Jeera Rice";
            case 3:
                 return "Green Peas";
             case 4:
                 return "Veg  Pulao";
             case 5:
                 return "Veg Fried Rice"; 
         case 6: 
                 return "Veg Biryani ";

            default:
                 return "Rice";
        }      
    }

    public static String[] chooseDessert(Scanner sc) {
        System.out.println(MAROON_BG + WHITE + "Choose Dessert Type:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1. Ice Cream\n2. Sweet Dish\n3. Coffee" + RESET);
        int type = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
        String typeName = (type == 1) ? "Ice Cream" : (type == 2) ? "Sweet Dish" : "Coffee";

        System.out.println(MAROON_BG + PITCH_BG + "Choose Variant:" + RESET);
        String variant = "";
        switch (type) {
            case 1:
                System.out.println(PITCH_BG + BLACK + "1. Vanilla\n2. Chocolate\n3. Strawberry" + RESET);
                int v1 = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
                variant = (v1 == 1) ? "Vanilla" : (v1 == 2) ? "Chocolate" : "Strawberry";
                break;
            case 2:
                System.out.println(PITCH_BG + BLACK + "1. Gulab Jamun\n2. Rasgulla\n3. Barfi" + RESET);
                int v2 = getIntInRange(sc, "Enter choice (1-3): ", 1, 3);
                variant = (v2 == 1) ? "Gulab Jamun" : (v2 == 2) ? "Rasgulla" : "Barfi";
                break;
            case 3:
                System.out.println(PITCH_BG + BLACK + "1. Hot Coffee\n2. Cold Coffee" + RESET);
                int v3 = getIntInRange(sc, "Enter choice (1-2): ", 1, 2);
                variant = (v3 == 1) ? "Hot Coffee" : "Cold Coffee";
                break;
        }
        return new String[]{typeName, variant};
    }

    public static String chooseStarter(Scanner sc) {
       //  switch (ch)
       
                            System.out.println(WHITE + MAROON_BG +  " Starter:" + RESET);
                            System.out.println(BLACK + PITCH_BG + "1. Mix Veg Pakoda \n 2. Veg Finger \n 3. Bread Pakoda \n 4. Methi Kabab \n 5. Moong Pakoda \n 6. Dragon Aloo \n 7. Saboo Dana \n 8. Finger chips  \n 9. Veg Kothey \n 10. Hara Bhara Kabab \n 11. Corn Chaat \n 12. Aloo Chat \n 13. Saboo Dana Vada  \n 14. Veg Manchrian Dry \n 15. Tandoori Manchurian \n 16. Chinese Corn Kabab "+RESET);
                           /* System.out.println(BLACK + PITCH_BG + "1.Mix Veg Pakoda" + RESET);
                            System.out.println(BLACK + PITCH_BG + "2. Veg Finger " + RESET);
                            System.out.println(BLACK + PITCH_BG + "3.Bread Pakoda " + RESET);
                            System.out.println(BLACK + PITCH_BG + "4.Methi Kabab " + RESET);
                            System.out.println(BLACK + PITCH_BG + "5.Moong Pakoda " + RESET);
                            System.out.println(BLACK + PITCH_BG +"6.Dragon Aloo " + RESET);
                            System.out.println(BLACK + PITCH_BG + "7. Saboo Dana " + RESET);
                            System.out.println(BLACK + PITCH_BG + "8. Finger chips  " + RESET);
                            System.out.println(BLACK + PITCH_BG + "9. Aloo Corn Kabab " + RESET);
                            System.out.println(BLACK + PITCH_BG + "10. Veg Cutlet  " + RESET);
                            System.out.println(BLACK + PITCH_BG + "11. Veg Kothey  " + RESET);
                            System.out.println(BLACK + PITCH_BG + "12. Hara Bhara Kabab " + RESET);
                            System.out.println(BLACK + PITCH_BG +"13. Corn Chaat  " + RESET);
                            System.out.println(BLACK + PITCH_BG + "14. Aloo Chat  " + RESET);
                            System.out.println(BLACK + PITCH_BG + "15. Saboo Dana Vada " + RESET);
                            System.out.println(BLACK + PITCH_BG + "16. Veg Manchurian Dry" + RESET);
                            System.out.println(BLACK + PITCH_BG + "17. Tandoori Manchurian  " + RESET);
                            System.out.println(BLACK + PITCH_BG + "18. Chinese Corn Kabab  " + RESET);*/
                            int ch = getIntInRange(sc, "Enter choice (1-18): ", 1, 18);
                          
        switch (ch) {
            case 1:
                 return "Mix Veg Pakoda";
            case 2:
                 return " Veg Finger";
            case 3:
                 return "Bread Pakoda";
            case 4:
                 return "Methi Kabab ";
            case 5:
                 return "Moong Pakoda";
            case 6:
                 return "Dragon Aalo ";
            case 7:
                 return "Saboo Dana";
            case 8:
                 return "Finger chips";
            case 9:
                 return "Aaloo Corn Kabab";
            case 10:
                 return "Veg Cutlet";
            case 11:
                 return "Veg Kothey ";
            case 12:
                 return "Hara Bhara Kabab";
            case 13:
                 return "Corn Caat";
            case 14:
                 return "Aloo Chat";
            case 15:
                 return "Saboo Dana vada ";
            case 16:
                 return " Veg Manchurian Dry";
            case 17:
                 return "Tandoori Manchurian ";
            case 18:
                 return "Chinese Corn kabab";
            default: 
            return "Aalo chaat ";
        }
    }
    

public static String chooseChinese(Scanner sc) {
        System.out.println(WHITE + MAROON_BG + "Choose Chinese and Continental :" + RESET);
                            System.out.println(BLACK + PITCH_BG + "1. Backed Veg \n 2. Veg Manchurian \n 3. Veg Noodles \n 4. Backed Palak \n 5. Veg Singapoori Noodle \n 6. Veg Fried Rice " + RESET);
                           /* System.out.println(BLACK + PITCH_BG + "2. Veg Manchurian " + RESET);
                            System.out.println(BLACK + PITCH_BG + "3. veg noodles " + RESET);
                            System.out.println(BLACK + PITCH_BG + "4.  backed palak " + RESET);
                            System.out.println(BLACK + PITCH_BG + "5. Veg Singaoori Noodle " + RESET);
                            System.out.println(BLACK + PITCH_BG + "6. Veg Fried Rice " +RESET); */
                                        
                            int ch = getIntInRange(sc, "Enter choice (1-06): ", 1, 6);
             switch (ch) {
                 case 1:
                 return "Backed Veg";
                 case 2:
                 return "Veg Manchruian";
                 case 3:
                 return "Veg Noodles";
                 case 4:
                 return "Backed Palak ";
                 case 5:
                 return "Veg Singapoori Noodle";
                 case 6:
                 return "Veg Fried Rice";
                
            default: 
            return "Veg  Noodles";
        }
    }

    public static String chooseCurd(Scanner sc) {
        System.out.println(MAROON_BG + WHITE + "Choose Curd:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1.Veg Raita \n 2. Loki Raita \n 3. Aalo Raita \n 4. Dahi Papdi \n 5. Boondi Raita \n 6. Fruit Raita \n 7. Dahi Vada 2. " + RESET);
        /* System.out.println(PITCH_BG + BLACK + "2. Loki Raita" + RESET);
          System.out.println(PITCH_BG + BLACK + "3.Aaloo Raita" + RESET);
           System.out.println(PITCH_BG + BLACK + "4. Dahi Papdi" + RESET);
            System.out.println(PITCH_BG + BLACK + "5.Boondi Raita" + RESET);
             System.out.println(PITCH_BG + BLACK + "6.Fruit Raita " + RESET);
              System.out.println(PITCH_BG + BLACK + "7.Dahi Vada" + RESET);
               System.out.println(PITCH_BG + BLACK + "1.Veg Raita" + RESET);*/
        int ch = getIntInRange(sc, "Enter choice (1-7): ", 1, 7);
        switch (ch) {
                 case 1:
                 return "Veg Raita";
                 case 2:
                 return "Loki Raita";
                 case 3:
                 return "Aloo Raita";
                 case 4:
                 return "Dahi Papdi";
                 case 5:
                 return "Boondi Raita";
                 case 6:
                 return "Fruit Raita";
                 case 7:
                 return "Dahi Vada";
            default: 
            return "Dahi Vada";
        }
    }

public static String choosepasta(Scanner sc) {
        System.out.println(MAROON_BG + WHITE + "Choose pasta:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1. Pasta  . " + RESET);
        int ch = getIntInRange(sc, "Enter choice (1 or 2): ", 1,2 );
        switch (ch) {
                 case 1:
                 return "Pasta";
                  case 2:
                 return "Pasta type 1 ";
                 default:
                 return "Pasta type 1 ";
        }
}

public static String choosepaneerstarter(Scanner sc) {
        System.out.println(MAROON_BG + WHITE + "Choose Paneer Starter:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1. Paneer Chilli \n 2. Paneer Tikka \n 3. Dragon Paneer \n 4. Paneer 65 \n 5. Paneer Pudina Tikka \n 6. Paneer Achari Tikka. " + RESET);
        int ch = getIntInRange(sc, "Enter choice (1-6): ", 1, 6);
        switch (ch) {
                 case 1:
                 return "Paneer chilli";
                 case 2: 
                 return "Paneer Tikka";
                 case 3:
                 return "Dragon Paneer";
                 case 4:
                 return "Paneer 65";
                 case 5:
                 return "Paneer Pudina Tikka";
                 case 6:
                 return "Paneer Achari Tikka ";

                 default:
                 return "Paneer 65 ";
        }
}


    public static String choosesnack(Scanner sc, int n) {
        System.out.println(MAROON_BG + WHITE + "Choose Snack:" + RESET);
        System.out.println(PITCH_BG + BLACK + "1. Idli/Vada Shambhar  \n 2. Pav Bhaji \n 3. Chola Khulcha 4. Methi Paratha 5. Stuffed Paratha \n 6. Mulli paratha \n 7. Noodles \n 8. Chole Bhatura  \n 9. Chola poori \n 10. Paratha with Dahi Puri \n 11. Aaloo Paratha\n 12. Gobhi Paratha  "  + RESET);
      /*  System.out.println(PITCH_BG + BLACK + "2. Pav bhaji  "  + RESET);
        System.out.println(PITCH_BG + BLACK + "3. Chola Khulcha "  + RESET);
        System.out.println(PITCH_BG + BLACK + "4. Methi Paratha "  + RESET);
        System.out.println(PITCH_BG + BLACK + "5. Stuffed Paratha "   + RESET);
        System.out.println(PITCH_BG + BLACK + "6. Mulli Paratha "  + RESET);
        System.out.println(PITCH_BG + BLACK + "7. Noodles "  + RESET);
        System.out.println(PITCH_BG + BLACK + "8. Chole Bhatura "  + RESET);
        System.out.println(PITCH_BG + BLACK + "9. Chola Poori "  + RESET);
        System.out.println(PITCH_BG + BLACK + "10. Paratha with Dahi "  + RESET);
        System.out.println(PITCH_BG + BLACK + "11. Aloo Paratha "  + RESET);
        System.out.println(PITCH_BG + BLACK + "12. Gobhi Paratha  "  + RESET);*/
    
        int ch = getIntInRange(sc, "Enter choice (1-12): ", 1, 12);
        switch (ch) {
            case 1:
                 return "Idli/Vada Shambhar";
            case 2: 
            return "Pav Bhaji ";
            case 3:
                 return "Chola Khulcha";
                 case 4:
                 return "Methi Paratha";
            case 5:
                 return "Stuffed Paratha";
            case 6: 
            return "Mulli Paratha";
            case 7:
                 return "Noodles";
         case 8: 
            return "Chole Bhatura ";
             case 9: 
            return "Chola Poori ";
             case 10: 
            return "Paratha with Dahi";
             case 11: 
            return "Aloo Paratha ";
             case 12: 
            return "Gobhi paratha ";
            default:
                 return "Vada Pav";
        }
    }
}
//color lagana bill m , bil last m krna advvane token