  /*  import java.util.Scanner;

    public class Q02{
        
        public static final String RESET = "\u001B[0m";   //reset the value 
        public static final String BG_WHITE = "\u001B[47m"; // White background
        public static final String FG_BLACK = "\u001B[30m"; // Black text
        public static final String FG_RED = "\u001B[31m";//red 
        public static final String FG_GREEN = "\u001B[32m";//green 
        public static final String FG_YELLOW = "\u001B[33m";//yellow
        public static final String FG_CYAN = "\u001B[36m";//cyan
        public static final String FG_MAGENTA = "\u001B[35m";//magneta 
        // public static final String BG_BRIGHT_BLUE = "\u001B[104m";
        // public static final String BG_BRIGHT_GREEN = "\u001B[107m";
        public static final String BG_BLUE = "\u001B[44m";   
        public static final String BOLD = "\u001B[1m";
        public  static final String BG_BRIGHT_BLACK = "\u001B[100m";   // Light Black (Gray)
        public static final String BG_BRIGHT_RED = "\u001B[101m";     // Light Red
        public static final String BG_BRIGHT_GREEN = "\u001B[102m";   // Light Green
        public static final String BG_BRIGHT_YELLOW = "\u001B[103m";  // Light Yellow
        public static final String BG_BRIGHT_BLUE = "\u001B[104m";    // Light Blue
        public static final String BG_BRIGHT_MAGENTA = "\u001B[105m"; // Light Magenta
        public static final String BG_BRIGHT_CYAN = "\u001B[106m";    // Light Cyan
        public static final String BG_BRIGHT_WHITE = "\u001B[107m";   // Light White (Bright White)


        public static void main(String args[]){
            Scanner sc = new Scanner(System.in );
            
            //College name
            String collegename = "GOVT. HOLKAR(MODAL,AUTONOMOUS) SCIENCE COLLEGE,INDORE "; 
            
            //Student information

            
            System.out.print("Enter a Start of exam month year :");
            String startmonth  = sc.nextLine();


            System.out.print("Enter a End of Exam month year  :");
            String endmonth   = sc.nextLine();



            System.out.print("Enter a Semester :");
            String semester  = sc.nextLine();


            System.out.print("Enter Student Name :");
            String studentName = sc.nextLine();

            System.out.print("Enter a Roll no :");
            String Rollno = sc.nextLine();

            System.out.print("Enter a Course Name :");
            String classname = sc.nextLine();

            System.out.print("Enter a Father  name :");
            String fathername  = sc.nextLine();

            System.out.print("Enter a mother name :");
            String mothername  = sc.nextLine();

            System.out.print("Enter a Status of Student (Regular/ Private ):");
            String status  = sc.nextLine();

            System.out.print("Enter a Enrollment  no :");
            String Enrollmentno = sc.nextLine();


            System.out.print("Enter a Course Name:");
            String coursename = sc.nextLine();
            
            
            
            //Theory Subject of student have 
            String[] theorySubjects = new String[5];
            int[] theoryMarks = new int[5];
            int theoryoutof = 100;

            for(int i = 0 ; i<5; i++){
                System.out.println("Enter Theory Subject :");
                theorySubjects[i]=sc.nextLine();

                while(true){
                    System.out.print("Enter marks in "+theorySubjects[i]+"(out of ) "+ theoryoutof+ "):");
                    int marks = sc.nextInt();
                    if(marks >= 0 && marks<= theoryoutof ){
                        break ; 

                    } else {
                        System.out.print(FG_RED + "Invalid! Enter between 0 and " + theoryoutof );

                    }
                
                    
                }
                sc.nextLine();
                
            }

            //Practical subject 
            String[] practicalsubjects = new String[5];
            int[] practicalMarks = new int[2];
            int practicaloutof = 25;
            for(int i = 0 ; i<2;i++){
                System.out.print("enter a Practical Subject " +(i+1)+":");
                practicalsubjects[i] = sc.nextLine();


                while(true){
            System.out.print("Enter marks in " + practicalsubjects[i] + " (out of " + practicaloutof + "): ");
                    int marks = sc.nextInt();
                    if (marks >= 0 && marks <= practicaloutof) {
                        practicalMarks[i] = marks;
                        break;
                    } else {
                        System.out.println(FG_RED + "Invalid! Enter between 0 and " + practicaloutof);
                    }
                
                }
                sc.nextLine();

            }
            //total kro 
    int  totaltheory = 0;
    int  totalPractical = 0 ; 
    int failcount = 0 ;
            for(int marks :theoryMarks){
                totaltheory = totaltheory + marks ; 
                if (marks <33 )failcount++;

            }
            for (int marks : practicalMarks) {
                totalPractical = totalPractical + marks ;
        }
        int grandtotal = totaltheory + totalPractical ; 
        int totaloutof = (5*theoryoutof ) + (2*practicaloutof);
        double percentage = (grandtotal * 100 )/totaloutof;



        //grade  
        String grade ;
            if(percentage >=90) grade = "A+";
            else if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B+";
            else if (percentage >= 60) grade = "C";
            else if (percentage >= 50) grade = "D";
            else if (percentage >= 33) grade = "E";
            else grade = "F";

            //Remark 
            String  remark ;
            if(failcount >=3) remark = "Year Back ";
            else if (failcount > 0) remark = "ATKT";
            else remark = "Pass";

            //Output of marksheet priinting 

            System.out.println(BG_WHITE + FG_BLACK + BOLD+"                  "+ collegename+"        "+RESET);
            System.out.println(  BG_BLUE + FG_BLACK + BOLD"--------------------------------OFFICIAL MARKSHEET-----------------------------         "+RESET);
            System.out.println(BG_WHITE + FG_BLACK + coursename+" "+semester+ " "+" "+"MAIN EXAMINATION," +startmonth+ " " +endmonth+RESET   );
            System.out.println(BG_WHITE +BG_BRIGHT_GREEN + FG_BLACK+" "+"ENROLLMENT NO :   "+Enrollmentno +"                "+ "NAME:          "+studentName+RESET);
            System.out.println(BG_WHITE +BG_BRIGHT_BLUE + FG_BLACK+ "RoLL NO :      "+Rollno +"                 "+"STATUS :   " +status+RESET);
            System.out.println(BG_BRIGHT_GREEN + FG_BLACK + "FATHER's NAMe :            "+fathername +"            "+"MOTHER'S NAME :         " +mothername + RESET);
            System.out.println(BG_BRIGHT_WHITE"-----------------------------------------------------------------------------------------------------------------------------------")
            System.out.println(BG_BRIGHT_YELLOW +FG_BLACK+"               SUBJECT               "+"MARKS OBTAINED "+"               " + "TOTAL MARKS "+"               " +"GRADE"+RESET );
            for (int i = 0; i < 5; i++) {
                System.out.println(BG_WHITE + FG_BLACK + String.format("%-15s %3d %10d", theorySubjects[i], theoryMarks[i], theoryoutof,grade)                    );
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(BG_WHITE + FG_BLACK + String.format("%-15s %3d %10d", practicalsubjects[i], practicaloutof, practicalMarks[i],grade, +RESET)                      );
                    }
                        System.out.println(BG_WHITE + FG_BLACK + "----------------------------------------------------------------------------------------------------------------------"                     + RESEt );
                        System.out.println(BG_BRIGHT_WHITE +FG_BLACK +"%-15%"+"Total"+grandtotal + "%3d" totaloutof ,+RESET );
                        System.out.println(BG_BRIGHT_WHITE +FG_BLACK +percentage, +RESET);
                        System.out.println(BG_BRIGHT_WHITE +FG_CYAN +grade,+RESET);
                        System.out.println(BG_WHITE + FG_BLACK + "Remark: " + remark ,+RESET                      );
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------"+RESET);
                         System.out.println(BG_WHITE + FG_BLACK + " HEAD OF DEPARTMENT "+"                                                                          "+ "PRINCIPAL "+RESET);
                         System.out.println(BG_WHITE + FG_BLACK +"These Are Computer Generated Marks. It Cannot Be Used As Official Mark. In Case Of Discrepancy Please Contact Examination Department.Final Marksheet Will Be Issued Later on In Hard-Copy"+RESET);




                    


    }
    }
    */
  /* import java.util.Scanner;

public class Q02 {

    public static final String RESET = "\u001B[0m";   // reset
    public static final String BG_WHITE = "\u001B[47m"; // White background
    public static final String FG_BLACK = "\u001B[30m"; // Black text
    public static final String FG_RED = "\u001B[31m"; // red 
    public static final String FG_GREEN = "\u001B[32m"; // green 
    public static final String FG_YELLOW = "\u001B[33m"; // yellow
    public static final String FG_CYAN = "\u001B[36m"; // cyan
    public static final String FG_MAGENTA = "\u001B[35m"; // magenta 
    public static final String BG_BLUE = "\u001B[44m";   
    public static final String BOLD = "\u001B[1m";
    public static final String BG_BRIGHT_GREEN = "\u001B[102m";  // Light Green
    public static final String BG_BRIGHT_BLUE = "\u001B[104m";   // Light Blue
    public static final String BG_BRIGHT_WHITE = "\u001B[107m";  // Bright White
    public static final String BG_BRIGHT_YELLOW = "\u001B[103m"; // Light Yellow

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // College name
        String collegename = "GOVT. HOLKAR(MODAL,AUTONOMOUS) SCIENCE COLLEGE, INDORE";

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

        System.out.print("Enter class name  Name: ");
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

        // Theory Subjects and marks
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
            sc.nextLine(); // consume newline
        }

        // Practical Subjects and marks
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
            sc.nextLine(); // consume newline
        }

        // Calculations
        int totaltheory = 0;
        int totalPractical = 0;
        int failcount = 0;

        for (int marks : theoryMarks) {
            totaltheory += marks;
            if (marks < 33) failcount++;
        }
        for (int marks : practicalMarks) {
            totalPractical += marks;
        }
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

        // Print marksheet
        System.out.println(BG_WHITE + FG_BLACK + BOLD + "                   " + collegename + "       " + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + "--------------------------------OFFICIAL MARKSHEET-----------------------------         " + RESET);
        System.out.println(BG_WHITE + FG_BLACK + coursename+Specialization + " " + semester + "  MAIN EXAMINATION, " + startmonth + " " + endmonth + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + "------------------------------------------------------------"+RESET);
        System.out.println(BG_WHITE + BG_BRIGHT_GREEN + FG_BLACK + " ENROLLMENT NO : " + Enrollmentno + "                 NAME: " + studentName + RESET);
        System.out.println(BG_WHITE + BG_BRIGHT_BLUE + FG_BLACK + " ROLL NO : " + Rollno + "                     STATUS : " + status + RESET);
        System.out.println(BG_BRIGHT_GREEN + FG_BLACK + " FATHER's NAME : " + fathername + "                  MOTHER'S NAME : " + mothername + RESET);
        System.out.println(BG_BRIGHT_WHITE + "-----------------------------------------------------------------------------------------------------------------------------------" + RESET);
        System.out.println(BG_BRIGHT_YELLOW + FG_BLACK + "       SUBJECT             MARKS OBTAINED             TOTAL MARKS             GRADE" + RESET);

        // Print theory marks
        for (int i = 0; i < 5; i++) {
            System.out.println(BG_WHITE + FG_BLACK + String.format("%-20s %5d %25d %15s", theorySubjects[i], theoryMarks[i], theoryoutof, grade) + RESET);
        }

        // Print practical marks
        for (int i = 0; i < 2; i++) {
            System.out.println(BG_WHITE + FG_BLACK + String.format("%-20s %5d %25d %15s", practicalsubjects[i], practicalMarks[i], practicaloutof, grade) + RESET);
        }

        System.out.println(BG_WHITE + FG_BLACK + "----------------------------------------------------------------------------------------------------------------------" + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("%-20s %5d %25d", "Total", grandtotal, totaloutof) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("Percentage: %.2f%%", percentage) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_CYAN + "Grade: " + grade + RESET);
        System.out.println(BG_WHITE + FG_BLACK + "Remark: " + remark + RESET);
        System.out.println(BG_WHITE + FG_BLACK +"-----------------------------------------------------------------------------------------------------------------------------------" + RESET);
        System.out.println(BG_WHITE + FG_BLACK + " HEAD OF DEPARTMENT                                                     PRINCIPAL " + RESET);
        System.out.println(BG_WHITE + FG_BLACK + "These Are Computer Generated Marks. It Cannot Be Used As Official Mark. In Case Of Discrepancy Please Contact Examination Department. Final Marksheet Will Be Issued Later on In Hard-Copy" + RESET);

        sc.close();
    }
}


*/
/*
import java.util.Scanner;

public class Q02 {

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
        String border = "---------------------------------------------------------------------------------------------------";

        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_WHITE + FG_BLACK + BOLD + String.format("%80s", collegename) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format( coursename + " " + Specialization + " SEM-" + semester) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("%60s", "MAIN EXAMINATION, " + startmonth + " - " + endmonth) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_BRIGHT_GREEN + FG_BLACK + " ENROLLMENT NO : " + Enrollmentno + "         NAME : " + studentName + RESET);
        System.out.println(BG_BRIGHT_BLUE + FG_BLACK + " ROLL NO : " + Rollno + "        STATUS : " + status + RESET);
        System.out.println(BG_BRIGHT_GREEN + FG_BLACK + " FATHER's NAME : " + fathername + "        MOTHER'S NAME : " + mothername + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + border + RESET);

        System.out.println(BG_BRIGHT_YELLOW + FG_BLACK + String.format("%-20s %-20s %-20s %-15s", "SUBJECT", "OBTAINED", "TOTAL", "GRADE") + RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(BG_WHITE + FG_BLACK + String.format("%-20s %-20d %-20d %-15s", theorySubjects[i], theoryMarks[i], theoryoutof, grade) + RESET);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(BG_WHITE + FG_BLACK + String.format("%-20s %-20d %-20d %-15s", practicalsubjects[i], practicalMarks[i], practicaloutof, grade) + RESET);
        }

        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("%-20s %-20d %-20d", "TOTAL", grandtotal, totaloutof)  + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + " PERCENTAGE : " + String.format("%.2f", percentage) + "%" + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_CYAN + " GRADE : " + grade + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + " REMARK : " + remark + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_WHITE + FG_BLACK + " HEAD OF DEPARTMENT                            PRINCIPAL " + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + " NOTE: Computer Generated Marksheet. Contact Exam Dept. for Official Copy." + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        sc.close();
    }
}
*/
/*
import java.util.Scanner;

public class Q02 {

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

    // Fixed width for square shape
    public static final int WIDTH = 100;

    // Function to format with fixed background width
    public static String box(String text, String bg, String fg) {
        return bg + fg + String.format("%-" + WIDTH + "s", text) + RESET;
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
        String border = "-".repeat(WIDTH);

        System.out.println(box(border, BG_BLUE, FG_BLACK));
        System.out.println(box(collegename, BG_WHITE, FG_BLACK));
        System.out.println(box(border, BG_BLUE, FG_BLACK));
        System.out.println(box(coursename + " " + Specialization + " SEM-" + semester, BG_BRIGHT_WHITE, FG_BLACK));
        System.out.println(box("MAIN EXAMINATION, " + startmonth + " - " + endmonth, BG_BRIGHT_WHITE, FG_BLACK));
        System.out.println(box(border, BG_BLUE, FG_BLACK));

        System.out.println(box("ENROLLMENT NO : " + Enrollmentno + "    NAME : " + studentName, BG_BRIGHT_GREEN, FG_BLACK));
        System.out.println(box("ROLL NO : " + Rollno + "    STATUS : " + status, BG_BRIGHT_BLUE, FG_BLACK));
        System.out.println(box("FATHER's NAME : " + fathername + "    MOTHER'S NAME : " + mothername, BG_BRIGHT_GREEN, FG_BLACK));
        System.out.println(box(border, BG_BRIGHT_WHITE, FG_BLACK));

        System.out.println(box(String.format("%-20s %-15s %-15s %-10s", "SUBJECT", "OBTAINED", "TOTAL", "GRADE"), BG_BRIGHT_YELLOW, FG_BLACK));

        for (int i = 0; i < 5; i++) {
            System.out.println(box(String.format("%-20s %-15d %-15d %-10s", theorySubjects[i], theoryMarks[i], theoryoutof, grade), BG_WHITE, FG_BLACK));
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(box(String.format("%-20s %-15d %-15d %-10s", practicalsubjects[i], practicalMarks[i], practicaloutof, grade), BG_WHITE, FG_BLACK));
        }

        System.out.println(box(border, BG_BLUE, FG_BLACK));
        System.out.println(box(String.format("%-20s %-15d %-15d", "TOTAL", grandtotal, totaloutof), BG_BRIGHT_WHITE, FG_BLACK));
        System.out.println(box("PERCENTAGE : " + String.format("%.2f", percentage) + "%", BG_BRIGHT_WHITE, FG_BLACK));
        System.out.println(box("GRADE : " + grade, BG_BRIGHT_WHITE, FG_CYAN));
        System.out.println(box("REMARK : " + remark, BG_BRIGHT_WHITE, FG_BLACK));
        System.out.println(box(border, BG_BLUE, FG_BLACK));

        System.out.println(box("HEAD OF DEPARTMENT                   PRINCIPAL", BG_WHITE, FG_BLACK));
        System.out.println(box("NOTE: Computer Generated Marksheet. Contact Exam Dept. for Official Copy.", BG_BRIGHT_WHITE, FG_BLACK));
        System.out.println(box(border, BG_BLUE, FG_BLACK));

        sc.close();
    }
}
*/
import java.util.Scanner;

public class Q02 {

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
        System.out.println(BG_WHITE + FG_BLACK + BOLD + String.format("%-" +  "s", collegename) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("%-"  "s",
                coursename + " " + Specialization + " SEM-" + semester) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + String.format("%-" + "s",
                "MAIN EXAMINATION, " + startmonth + " - " + endmonth) + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_BRIGHT_GREEN + FG_BLACK + String.format("%-" + "s",
                "ENROLLMENT NO : " + Enrollmentno + "         NAME : " + studentName) + RESET);
        System.out.println(BG_BRIGHT_BLUE + FG_BLACK + String.format("%-" +  "s",
                "ROLL NO : " + Rollno + "        STATUS : " + status) + RESET);
        System.out.println(BG_BRIGHT_GREEN + FG_BLACK + String.format("%-" + "s",
                "FATHER's NAME : " + fathername + "        MOTHER'S NAME : " + mothername) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +  border + RESET);

        System.out.println(BG_BRIGHT_YELLOW + FG_BLACK +
                String.format("%-20s %-20s %-20s %-15s", "SUBJECT", "OBTAINED", "TOTAL", "GRADE") + RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(BG_WHITE + FG_BLACK +
                    String.format("%-20s %-20d %-20d %-15s",
                            theorySubjects[i], theoryMarks[i], theoryoutof, grade) + RESET);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(BG_WHITE + FG_BLACK + WIDTH+
                    String.format("%-20s %-20d %-20d %-15s",
                            practicalsubjects[i], practicalMarks[i], practicaloutof, grade) + RESET);
        }

        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + 
                String.format("%-20s %-20d %-20d", "TOTAL", grandtotal, totaloutof) + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                " PERCENTAGE : " + String.format("%.2f", percentage) + "%" + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_CYAN +WIDTH+ " GRADE : " + grade + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK + WIDTH" REMARK : " + remark + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        System.out.println(BG_WHITE + FG_BLACK +
                String.format("%-60" "s", "HEAD OF DEPARTMENT                            PRINCIPAL") + RESET);
        System.out.println(BG_BRIGHT_WHITE + FG_BLACK +
                String.format("%-60s", "NOTE: Computer Generated Marksheet. Contact Exam Dept. for Official Copy.") + RESET);
        System.out.println(BG_BLUE + FG_BLACK + BOLD + border + RESET);

        sc.close();
    }
}
