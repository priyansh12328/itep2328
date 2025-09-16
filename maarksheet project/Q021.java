/*
import java.util.Scanner;

public class Q021 {

    // ANSI Codes
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    // Background Colors
    public static final String BG_WHITE = "\u001B[47m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_BRIGHT_GREEN = "\u001B[102m";
    public static final String BG_BRIGHT_BLUE = "\u001B[104m";
    public static final String BG_BRIGHT_WHITE = "\u001B[107m";
    public static final String BG_BRIGHT_YELLOW = "\u001B[103m";

    // Foreground Colors
    public static final String FG_BLACK = "\u001B[30m";
    public static final String FG_RED = "\u001B[31m";
    public static final String FG_GREEN = "\u001B[32m";
    public static final String FG_CYAN = "\u001B[36m";

    // fixed width
    public static final int WIDTH = 60;

    // method to create border line
    public static String makeBorder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // College name
        String collegename = "GOVT. HOLKAR (MODEL, AUTONOMOUS) SCIENCE COLLEGE, INDORE";

        // Input details
        System.out.print("Enter Start of exam month year: ");
        String startmonth = sc.nextLine();

        System.out.print("Enter End of Exam month year: ");
        String endmonth = sc.nextLine();

        System.out.print("Enter Semester: ");
        String semester = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll no: ");
        String Rollno = sc.nextLine();

        System.out.print("Enter Class Name: ");
        String classname = sc.nextLine();

        System.out.print("Enter Father name: ");
        String fathername = sc.nextLine();

        System.out.print("Enter Mother name: ");
        String mothername = sc.nextLine();

        System.out.print("Enter Status of Student (Regular/Private): ");
        String status = sc.nextLine();

        System.out.print("Enter Course Name: ");
        String coursename = sc.nextLine();

        System.out.print("Enter Enrollment no: ");
        String Enrollmentno = sc.nextLine();

        System.out.print("Enter Course Specialization: ");
        String Specialization = sc.nextLine();

        // Subjects
        String[] theorySubjects = new String[5];
        int[] theoryMarks = new int[5];
        int theoryoutof = 100;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Theory Subject: ");
            theorySubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + theorySubjects[i] + " (out of " + theoryoutof + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= theoryoutof) {
                    theoryMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + theoryoutof + RESET);
                }
            }
            sc.nextLine();
        }

        // Practical
        String[] practicalsubjects = new String[2];
        int[] practicalMarks = new int[2];
        int practicaloutof = 25;
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter Practical Subject " + (i + 1) + ": ");
            practicalsubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + practicalsubjects[i] + " (out of " + practicaloutof + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= practicaloutof) {
                    practicalMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + practicaloutof + RESET);
                }
            }
            sc.nextLine();
        }

        // Calculation
        int totaltheory = 0, totalPractical = 0, failcount = 0;
        for (int marks : theoryMarks) {
            totaltheory += marks;
            if (marks < 33) failcount++;
        }
        for (int marks : practicalMarks) totalPractical += marks;

        int grandtotal = totaltheory + totalPractical;
        int totaloutof = (5 * theoryoutof) + (2 * practicaloutof);
        double percentage = (grandtotal * 100.0) / totaloutof;

        // Grade
        String grade;
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B+";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 50) grade = "D";
        else if (percentage >= 33) grade = "E";
        else grade = "F";

        // Remark
        String remark;
        if (failcount >= 3) remark = "Year Back";
        else if (failcount > 0) remark = "ATKT";
        else remark = "Pass";

        // ===================== PRINTING MARKSHEET ======================
        String border = makeBorder();
      //  System.out.println(BG_BRIGHT_BLUE+FG_BLACK+WIDTH "------------------------------------------------------------------------------------"+RESET)
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_WHITE + FG_BLACK + BOLD + String.format("%-60", + "s", collegename) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("%-60", + WIDTH + "s",
                coursename + " " + Specialization + " SEM-" + semester) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("%-60"   ,
                "MAIN EXAMINATION, " + startmonth + " - " + endmonth) + RESET);
        System.out.println("%-60",BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_BRIGHT_GREEN + FG_BLACK + String.format("%-60"   ,
                "ENROLLMENT NO : " + Enrollmentno + "         NAME : " + studentName) + RESET);
        System.out.println(BG_BRIGHT_BLUE + FG_BLACK + String.format("%-60" + "s",
                "ROLL NO : " + Rollno + "        STATUS : " + status) + RESET);
        System.out.println(BG_BRIGHT_GREEN + FG_BLACK + String.format("%-60" +  "s",
                "FATHER's NAME : " + fathername + "        MOTHER'S NAME : " + mothername) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + border + RESET);

        System.out.println(BG_BRIGHT_YELLOW + FG_BLACK + WIDTH+
                String.format("%-20s %-20s %-20s %-15s", "SUBJECT", "OBTAINED", "TOTAL", "GRADE") + RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(BG_WHITE + FG_BLACK + WIDTH+
                    String.format("%-20s %-20d %-20d %-15s",
                            theorySubjects[i], theoryMarks[i], theoryoutof, grade) + RESET);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(BG_WHITE + FG_BLACK +
                    String.format("%-20s %-20d %-20d %-15s",
                            practicalsubjects[i], practicalMarks[i], practicaloutof, grade) + RESET);
        }

        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + 
                String.format("%-20s %-20d %-20d", "TOTAL", grandtotal, totaloutof) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                " PERCENTAGE : " + String.format("%-60s","%.2f", percentage) + "%" + RESET);
        System.out.println("%-60s",BG_BRIGHT_WHITE + FG_CYAN +WIDTH+ " GRADE : " + grade + RESET);
        System.out.println("%-60s",BG_BRIGHT_WHITE + FG_BLACK + WIDTH+" REMARK : " + remark + RESET);
        System.out.println("%-60s",BG_BLUE + FG_BLACK + BOLD +WIDTH+ border + RESET);

        System.out.println(BG_WHITE + FG_BLACK +
                String.format("%-60" + "s", "HEAD OF DEPARTMENT                            PRINCIPAL") + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                String.format("%-60s", "NOTE: Computer Generated Marksheet. Contact Exam Dept. for Official Copy.") + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        sc.close();
    }
}*/
import java.util.Scanner;

public class Q021 {

    // ANSI Codes
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    // Background Colors
    public static final String BG_WHITE = "\u001B[47m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_BRIGHT_GREEN = "\u001B[102m";
    public static final String BG_BRIGHT_BLUE = "\u001B[104m";
    public static final String BG_BRIGHT_WHITE = "\u001B[107m";
    public static final String BG_BRIGHT_YELLOW = "\u001B[103m";

    // Foreground Colors
    public static final String FG_BLACK = "\u001B[30m";
    public static final String FG_RED = "\u001B[31m";
    public static final String FG_GREEN = "\u001B[32m";
    public static final String FG_CYAN = "\u001B[36m";

    // fixed width
    public static final int WIDTH = 60;

    // method to create border line
    public static String makeBorder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // College name
        String collegename = "GOVT. HOLKAR (MODEL, AUTONOMOUS) SCIENCE COLLEGE, INDORE";

        // Input details
        System.out.print("Enter Start of exam month year: ");
        String startmonth = sc.nextLine();

        System.out.print("Enter End of Exam month year: ");
        String endmonth = sc.nextLine();

        System.out.print("Enter Semester: ");
        String semester = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll no: ");
        String Rollno = sc.nextLine();

        System.out.print("Enter Class Name: ");
        String classname = sc.nextLine();

        System.out.print("Enter Father name: ");
        String fathername = sc.nextLine();

        System.out.print("Enter Mother name: ");
        String mothername = sc.nextLine();

        System.out.print("Enter Status of Student (Regular/Private): ");
        String status = sc.nextLine();

        System.out.print("Enter Course Name: ");
        String coursename = sc.nextLine();

        System.out.print("Enter Enrollment no: ");
        String Enrollmentno = sc.nextLine();

        System.out.print("Enter Course Specialization: ");
        String Specialization = sc.nextLine();

        // Subjects
        String[] theorySubjects = new String[5];
        int[] theoryMarks = new int[5];
        int theoryoutof = 100;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Theory Subject: ");
            theorySubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + theorySubjects[i] + " (out of " + theoryoutof + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= theoryoutof) {
                    theoryMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + theoryoutof + RESET);
                }
            }
            sc.nextLine();
        }

        // Practical
        String[] practicalsubjects = new String[2];
        int[] practicalMarks = new int[2];
        int practicaloutof = 25;
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter Practical Subject " + (i + 1) + ": ");
            practicalsubjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + practicalsubjects[i] + " (out of " + practicaloutof + "): ");
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= practicaloutof) {
                    practicalMarks[i] = marks;
                    break;
                } else {
                    System.out.println(FG_RED + "Invalid! Enter between 0 and " + practicaloutof + RESET);
                }
            }
            sc.nextLine();
        }

        // Calculation
        int totaltheory = 0, totalPractical = 0, failcount = 0;
        for (int marks : theoryMarks) {
            totaltheory += marks;
            if (marks < 33) failcount++;
        }
        for (int marks : practicalMarks) totalPractical += marks;

        int grandtotal = totaltheory + totalPractical;
        int totaloutof = (5 * theoryoutof) + (2 * practicaloutof);
        double percentage = (grandtotal * 100.0) / totaloutof;

        // Grade
        String grade;
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B+";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 50) grade = "D";
        else if (percentage >= 33) grade = "E";
        else grade = "F";

        // Remark
        String remark;
        if (failcount >= 3) remark = "Year Back";
        else if (failcount > 0) remark = "ATKT";
        else remark = "Pass";

        // ===================== PRINTING MARKSHEET ======================
        String border = makeBorder();

      //  System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
      System.out.println(BG_BLUE + FG_BLACK + BOLD +"--------------------------------------------------------------------------------"+RESET);
        System.out.println(BG_WHITE + FG_BLACK + BOLD + String.format("%-90s", collegename) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + BOLD+
                String.format("%-60s", coursename + " " + Specialization + " SEM-" + semester+" "+ "MAIN EXAMINATION, " + startmonth + " - " + endmonth+"      ") + RESET);
       // System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
           //     String.format("%-60s", "MAIN EXAMINATION, " + startmonth + " - " + endmonth) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_BRIGHT_GREEN + FG_BLACK +
                String.format("%-60s", "ENROLLMENT NO : " + Enrollmentno + "         NAME : " + studentName+"          ") + RESET);
        System.out.println(BG_BRIGHT_BLUE + FG_BLACK +
                String.format("%-60s", "ROLL NO : " + Rollno + "        STATUS : " + status+"           ") + RESET);
        System.out.println(BG_BRIGHT_GREEN + FG_BLACK +
                String.format("%-60s", "FATHER's NAME : " + fathername + "        MOTHER'S NAME : " + mothername+"          ") + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + border + RESET);

        System.out.println(BG_BRIGHT_YELLOW + FG_BLACK +
                String.format("%-20s %-20s %-20s %-15s", "SUBJECT", "OBTAINED", "TOTAL", "GRADE") + RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(BG_WHITE + FG_BLACK +
                    String.format("%-20s %-20d %-20d %-15s",
                            theorySubjects[i], theoryMarks[i], theoryoutof, grade) + RESET);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(BG_WHITE + FG_BLACK +
                    String.format("%-20s %-20d %-20d %-15s",
                            practicalsubjects[i], practicalMarks[i], practicaloutof, grade) + RESET);
        }

        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                String.format("%-20s %-20d %-20d", "TOTAL", grandtotal, totaloutof) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                String.format("PERCENTAGE : %.2f%%", percentage) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_CYAN +
                String.format("%-60s", "GRADE : " + grade) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                String.format("%-60s", "REMARK : " + remark) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_WHITE + FG_BLACK +
                String.format("%-60s", "HEAD OF DEPARTMENT                            PRINCIPAL") + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                String.format("%-60s", "NOTE: Computer Generated Marksheet. Contact Exam Dept. for Official Copy.") + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        sc.close();
    }
}
