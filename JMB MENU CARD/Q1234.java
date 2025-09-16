import java.util.Scanner;
import java.util.Random;

public class Q1234 {

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

        System.out.print(YELLOW + "lEnter Customer Name: " + RESET);
        String customerName = sc.nextLine().trim();

        System.out.print(YELLOW + "Enter Mobile Number: " + RESET);
        String mobileNo = sc.nextLine().trim();

        System.out.print(YELLOW + "Enter Booking Date (dd-MM-yyyy): " + RESET);
        String bookingDate = sc.nextLine().trim();

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

        int breakfastQty = 0;
        int snacksQty = 0;

        double subtotal = 0.0;

        boolean ordering = true;

        while(ordering) {
            System.out.println(CYAN + "\nMAIN MENU - Choose:" + RESET);
            System.out.println(GREEN + "1. Vegetarian Thali" + RESET);
            System.out.println(GREEN + "2. Breakfast & Snacks" + RESET);
            System.out.println(GREEN + "3. Exit & Print Bill" + RESET);

            int mainChoice = getIntInRange(sc, CYAN + "Enter main choice (1-3): " + RESET, 1, 3);

            if(mainChoice == 1) {
                // Thali Menu
                System.out.println(BLUE + "\nVEGETARIAN THALI MENU:" + RESET);
                System.out.println(YELLOW + "1. Thali 1 - Rs.310" + RESET);
                System.out.println(YELLOW + "2. Thali 2 - Rs.360" + RESET);
                System.out.println(YELLOW + "3. Thali 3 - Rs.410" + RESET);
                System.out.println(YELLOW + "4. Thali 4 - Rs.470" + RESET);
                System.out.println(YELLOW + "5. Thali 5 - Rs.600" + RESET);
                System.out.println(YELLOW + "6. Thali 6 - Rs.700" + RESET);

                int thaliChoice = getIntInRange(sc, "Select Thali number (1-6): ", 1, 6);

                switch(thaliChoice) {
                    case 1: thaliName = "Thali 1"; thaliPrice = 310; break;
                    case 2: thaliName = "Thali 2"; thaliPrice = 360; break;
                    case 3: thaliName = "Thali 3"; thaliPrice = 410; break;
                    case 4: thaliName = "Thali 4"; thaliPrice = 470; break;
                    case 5: thaliName = "Thali 5"; thaliPrice = 600; break;
                    case 6: thaliName = "Thali 6"; thaliPrice = 700; break;
                }

                thaliQty = getPositiveInt(sc, "Enter number of thalis: ");
                if(thaliQty > 100) { freeThalis = 5; System.out.println(GREEN + "Offer applied: 5 free thalis added." + RESET); }

                // Choose items for Thali
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

                subtotal += thaliPrice * thaliQty;

            } else if(mainChoice == 2) {
                System.out.println(BLUE + "\nBREAKFAST MENU:" + RESET);
                System.out.println(YELLOW + "1. Poha + Jalebi + Tea/Coffee" + RESET);
                System.out.println(YELLOW + "2. Bread + Heavy Snacks + Tea/Coffee" + RESET);
                System.out.println(YELLOW + "3. Heavy Snacks + Tea/Coffee" + RESET);

                int bch = getIntInRange(sc, "Choose breakfast type (1-3): ",1,3);
                int bq = getPositiveInt(sc, "Enter breakfast plates quantity: ");
                breakfastQty += bq;

                System.out.println(BLUE + "SNACKS MENU:" + RESET);
                System.out.println(YELLOW + "1. Samosa  2. Kachori  3. Sandwich" + RESET);
                int sch = getIntInRange(sc, "Choose snack type (1-3): ",1,3);
                int sq = getPositiveInt(sc, "Enter quantity: ");
                snacksQty += sq;

            } else {
                ordering=false;
            }
        }

        double gst = roundTwoDecimals(subtotal * 0.05);
        double grandTotal = subtotal + gst;

        // ===== Print Bill =====
        System.out.println(WHITE_BG + BLACK);
        System.out.println("==============================================================");
        System.out.printf("%-45s%-25s\n","JMB HOTEL - INVOICE","Bill No: "+billNo);
        System.out.printf("%-45s%-25s\n","Customer: "+customerName,"Mobile: "+mobileNo);
        System.out.printf("%-45s%-25s\n","Booking Date: "+bookingDate,"Party Size: "+partySize);
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-3s %-35s %6s %10s\n","No","Item Description","Qty","Amount(Rs)");
        System.out.println("--------------------------------------------------------------");
        int line=1;
        if(thaliQty>0){
            System.out.printf("%-3d %-35s %6d %10.2f\n", line++, thaliName+" ("+thaliPrice+" per)", thaliQty, (double)(thaliPrice*thaliQty));
            if(freeThalis>0) System.out.printf("%-3s %-35s %6d %10s\n", "", "FREE Thalis", freeThalis,"FREE");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Soup/Drink: "+soupDrink, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Paneer: "+paneerDish, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Veg Dish 1: "+vegDish1, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Veg Dish 2: "+vegDish2, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Dal: "+dalDish, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Starter: "+starterDish, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Roti: "+rotiDish, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Rice: "+riceDish, thaliQty,"-");
            System.out.printf("%-3d %-35s %6d %10s\n", line++, "Dessert: "+dessertType+" - "+dessertVariant, thaliQty,"-");
        }

        if(breakfastQty>0) System.out.printf("%-3d %-35s %6d %10s\n", line++, "Breakfast Plates", breakfastQty,"-");
        if(snacksQty>0) System.out.printf("%-3d %-35s %6d %10s\n", line++, "Snacks", snacksQty,"-");

        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-40s %10.2f\n","Subtotal (Thali only):", subtotal);
        System.out.printf("%-40s %10.2f\n","GST (5%):", gst);
        System.out.printf("%-40s %10.2f\n","GRAND TOTAL:", grandTotal);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Note: Only Thali price is charged. Other items are recorded for kitchen.");
        System.out.println(GREEN + "Thank you for choosing JMB Hotel! Visit Again." + RESET);
        System.out.println(RESET);

        sc.close();
    }

    // ===== Helper Methods =====
    public static int getPositiveInt(Scanner sc, String prompt){
        int v=-1;
        while(v<=0){
            System.out.print(prompt);
            if(sc.hasNextInt()){
                v=sc.nextInt(); sc.nextLine();
                if(v<=0) System.out.println(RED+"Enter positive number."+RESET);
            } else { System.out.println(RED+"Invalid input."+RESET); sc.nextLine();}
        }
        return v;
    }

    public static int getIntInRange(Scanner sc, String prompt, int min, int max){
        int v=Integer.MIN_VALUE;
        while(v<min || v>max){
            System.out.print(prompt);
            if(sc.hasNextInt()){
                v=sc.nextInt(); sc.nextLine();
                if(v<min || v>max) System.out.println(RED+"Enter between "+min+"-"+max+RESET);
            } else { System.out.println(RED+"Invalid input."+RESET); sc.nextLine();}
        }
        return v;
    }

    public static double roundTwoDecimals(double val){
        return Math.round(val*100.0)/100.0;
    }

    // ===== Menu selection methods =====
    public static String chooseSoupDrink(Scanner sc){
        System.out.println(BLUE+"Choose Soup/Drink:"+RESET);
        System.out.println(YELLOW+"1. Tomato Soup 2. Veg Manchow 3. Lemon Coriander 4. Hot & Sour Veg 5. Fresh Lime"+RESET);
        int ch = getIntInRange(sc,"Enter choice (1-5): ",1,5);
        switch(ch){
            case 1: return "Tomato Soup";
            case 2: return "Veg Manchow";
            case 3: return "Lemon Coriander";
            case 4: return "Hot & Sour Veg";
            default: return "Fresh Lime";
        }
    }

    public static String choosePaneer(Scanner sc){
        System.out.println(BLUE+"Choose Paneer Dish:"+RESET);
        System.out.println(YELLOW+"1. Butter Masala 2. Kadai 3. Punjabi 4. Kolhapuri"+RESET);
        int ch = getIntInRange(sc,"Enter choice (1-4): ",1,4);
        switch(ch){
            case 1: return "Butter Masala";
            case 2: return "Kadai";
            case 3: return "Punjabi";
            default: return "Kolhapuri";
        }
    }

    public static String chooseVeg(Scanner sc, int num){
        System.out.println(BLUE+"Choose Veg Dish #"+num+":"+RESET);
        System.out.println(YELLOW+"1. Nav Ratan 2. Methi Mutter 3. Mix Veg 4. Aloo Mutter 5. Corn Palak 6. Bhindi Masala 7. Gujarati Aloo 8. Dum Aloo"+RESET);
        int ch = getIntInRange(sc,"Enter choice (1-8): ",1,8);
        switch(ch){
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

    public static String chooseDal(Scanner sc){
        System.out.println(BLUE+"Choose Dal:"+RESET);
        System.out.println(YELLOW+"1. Dal Fry 2. Dal Tadka 3. Dal Makhani"+RESET);
        int ch=getIntInRange(sc,"Enter choice (1-3): ",1,3);
        switch(ch){
            case 1: return "Dal Fry";
            case 2: return "Dal Tadka";
            default: return "Dal Makhani";
        }
    }

    public static String chooseStarter(Scanner sc){
        System.out.println(BLUE+"Choose Starter:"+RESET);
        System.out.println(YELLOW+"1. Veg Manchurian 2. Spring Roll 3. Paneer Tikka 4. Corn Balls"+RESET);
        int ch=getIntInRange(sc,"Enter choice (1-4): ",1,4);
        switch(ch){
            case 1: return "Veg Manchurian";
            case 2: return "Spring Roll";
            case 3: return "Paneer Tikka";
            default: return "Corn Balls";
        }
    }

    public static String chooseRoti(Scanner sc){
        System.out.println(BLUE+"Choose Roti:"+RESET);
        System.out.println(YELLOW+"1. Tandoori 2. Butter 3. Missi 4. Laccha"+RESET);
        int ch=getIntInRange(sc,"Enter choice (1-4): ",1,4);
        switch(ch){
            case 1: return "Tandoori";
            case 2: return "Butter";
            case 3: return "Missi";
            default: return "Laccha";
        }
    }

    public static String chooseRice(Scanner sc){
        System.out.println(BLUE+"Choose Rice:"+RESET);
        System.out.println(YELLOW+"1. Steamed 2. Jeera 3. Veg Pulao"+RESET);
        int ch=getIntInRange(sc,"Enter choice (1-3): ",1,3);
        switch(ch){
            case 1: return "Steamed";
            case 2: return "Jeera";
            default: return "Veg Pulao";
        }
    }

    public static String[] chooseDessert(Scanner sc){
        System.out.println(BLUE + "Choose Dessert:" + RESET);
        System.out.println(YELLOW + "1. Ice Cream  2. Coffee  3. Sweet Dish" + RESET);
        int ch = getIntInRange(sc,"Enter choice (1-3): ",1,3);
        String type = "";
        String variant = "";

        switch(ch){
            case 1: 
                type = "Ice Cream"; 
                System.out.println(YELLOW + "Select Flavor: 1. Vanilla 2. Chocolate 3. Strawberry" + RESET);
                int f1 = getIntInRange(sc,"Enter flavor choice (1-3): ",1,3);
                switch(f1){
                    case 1: variant = "Vanilla"; break;
                    case 2: variant = "Chocolate"; break;
                    default: variant = "Strawberry";
                }
                break;
            case 2: 
                type = "Coffee"; 
                System.out.println(YELLOW + "Select Type: 1. Cappuccino 2. Latte 3. Espresso" + RESET);
                int f2 = getIntInRange(sc,"Enter coffee type (1-3): ",1,3);
                switch(f2){
                    case 1: variant = "Cappuccino"; break;
                    case 2: variant = "Latte"; break;
                    default: variant = "Espresso";
                }
                break;
            case 3: 
                type = "Sweet Dish"; 
                System.out.println(YELLOW + "Select Sweet: 1. Gulab Jamun 2. Rasgulla 3. Kheer" + RESET);
                int f3 = getIntInRange(sc,"Enter sweet choice (1-3): ",1,3);
                switch(f3){
                    case 1: variant = "Gulab Jamun"; break;
                    case 2: variant = "Rasgulla"; break;
                    default: variant = "Kheer";
                }
                break;
        }

        return new String[]{type, variant};
    }
}
