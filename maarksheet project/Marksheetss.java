import java.util.Scanner;

class Subject {
    String subname;
    double marks;

    void getdata(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter " + i + " Subject Name : ");
        subname = sc.nextLine();
        System.out.print("Enter " + i + " Subject Marks : ");
        marks = sc.nextDouble();
    }

    void display() {
        System.out.printf("\u001B[47m\u001B[30m|   %-8s |    %-10s |    %-10s |    %-11.2f |\u001B[0m%n",
                subname, "TH", "100", marks);
    }
}

class Practical {
    String subname;
    int marks;

    void getdata(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter " + i + " Practical Subject Name : ");
        subname = sc.nextLine();
        System.out.print("Enter " + i + " Practical Subject Marks : ");
        marks = sc.nextInt();
    }

    void display() {
        System.out.printf("\u001B[47m\u001B[30m|   %-8s |    %-10s |    %-10s |    %-11d |\u001B[0m%n",
                subname, "PR", "25", marks);
    }
}

class Marksheetss {

    final static String WHITE_BG = "\u001B[47m";
    final static String BLACK_TEXT = "\u001B[30m";
    final static String RESET = "\u001B[0m";
    final static String CLEAR_SCREEN = "\u001B[2J";
    final static String CURSOR_HOME = "\u001B[H";
    final static String RED_TEXT = "\u001B[31m";
    final static String BLUE_TEXT = "\u001B[34m";
    final static String GREEN_TEXT = "\u001B[32m";
    final static String BLUE_BG = "\u001B[44m";
    final static String RED_BG = "\u001B[41m";
    final static String LITE_GREEN_BG = "\u001B[102m"; 

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int SMarkssum = 0;
        int PMarkssum = 0;

        System.out.println("=================== STUDENT MARKSHEET ===================");

        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();

        System.out.println("\nEnter Your Five Subjects:");
        Subject sub[] = new Subject[5];
        for (int i = 0; i < 5; i++) {
            sub[i] = new Subject();
            do {
                sub[i].getdata(i + 1);
                if (sub[i].marks >= 0 && sub[i].marks <= 100) {
                    SMarkssum += sub[i].marks;
                }
            } while (sub[i].marks < 0 || sub[i].marks > 100);

            if (sub[i].marks < 33) {
                count++;
            }
        }

        System.out.println("\nEnter Your Two Practical Subjects:");
        Practical pr[] = new Practical[2];
        for (int i = 0; i < 2; i++) {
            pr[i] = new Practical();
            do {
                pr[i].getdata(i + 1);
                if (pr[i].marks >= 0 && pr[i].marks <= 25) {
                    PMarkssum += pr[i].marks;
                }
            } while (pr[i].marks < 0 || pr[i].marks > 25);
        }

        System.out.print(CLEAR_SCREEN + CURSOR_HOME);

        System.out.println(WHITE_BG + BLACK_TEXT + "|=============================================================|" + RESET);
        System.out.println(BLUE_BG + BLACK_TEXT + "|          Govt.Holkar Science Collage,Indore (M.P.)          |" + RESET);
        System.out.println(BLUE_BG + RED_TEXT + "|                      Grade Sheet                            |" + RESET);
        System.out.println(BLUE_BG + BLACK_TEXT + "|         BCA IV SEMESTER MAIN EXAMINATION 2024-2025          |" + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + "|=============================================================|" + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + String.format("| %-30s %-28s |", "Student Name : " + name, "Course : BCA") + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + String.format("| %-30s %-28s |", "Roll No : 23465733", "Enrollment No : DX345533 ") + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + String.format("| %-30s %-28s |", "Father's Name : RAMLAL", "MOTHER NAME : RANI ") + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + "|-------------------------------------------------------------|" + RESET);
        System.out.println(BLUE_BG + BLACK_TEXT + String.format("|   %-8s |    %-10s |    %-10s |    %-11s |", "Subject", "Paper", "Out Of", "Obtained") + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + "|-------------------------------------------------------------|" + RESET);

        for (Subject s : sub) {
            s.display();
        }
        for (Practical p : pr) {
            p.display();
        }

        int ObtainedMarks = PMarkssum + SMarkssum;
        float percentage = (float) (ObtainedMarks) / 5.5f;

        System.out.println(WHITE_BG + BLACK_TEXT + "|========================= RESULT ============================|" + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + String.format("| %-19s %-9d %-19s %-9.2f |", "Total Marks:", ObtainedMarks, "Percentage:", percentage) + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + "===============================================================" + RESET);

        if (count >= 3) {
            .
            
            System.out.println(WHITE_BG + RED_TEXT + "| Remark:                                Year Back            |" + RESET);
        } else if (count == 1 || count == 2) {
            System.out.println(WHITE_BG + RED_TEXT + "| Remark:               " + count + " Subject ATKT            |" + RESET);
        } else {
            System.out.println(WHITE_BG + RED_TEXT + "| Remark:                                 Pass                |" + RESET);
        }

        if (percentage >= 90) {
            System.out.println(WHITE_BG + RED_TEXT + "| Grade:                                  A+                  |" + RESET);
        } else if (percentage >= 80) {
            System.out.println(WHITE_BG + RED_TEXT + "| Grade:                                  A                   |" + RESET);
        } else if (percentage >= 70) {
            System.out.println(WHITE_BG + RED_TEXT + "| Grade:                                  B+                  |" + RESET);
        } else if (percentage >= 60) {
            System.out.println(WHITE_BG + RED_TEXT + "| Grade:                                  B                   |" + RESET);
        } else if (percentage >= 50) {
            System.out.println(WHITE_BG + RED_TEXT + "| Grade:                                  C                   |" + RESET);
        } else if (percentage >= 33) {
            System.out.println(WHITE_BG + RED_TEXT + "| Grade:                                  D                   |" + RESET);
        } else {
            System.out.println(WHITE_BG + RED_TEXT + "| Grade:                                  Fail                |" + RESET);
        }

        System.out.println(WHITE_BG + BLACK_TEXT + "|=============================================================|" + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + String.format("| %-30s %-28s |", "Principle:", "Suresh H Silawat ") + RESET);
        System.out.println(WHITE_BG + GREEN_TEXT + "| Promoted to year 3                                          |" + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + "|=============================================================|" + RESET);
        System.out.println(BLUE_BG + "|   `                                                          |" + RESET);
        System.out.println(BLUE_BG + "|                                                             |" + RESET);
        System.out.println(WHITE_BG + BLACK_TEXT + "|=============================================================|" + RESET);
    }
}