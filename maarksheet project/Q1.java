import java.util.Scanner;

public class Q1 {
    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_WHITE = "\u001B[47m";
    public static final String FG_BLACK = "\u001B[30m";
    public static final String FG_RED = "\u001B[31m";
    public static final String FG_GREEN = "\u001B[32m";
    public static final String FG_YELLOW = "\u001B[33m";
    public static final String FG_CYAN = "\u001B[36m";
    public static final String FG_MAGENTA = "\u001B[35m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // School & Student Info
        System.out.println(BG_BLUE + FG_BLACK + "===== SCHOOL INFORMATION =====" + RESET);
        System.out.print("Enter School Name: ");
        String schoolName = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();
        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter Class: ");
        String className = sc.nextLine();

        // Theory Subjects
        String[] theorySubjects = new String[5];
        int[] theoryMarks = new int[5];
        int theoryOutOf = 100;

        System.out.println("\n" + BG_BLUE + FG_BLACK + "===== ENTER THEORY SUBJECTS =====" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name of theory subject " + (i + 1) + ": ");
            theorySubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + theorySubjects[i] + " (out of " + theoryOutOf + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= theoryOutOf) {
                    theoryMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + theoryOutOf + RESET);
                }
            }
            sc.nextLine(); // consume newline
        }

        // Practical Subjects
        String[] practicalSubjects = new String[2];
        int[] practicalMarks = new int[2];
        int practicalOutOf = 25;

        System.out.println("\n" + BG_BLUE + FG_BLACK + "===== ENTER PRACTICAL SUBJECTS =====" + RESET);
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter name of practical subject " + (i + 1) + ": ");
            practicalSubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + practicalSubjects[i] + " (out of " + practicalOutOf + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= practicalOutOf) {
                    practicalMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + practicalOutOf + RESET);
                }
            }
            sc.nextLine(); // consume newline
        }

        // Processing
        int totalTheory = 0, totalPractical = 0, failCount = 0;

        for (int marks : theoryMarks) {
            totalTheory += marks;
            if (marks < 33) failCount++;
        }
        for (int marks : practicalMarks) {
            totalPractical += marks;
        }

        int grandTotal = totalTheory + totalPractical;
        int totalOutOf = (5 * theoryOutOf) + (2 * practicalOutOf);
        double percentage = (grandTotal * 100.0) / totalOutOf;

        // Grade
        String grade;
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B+";
        else if (percentage >= 60) grade = "B";
        else if (percentage >= 50) grade = "C";
        else if (percentage >= 33) grade = "D";
        else grade = "F";

        // Remark
        String remark;
        if (failCount >= 3) remark = "Year Back";
        else if (failCount > 0) remark = "ATKT";
        else remark = "Pass";

        // Output Marksheet
        System.out.println("\n" + BG_WHITE + FG_BLACK + "=============== OFFICIAL MARKSHEET ===============" + RESET);

        // School Header
        System.out.println(FG_MAGENTA + "                  " + schoolName.toUpperCase() + RESET);
        System.out.println(FG_CYAN + "--------------------------------------------------" + RESET);
        System.out.println(FG_GREEN + "Name: " + studentName + 
                           "   Roll No: " + rollNo + 
                           "   Class: " + className + RESET);
        System.out.println(FG_CYAN + "--------------------------------------------------" + RESET);

        // Subjects Table
        System.out.printf(FG_YELLOW + "%-20s %-10s %-10s\n" + RESET, "Subject", "Out Of", "Obtained");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-20s %-10d %-10d\n", theorySubjects[i], theoryOutOf, theoryMarks[i]);
        }
        for (int i = 0; i < 2; i++) {
            System.out.printf("%-20s %-10d %-10d\n", practicalSubjects[i], practicalOutOf, practicalMarks[i]);
        }
        System.out.println("--------------------------------------------------");

        // Results
        System.out.printf(FG_MAGENTA + "Total: %d / %d\n" + RESET, grandTotal, totalOutOf);
        System.out.printf(FG_GREEN + "Percentage: %.2f %%\n" + RESET, percentage);
        System.out.println(FG_YELLOW + "Grade: " + grade + RESET);
        System.out.println(FG_RED + "Remark: " + remark + RESET);
        System.out.println(BG_WHITE + FG_BLACK + "=====================================" + RESET);
    }
}
