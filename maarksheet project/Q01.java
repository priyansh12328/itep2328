//final


import java.util.Scanner;

public class Q01 {
    //colour print  code
    public static final String RESET = "\u001B[0m";
   public static final String BG_WHITE = "\u001B[47m"; // White background
    public static final String FG_BLACK = "\u001B[30m"; // Black text
   public static final String FG_RED = "\u001B[31m";
    public static final String FG_GREEN = "\u001B[32m";
    public static final String FG_YELLOW = "\u001B[33m";
  public static final String FG_CYAN = "\u001B[36m";
   public static final String FG_MAGENTA = "\u001B[35m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // School Name
        String schoolName = "Royal Heights Higher Secondary School, Jirapur";

        // Student Infomation about
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter Class: ");
        String className = sc.nextLine();

        // Theory Subjects of student have 
        String[] theorySubjects = new String[5];
        int[] theoryMarks = new int[5];
        int theoryOutOf = 100;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Theory Subject " + (i + 1) + ": ");
            theorySubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + theorySubjects[i] + " (out of " + theoryOutOf + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= theoryOutOf) {
                    theoryMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + theoryOutOf );
                }
            }
            sc.nextLine(); 
        }

        // Practical Subjects stu
        String[] practicalSubjects = new String[2];
        int[] practicalMarks = new int[2];
        int practicalOutOf = 25;

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter Practical Subject " + (i + 1) + ": ");
            practicalSubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + practicalSubjects[i] + " (out of " + practicalOutOf + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= practicalOutOf) {
                    practicalMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + practicalOutOf);
                }
            }
            sc.nextLine(); // consume newline
        }

        // total lkrege ab 
        int totalTheory = 0, totalPractical = 0, failCount = 0;

        for (int marks : theoryMarks) {
            totalTheory =totalTheory+ marks;
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
        System.out.println("\n" + BG_WHITE + FG_BLACK + "------------------------ OFFICIAL MARKSHEET -----------------------------"                                         );
        System.out.println(BG_WHITE + FG_BLACK + schoolName                                                                                                      );
        System.out.println(BG_WHITE + FG_BLACK + "Name: " + studentName + "   Roll No: " + rollNo + "   Class: " + className                                        );
        System.out.println(BG_WHITE + FG_BLACK + "--------------------------------------------------"                                                             );
        System.out.println(BG_WHITE + FG_BLACK + "Subject\t\tOut Of\tObtained"                                                                                   );

        for (int i = 0; i < 5; i++) {
            System.out.println(BG_WHITE + FG_BLACK + String.format("%-15s %3d %10d", theorySubjects[i], theoryOutOf, theoryMarks[i])                    );
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(BG_WHITE + FG_BLACK + String.format("%-15s %3d %10d", practicalSubjects[i], practicalOutOf, practicalMarks[i])                      );
        }

        System.out.println(BG_WHITE + FG_BLACK + "--------------------------------------------------"                       );
        System.out.println(BG_WHITE + FG_BLACK + "Total: " + grandTotal + " / " + totalOutOf                 );
        System.out.printf(BG_WHITE + FG_BLACK + "Percentage: %.2f %%\n" , percentage                           );
        System.out.println(BG_WHITE + FG_BLACK + "Grade: " + grade                                             );
        System.out.println(BG_WHITE + FG_BLACK + "Remark: " + remark                                            );
        System.out.println(BG_WHITE + FG_BLACK + "---------------------------------------------------"               );
    }
}
