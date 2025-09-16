/*

14.Create a class Product with data members (pid, pname, amount) and declare and define the member function 
1.acceptProduct()-- which accept product details.
2.displayProduct() -- display product information.
*/

import java.util.Scanner;

class Product {
    int pid;
    String pname;
    double amount;

    void acceptProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        pid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        pname = sc.nextLine();
        System.out.print("Enter Amount: ");
        amount = sc.nextDouble();
    }

    void displayProduct() {
        System.out.println("Product ID: " + pid + ", Name: " + pname + ", Amount: " + amount);
    }
}

public class Q14 {
    public static void main(String[] args) {
        Product p = new Product();
        p.acceptProduct();
        p.displayProduct();
    }
}
