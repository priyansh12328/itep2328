/*

*/
import java.util.Scanner;

public class Q10 {
    static String name, rollNo, className;
    static int[] marks = new int[5];
    static int total = 0;
    static double percentage;
    static char grade;
    static boolean dataEntered = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Report Management System ===");
            System.out.println("1. Enter Student Details");
            System.out.println("2. Show Report Card");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    enterDetails(sc);
                    break;
                case 2:
                    if (dataEntered) {
                        calculateResult();
                        showReport();
                    } else {
                        System.out.println(" Please enter student details first!");
                    }
                    break;
                case 3:
                    System.out.println(" Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        sc.close();
    }

    // Enter student details
    static void enterDetails(Scanner sc) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextLine();
        System.out.print("Enter Class: ");
        className = sc.nextLine();

        total = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks of Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }
        dataEntered = true;
    }

    // Calculate percentage and grade
    static void calculateResult() {
        percentage = total / 5.0;
        if (percentage >= 90) grade = 'A';
        else if (percentage >= 75) grade = 'B';
        else if (percentage >= 50) grade = 'C';
        else grade = 'D';
    }

    // Display report card
    static void showReport() {
        System.out.println("\n===== STUDENT REPORT CARD =====");
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNo);
        System.out.println("Class      : " + className);
        System.out.println("-------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + (i + 1) + " Marks: " + marks[i]);
        }
        System.out.println("-------------------------------");
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage : " + percentage + "%");
        System.out.println("Grade      : " + grade);
        System.out.println("===============================");
    }
}
