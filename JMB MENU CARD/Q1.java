import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    // ANSI escape codes for colors and background colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_TEXT = "\u001B[30m";

    // Class to represent a single ordered item
    private static class OrderedItem {
        String name;
        double price;
        int quantity;

        public OrderedItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double getSubtotal() {
            return this.price * this.quantity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<OrderedItem> orderedItems = new ArrayList<>();
        boolean continueOrdering = true;

        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK_TEXT + "-------------------------------------" + ANSI_RESET);
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK_TEXT + "  Welcome to JMB - The Vegetarian Hub!" + ANSI_RESET);
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK_TEXT + "-------------------------------------" + ANSI_RESET);

        // Main ordering loop
        while (continueOrdering) {
            // Display the main menu
            System.out.println(ANSI_CYAN + "1. Vegetarian Menu" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "2. Breakfast Menu" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "3. Mocktail" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "4. Paneer Starters" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "5. Paneer Dish" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "6. Curd Dish" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "7. Soup" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "8. Sweets & Ice Cream" + ANSI_RESET);
            System.out.println(ANSI_RED + "9. Finish Order and Get Bill" + ANSI_RESET);
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice (1-9): ");

            if (!scanner.hasNextInt()) {
                System.out.println(ANSI_RED + "Invalid input. Please enter a number." + ANSI_RESET);
                scanner.next(); // Clear the invalid input
                continue;
            }
            int choice = scanner.nextInt();

            // Process user's menu choice
            switch (choice) {
                case 1:
                    orderItems(scanner, "Vegetarian Menu", orderedItems);
                    break;
                case 2:
                    orderItems(scanner, "Breakfast Menu", orderedItems);
                    break;
                case 3:
                    orderItems(scanner, "Mocktail", orderedItems);
                    break;
                case 4:
                    orderItems(scanner, "Paneer Starters", orderedItems);
                    break;
                case 5:
                    orderItems(scanner, "Paneer Dish", orderedItems);
                    break;
                case 6:
                    orderItems(scanner, "Curd Dish", orderedItems);
                    break;
                case 7:
                    orderItems(scanner, "Soup", orderedItems);
                    break;
                case 8:
                    orderItems(scanner, "Sweets & Ice Cream", orderedItems);
                    break;
                case 9:
                    continueOrdering = false;
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid choice. Please choose from 1-9." + ANSI_RESET);
                    break;
            }
        }

        // Display the final itemized bill
        System.out.println("\n" + ANSI_WHITE_BACKGROUND + ANSI_BLACK_TEXT + "-------------------------------------" + ANSI_RESET);
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK_TEXT + "          Your Final Bill" + ANSI_RESET);
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK_TEXT + "-------------------------------------" + ANSI_RESET);
        
        double finalTotal = 0.0;
        if (orderedItems.isEmpty()) {
            System.out.println("You have not ordered any items.");
        } else {
            System.out.println(ANSI_CYAN + "Item\t\tQty\tPrice" + ANSI_RESET);
            System.out.println("-------------------------------------");
            for (OrderedItem item : orderedItems) {
                System.out.printf(ANSI_YELLOW + "%s\t\t%d\t₹%.2f\n" + ANSI_RESET, item.name, item.quantity, item.getSubtotal());
                finalTotal += item.getSubtotal();
            }
        }
        
        System.out.println("-------------------------------------");
        System.out.printf(ANSI_GREEN + "Total Amount: ₹%.2f\n" + ANSI_RESET, finalTotal);
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK_TEXT + "-------------------------------------" + ANSI_RESET);

        scanner.close();
    }

    // A generic method to handle ordering for any menu type
    private static void orderItems(Scanner scanner, String menuType, List<OrderedItem> orderedItems) {
        boolean orderMore = true;

        do {
            System.out.println("\n" + ANSI_GREEN + "--- " + menuType + " ---" + ANSI_RESET);
            String itemChoice = "";
            double itemPrice = 0.0;
            String itemName = "";

            switch (menuType) {
                case "Vegetarian Menu":
                    System.out.println("1. Regular Thali - " + ANSI_YELLOW + "₹310" + ANSI_RESET);
                    System.out.println("2. Deluxe Thali - " + ANSI_YELLOW + "₹360" + ANSI_RESET);
                    System.out.println("3. Special Thali - " + ANSI_YELLOW + "₹410" + ANSI_RESET);
                    System.out.println("4. Premium Thali - " + ANSI_YELLOW + "₹470" + ANSI_RESET);
                    System.out.println("5. Family Pack - " + ANSI_YELLOW + "₹600" + ANSI_RESET);
                    System.out.println("6. Couple Special - " + ANSI_YELLOW + "₹750" + ANSI_RESET);
                    System.out.print("Enter your choice (1-6): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Regular Thali"; itemPrice = 310.0; break;
                        case "2": itemName = "Deluxe Thali"; itemPrice = 360.0; break;
                        case "3": itemName = "Special Thali"; itemPrice = 410.0; break;
                        case "4": itemName = "Premium Thali"; itemPrice = 470.0; break;
                        case "5": itemName = "Family Pack"; itemPrice = 600.0; break;
                        case "6": itemName = "Couple Special"; itemPrice = 750.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                case "Breakfast Menu":
                    System.out.println("1. Regular - " + ANSI_YELLOW + "₹200" + ANSI_RESET);
                    System.out.println("2. Deluxe - " + ANSI_YELLOW + "₹230" + ANSI_RESET);
                    System.out.println("3. Special - " + ANSI_YELLOW + "₹250" + ANSI_RESET);
                    System.out.println("4. Premium - " + ANSI_YELLOW + "₹300" + ANSI_RESET);
                    System.out.print("Enter your choice (1-4): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Regular Breakfast"; itemPrice = 200.0; break;
                        case "2": itemName = "Deluxe Breakfast"; itemPrice = 230.0; break;
                        case "3": itemName = "Special Breakfast"; itemPrice = 250.0; break;
                        case "4": itemName = "Premium Breakfast"; itemPrice = 300.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                case "Mocktail":
                    System.out.println("1. Blue Lagoon - " + ANSI_YELLOW + "₹180" + ANSI_RESET);
                    System.out.println("2. Virgin Mojito - " + ANSI_YELLOW + "₹180" + ANSI_RESET);
                    System.out.println("3. Strawberry Delight - " + ANSI_YELLOW + "₹180" + ANSI_RESET);
                    System.out.println("4. Khatti Meethi - " + ANSI_YELLOW + "₹180" + ANSI_RESET);
                    System.out.print("Enter your choice (1-4): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Blue Lagoon"; itemPrice = 180.0; break;
                        case "2": itemName = "Virgin Mojito"; itemPrice = 180.0; break;
                        case "3": itemName = "Strawberry Delight"; itemPrice = 180.0; break;
                        case "4": itemName = "Khatti Meethi"; itemPrice = 180.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                case "Paneer Starters":
                    System.out.println("1. Paneer Chilli - " + ANSI_YELLOW + "₹250" + ANSI_RESET);
                    System.out.println("2. Paneer Pudina Tikka - " + ANSI_YELLOW + "₹250" + ANSI_RESET);
                    System.out.println("3. Paneer Tikka - " + ANSI_YELLOW + "₹250" + ANSI_RESET);
                    System.out.println("4. Dragon Paneer - " + ANSI_YELLOW + "₹250" + ANSI_RESET);
                    System.out.print("Enter your choice (1-4): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Paneer Chilli"; itemPrice = 250.0; break;
                        case "2": itemName = "Paneer Pudina Tikka"; itemPrice = 250.0; break;
                        case "3": itemName = "Paneer Tikka"; itemPrice = 250.0; break;
                        case "4": itemName = "Dragon Paneer"; itemPrice = 250.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                case "Paneer Dish":
                    System.out.println("1. Shahi Paneer - " + ANSI_YELLOW + "₹300" + ANSI_RESET);
                    System.out.println("2. Kadhai Paneer - " + ANSI_YELLOW + "₹300" + ANSI_RESET);
                    System.out.println("3. Matar Paneer - " + ANSI_YELLOW + "₹300" + ANSI_RESET);
                    System.out.println("4. Paneer Lababdar - " + ANSI_YELLOW + "₹300" + ANSI_RESET);
                    System.out.print("Enter your choice (1-4): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Shahi Paneer"; itemPrice = 300.0; break;
                        case "2": itemName = "Kadhai Paneer"; itemPrice = 300.0; break;
                        case "3": itemName = "Matar Paneer"; itemPrice = 300.0; break;
                        case "4": itemName = "Paneer Lababdar"; itemPrice = 300.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                case "Curd Dish":
                    System.out.println("1. Veg Raita - " + ANSI_YELLOW + "₹120" + ANSI_RESET);
                    System.out.println("2. Bundi Raita - " + ANSI_YELLOW + "₹120" + ANSI_RESET);
                    System.out.println("3. Pineapple Raita - " + ANSI_YELLOW + "₹120" + ANSI_RESET);
                    System.out.println("4. Dahi Vada - " + ANSI_YELLOW + "₹120" + ANSI_RESET);
                    System.out.print("Enter your choice (1-4): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Veg Raita"; itemPrice = 120.0; break;
                        case "2": itemName = "Bundi Raita"; itemPrice = 120.0; break;
                        case "3": itemName = "Pineapple Raita"; itemPrice = 120.0; break;
                        case "4": itemName = "Dahi Vada"; itemPrice = 120.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                case "Soup":
                    System.out.println("1. Tomato Soup - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.println("2. Hot & Sour Veg - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.println("3. Veg Manchow - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.println("4. Lemon Coriander - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.print("Enter your choice (1-4): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Tomato Soup"; itemPrice = 100.0; break;
                        case "2": itemName = "Hot & Sour Veg"; itemPrice = 100.0; break;
                        case "3": itemName = "Veg Manchow"; itemPrice = 100.0; break;
                        case "4": itemName = "Lemon Coriander"; itemPrice = 100.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                case "Sweets & Ice Cream":
                    System.out.println("1. Gulab Jamun - " + ANSI_YELLOW + "₹80" + ANSI_RESET);
                    System.out.println("2. Rasgulla - " + ANSI_YELLOW + "₹80" + ANSI_RESET);
                    System.out.println("3. Moong ka Halwa - " + ANSI_YELLOW + "₹120" + ANSI_RESET);
                    System.out.println("4. Kulfi - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.println("5. Butter Scotch - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.println("6. Vanilla - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.println("7. Chocolate - " + ANSI_YELLOW + "₹100" + ANSI_RESET);
                    System.out.print("Enter your choice (1-7): ");
                    itemChoice = scanner.next();
                    switch (itemChoice) {
                        case "1": itemName = "Gulab Jamun"; itemPrice = 80.0; break;
                        case "2": itemName = "Rasgulla"; itemPrice = 80.0; break;
                        case "3": itemName = "Moong ka Halwa"; itemPrice = 120.0; break;
                        case "4": itemName = "Kulfi"; itemPrice = 100.0; break;
                        case "5": itemName = "Butter Scotch"; itemPrice = 100.0; break;
                        case "6": itemName = "Vanilla"; itemPrice = 100.0; break;
                        case "7": itemName = "Chocolate"; itemPrice = 100.0; break;
                        default: System.out.println(ANSI_RED + "Invalid choice. No item added." + ANSI_RESET); break;
                    }
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid menu type. Returning to main menu." + ANSI_RESET);
                    return;
            }

            if (itemPrice > 0.0) {
                System.out.print("Enter quantity: ");
                if (!scanner.hasNextInt()) {
                    System.out.println(ANSI_RED + "Invalid quantity. Not adding item." + ANSI_RESET);
                    scanner.next();
                } else {
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        orderedItems.add(new OrderedItem(itemName, itemPrice, quantity));
                        System.out.println(ANSI_GREEN + "Added " + quantity + " " + itemName + " to your order." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Quantity must be greater than zero. Not adding item." + ANSI_RESET);
                    }
                }
            }

            System.out.print("\nDo you want to order more from the " + menuType + " menu? (yes/no): ");
            String moreChoice = scanner.next();
            if (moreChoice.equalsIgnoreCase("no")) {
                orderMore = false;
            }

        } while (orderMore);
    }
}
