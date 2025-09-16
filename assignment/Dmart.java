import java.util.Scanner;

public class Dmart {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name :");
        String name = sc.next();

        System.out.println("Enter your gender ('M' or 'F') :");
        char gender = sc.next().charAt(0);

        System.out.println("Enter item number : ");
        int item_number = sc.nextInt();

        System.out.println("Enter item name :");
        String item_name = sc.next();

        System.out.println("Enter the quantity of each product :");
        int quantity = sc.nextInt();

        int item_cost = 10;
        int discount;

        int total_cost = quantity * item_cost;
        int discounted_item_cost = 0;

        if (item_number == 1) {
            if (quantity > 4) {
                discount = (total_cost * 5) / 100;
                discounted_item_cost = total_cost - discount;
                System.out.println("Amount that will print on bill : " + discounted_item_cost);
            } else {
                System.out.println("amount that will print on bill : " + total_cost);
            }

        } else if (item_number == 5) {
            discount = (total_cost * 10) / 100;
            discounted_item_cost = total_cost - discount;
            System.out.println("Amount that will print on bill : " + discounted_item_cost);
        } else if (item_number == 10) {
            discount = (total_cost * 15) / 100;
            discounted_item_cost = total_cost - discount;
            System.out.println("Amount that will print on bill : " + discounted_item_cost);
        } else {
            System.out.println("Invalid item number");
        }

        int total_bill = 0;
        total_bill += discounted_item_cost;
        discounted_item_cost++;
        int total_discount;
        int discounted_bill = 0;

        if (total_bill > 10000) {
            total_discount = (total_bill * 15) / 100;
            discounted_bill = total_bill - total_discount;
        } else if (total_bill > 5000 && total_bill < 10000) {
            total_discount = (total_bill * 10) / 100;
            discounted_bill = total_bill - total_discount;

        } else {
            System.out.println("Invalid bill amount");
        }

        int gst = (discounted_bill * 10) / 100;
        int bill_with_gst = discounted_bill + gst;
        System.out.println("GST on total bill : " + (bill_with_gst));

        System.out.println("Ask for carry bag ('yes' or 'no' ): ");
        String carry_bag = sc.next();

        if (carry_bag == "yes") {
            System.out.println("Bill after adding carry bag : " + (bill_with_gst + 10));
        } else {
            System.out.println("Bill without adding carry bag : " + bill_with_gst);
        }
        String gift = "0";
        if (gender == 'F') {
            gift = "Cadeberry";
            System.out.println("Gift : Cadeberry");
        } else if (gender == 'M') {
            gift = "Ladger Wallet";
            System.out.println("Gift : Ladger Wallet");
        } else {
            System.out.println("Invalid gender");
        } 

        System.out.println("      D-MART     ");
        System.out.println("Name :" + name + "              Date :21/07/2025");
        System.out.println("--------------------------------------------");
        System.out.println("Item Name   Quantity   Price   Total    After-Discount");
        System.out.println(
            +item_number+"    " + quantity + "        " + item_cost + "       " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"   " + quantity + "         " + item_cost + "       " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"   " + quantity + "         " + item_cost + "       " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"    " + quantity + "        " + item_cost + "       " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"    " + quantity + "        " + item_cost + "       " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"    " + quantity + "         " + item_cost + "       " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"    " + quantity + "         " + item_cost + "       " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"    " + quantity + "        " + item_cost + "        " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"    " + quantity + "         " + item_cost + "        " + total_cost + "       "
                        + discounted_item_cost);
        System.out.println(
            +item_number+"    " + quantity + "       " + item_cost + "       " + total_cost + "          "
                        + discounted_item_cost);
        System.out.println("------------------------------------------------");
        System.out.println("                                             A.P       D.P");
        System.out.println("                                      " + total_bill + "   " + discounted_bill);
        System.out.println("Gift : " + gift + "                                  0.00   0.00");
        System.out.println("");
        System.out.println("Carry Bag : " + carry_bag + "                            10.00      10.00");
        System.out.println("GST(10%) :                                  " + gst + "     " + gst);
        System.out.println("-------------------------------------------");
        System.out.println("                                                      " + bill_with_gst);
        System.out.println("                   Thank You       ");
        System.out.println("                   To Visit       ");
        System.out.println("                    D-Mart       ");
        System.out.println("------------------------------------------");

    }
}
