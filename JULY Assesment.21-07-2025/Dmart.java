import java.util.Scanner ;

class Dmart  
{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);



System.out.println("Enter the name  of  Customer:");
String customername = sc.next();


System.out.println("Enter the gender ,F||  M: ");
char   gender = sc.next().charAt(0);


System.out.print("Enter the name of item1: ");
String item1 = sc.next();


System.out.print("enter the  quantity of item: ");
int   quantity1 = sc.nextInt();


System.out.print("enter the  price  of item: ");
  int price1 = sc.nextInt();

        double total1 = quantity1 * price1;
        double discounted1 = total1;

        if (quantity1 >4) {
            discounted1 = total1 * 0.05;

            System.out.println("5% Discount Applied   After discount: " + discounted1);
        } else {
            System.out.println("No Discount on Item 1.");
        }

      

        // Item 2
        System.out.print("Enter name of Item 2: ");
        String item2 = sc.next();

        System.out.print("Enter quantity: ");
        int quantity2 = sc.nextInt();

        System.out.print("Enter price: ");
        int price2 = sc.nextInt();

        double total2 = quantity2 * price2;
        ///about the item 3 
 System.out.print("Enter name of Item 3: ");
        String item3 = sc.next();

        System.out.print("Enter quantity: ");
        int quantity3= sc.nextInt();

        System.out.print("Enter price: ");
        int price3 = sc.nextInt();

        double total3 = quantity3 * price3;
        
//item3 


               System.out.print("Enter name of Item 4:");
        String item4 = sc.next();

        System.out.print("Enter quantity: ");
        int quantity4= sc.nextInt();

        System.out.print("Enter price: ");
        int price4 = sc.nextInt();

        double total4 = quantity4 * price4;
        
//itemm 5
  System.out.print("Enter name of Item 5: ");
        String item5 = sc.next();

        System.out.print("Enter quantity: ");
        int quantity5 = sc.nextInt();


        System.out.print("Enter price: ");
        int price5 = sc.nextInt();

        double total5 = quantity5 * price5;
        double discounted2 = total5 * 0.90;
//item 6 

  System.out.print("Enter name of Item 6: ");
        String item6 = sc.next();

        System.out.print("Enter quantity: ");
        int quantity6 = sc.nextInt();

        System.out.print("Enter price: ");
        int price6 = sc.nextInt();

        double total6 = quantity6 * price6;

  System.out.print("Enter name of Item 7: ");
        String item7 = sc.next();

        System.out.print("Enter quantity: ");
        int quantity7 = sc.nextInt();

        System.out.print("Enter price: ");
        int price7 = sc.nextInt();

        double total7 = quantity7 * price7;
   System.out.print("Enter name of Item 8: ");

        String item8 = sc.next();
        System.out.print("Enter quantity: ");

        int quantity8 = sc.nextInt();
        System.out.print("Enter price: ");

        int price8 = sc.nextInt();
        double total8 = quantity8 * price8;

        

       
        System.out.print("Enter name of Item 9: ");
        String item9 = sc.next();

        System.out.print("Enter quantity: ");
        int quantity9 = sc.nextInt();

        System.out.print("Enter price: ");
        int price9 = sc.nextInt();

        double total9 = quantity9 * price9;

     

       
        System.out.print("Enter name of Item 10: ");
        String item10 = sc.next();
        System.out.print("Enter quantity: ");
        int quantity10 = sc.nextInt();

        System.out.print("Enter price: ");
        int price10 = sc.nextInt();

        double total10 = quantity10 * price10;
        double discounted3 = total10 * 0.15; // 15% discount
    double billAmount = total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8 + total9 + total10;
   double billAmountdiscounted = discounted1+ total2 + total3 + total4 + discounted2 + total6 + total7 + total8 + total9 + discounted3;
 double billDiscount = 0;
        if (billAmount > 10000) {
            billDiscount = billAmount * 0.15;

        } 
else if (billAmount > 5000 && billAmount <= 10000) {
            billDiscount = billAmount * 0.10;
        }

      
   double gst = billAmount * 0.10;
   double billgst = gst+billAmount;
  
   double gst1 = billAmountdiscounted*0.10;
   double gstdiscountedbill = billAmountdiscounted+gst1; 

 System.out.print("Do you want carry bag? (Y/N): ");
String carrybag = sc.next();
double billgstcarrybag=billgst;
double billgstdiscountedcarrybag =gstdiscountedbill ;

if (carrybag.equalsIgnoreCase("Y")) {
            billgstcarrybag = 10.0 + billgst;
            billgstdiscountedcarrybag = 10.0 + gstdiscountedbill;
            System.out.println("total bill with carrybag: " + billgstcarrybag);
            System.out.println("total bill with carrybag: " + billgstdiscountedcarrybag);
        }





/*
if (carrybag==" Y")
{
    
     billgstcarrybag = 10.0+ billgst;
    System.out.println("total bill with  carrybag:" +billgstcarrybag);
     billgstdiscountedcarrybag = 10.0+gstdiscountedbill;
    System.out.println("total bill with  carrybag:" +billgstdiscountedcarrybag);

}*/
  String gift = "0";
        if (gender == 'F') {
            gift = "Cadeberry";
            System.out.println(" free Gift : Cadeberry");
        } else if (gender == 'M') {
            gift = "Ledger Wallet";
            System.out.println("free Gift : Ladger Wallet");
        } else {
            System.out.println("Invalid gender");
        }  
     System.out.println("        D-MART     ");
    System.out.println("Name :" +customername + "              Date :21/07/2025");
       System.out.println("------------------------------------------------------------------------");

  System.out.println("Item Name     Quantity      Price            Total         AfterDiscount");
  System.out.println(   " " +item1+"              " + quantity1+ "               " +price1+ "              "+total1+ "                  "+discounted1);
  System.out.println(   " " +item2+"              " + quantity2+ "               " +price2+ "              " +total2+ "                 "+total2);
  System.out.println(   " " +item3+"              " + quantity3+ "               " +price3+ "              " +total3+ "                 "+total3);
  System.out.println(   " " +item4+"              " + quantity4+ "               " +price4+ "               "+total4+ "                 "+total4);
  System.out.println(   " " +item5+"              " + quantity5+ "               " +price5+ "               "+total5+ "                 "+discounted2);  
  System.out.println(   " " +item6+"              " + quantity6+ "               " +price6+ "               "+total6+ "                 "+total6);
  System.out.println(   " " +item7+"              " + quantity7+ "               " +price7+ "               "+total7+"                  "+total7);
  System.out.println(   " " +item8+"              " + quantity8+ "               " +price8+ "               "+total8+"                  "+total8);
  System.out.println(   " " +item9+"              " + quantity9+ "               " +price9+ "               "+total9+"                  "+total9);
  System.out.println(   " " +item10+"             " + quantity10+ "              " +price10+ "              "+total10+"                 "+discounted3);
     System.out.println("----------------------------------------------------------------------------------------------");
 System.out.println("                                                  A.P                        D.P");
   System.out.println("  net bill                                             " + billAmount + "               " + billAmountdiscounted);
    System.out.println("Gift : " + gift + "                                   0.00                         0.00");
        System.out.println("");
        System.out.println("Carry Bag : " + carrybag + "                                  10.00                 10.00");
        System.out.println("GST(10%) :                                       " + gst + "                  " + gst);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("\t\t\t" +billgstcarrybag+"\t\t" +billgstdiscountedcarrybag);
        System.out.println("                   Thank You       ");
        System.out.println("                   To Visit       ");
        System.out.println("                    D-Mart       ");
        System.out.println("---------------------------------------------------------------------");

}}