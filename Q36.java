/*
36.Create class Product (pid, price, quantity) with parameterized constructor.
Create a main function in different class (say XYZ) and perform following task:
a. Accept five product information from user and store in an array
b. Find Pid of product with highest price.
c. Create method (with array of product’s object as argument) in XYZ class to calculate and return
 total amount spent on all products. (amount spent on single product=price of product * quantity of product)*/
 import java.util.Scanner;

class Product {
    int pid;
    double price;
    int quantity;

    // Parameterized Constructor
    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }
}

public class Q36 {

    // Method to calculate total amount spent
    public static double totalAmount(Product[] products) {
        double total = 0;
        for (Product p : products) {
            total += p.price * p.quantity;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[5];

        // Accept product info
        for (int i = 0; i < products.length; i++) {
            System.out.println("Enter details of Product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int pid = sc.nextInt();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            products[i] = new Product(pid, price, quantity);
        }

        // Find product with highest price
        double maxPrice = products[0].price;
        int maxPid = products[0].pid;
        for (Product p : products) {
            if (p.price > maxPrice) {
                maxPrice = p.price;
                maxPid = p.pid;
            }
        }

        System.out.println("\nProduct ID with highest price: " + maxPid);

        // Calculate and print total amount
        double total = totalAmount(products);
        System.out.println("Total amount spent on all products: " + total);

        sc.close();
    }
}
