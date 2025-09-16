/*
Q2. Marksheet Generator (Console Application)
Create a console application that generates a colored marksheet.

Inputs:
1. Ask for 5 theory subjects:
Subject names

Out of marks (enter once for all theory subjects; fixed at 100)
Marks obtained in each theory subject

2. Ask for 2 practical subjects:
Practical names
Out o marks (enter once for all practicals; fixed at 25)
Marks obtained in each practical subject


Validation:
If the user enters marks < 0 or > out-of (i.e., >100 for theory, >25 for practical), 
re-prompt only for that subject until valid.

Processing & Rules:
Count how many theory subjects have marks < 33.
If the count is ≥ 3, remark = Year Back
Else if the count is > 0 and < 3, remark = ATKT
Else remark = Pass

Compute totals, percentage, and overall grade based on percentage:
A+ (≥90), A (80–89), B+ (70–79), B (60–69), C (50–59), D (40–33), F (<33)

Output (Console):
Print a marksheet with:
Proper headings and sectioning
A table for theory and practical marks (Name, Out Of, Obtained)
Totals, percentage, grade, remark
Background and foreground colors to give an official marksheet
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Class to handle ANSI color codes for terminal formatting
class Colors {
    // Text Colors
    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";
    
    // Bright Text Colors
    public static final String BRIGHT_BLACK = "\033[90m";
    public static final String BRIGHT_RED = "\033[91m";
    public static final String BRIGHT_GREEN = "\033[92m";
    public static final String BRIGHT_YELLOW = "\033[93m";
    public static final String BRIGHT_BLUE = "\033[94m";
    public static final String BRIGHT_MAGENTA = "\033[95m";
    public static final String BRIGHT_CYAN = "\033[96m";
    public static final String BRIGHT_WHITE = "\033[97m";
    
    // Background Colors
    public static final String BG_BLACK = "\033[40m";
    public static final String BG_RED = "\033[41m";
    public static final String BG_GREEN = "\033[42m";
    public static final String BG_YELLOW = "\033[43m";
    public static final String BG_BLUE = "\033[44m";
    public static final String BG_MAGENTA = "\033[45m";
    public static final String BG_CYAN = "\033[46m";
    public static final String BG_WHITE = "\033[47m";
    
    // Bright Background Colors
    public static final String BG_BRIGHT_BLACK = "\033[100m";
    public static final String BG_BRIGHT_RED = "\033[101m";
    public static final String BG_BRIGHT_GREEN = "\033[102m";
    public static final String BG_BRIGHT_YELLOW = "\033[103m";
    public static final String BG_BRIGHT_BLUE = "\033[104m";
    public static final String BG_BRIGHT_MAGENTA = "\033[105m";
    public static final String BG_BRIGHT_CYAN = "\033[106m";
    public static final String BG_BRIGHT_WHITE = "\033[107m";
    
    // Text Styling
    public static final String BOLD = "\033[1m";
    public static final String UNDERLINE = "\033[4m";
    public static final String REVERSE = "\033[7m";
    
    // Reset
    public static final String RESET = "\033[0m";
}

// Class to represent a subject
class Subject {
    private String name;
    private int maxMarks;
    private double obtainedMarks;
    
    public Subject(String name, int maxMarks, double obtainedMarks) {
        this.name = name;
        this.maxMarks = maxMarks;
        this.obtainedMarks = obtainedMarks;
    }
    
    
    // Getters
    public String getName() { return name; }
    public int getMaxMarks() { return maxMarks; }
    public double getObtainedMarks() { return obtainedMarks; }
    
    // Check if subject is passed (33% minimum)
    public boolean isPassed() {
        return obtainedMarks >= (maxMarks * 0.33);
    }
}

// Class to represent student information
class Student {
    private String name;
    private String rollNo;
    private String className;
    
    public Student(String name, String rollNo, String className) {
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
    }
    
    // Getters
    public String getName() { return name; }
    public String getRollNo() { return rollNo; }
    public String getClassName() { return className; }
}

// Grade class to hold grade and its color
class Grade {
    private String grade;
    private String color;
    
    public Grade(String grade, String color) {
        this.grade = grade;
        this.color = color;
    }
    
    public String getGrade() { return grade; }
    public String getColor() { return color; }
}

// Remark class to hold remark and its color
class Remark {
    private String remark;
    private String color;
    
    public Remark(String remark, String color) {
        this.remark = remark;
        this.color = color;
    }
    
    public String getRemark() { return remark; }
    public String getColor() { return color; }
}

public class marksheet {
    private static Scanner scanner = new Scanner(System.in);
    
    // Method to clear screen (works on most terminals)
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[2J\033[H");
            }
        } catch (Exception e) {
            // If clearing doesn't work, just print new lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    // Method to get valid marks with validation
    public static double getValidMarks(String subjectName, int maxMarks) {
        while (true) {
            try {
                System.out.print("Enter marks for " + Colors.CYAN + subjectName + Colors.RESET + 
                               " (out of " + maxMarks + "): ");
                double marks = Double.parseDouble(scanner.nextLine());
                
                if (marks < 0 || marks > maxMarks) {
                    System.out.println(Colors.RED + " Invalid! Marks must be between 0 and " + 
                                     maxMarks + ". Please try again." + Colors.RESET);
                    continue;
                }
                return marks;
            } catch (NumberFormatException e) {
                System.out.println(Colors.RED + " Invalid! Please enter a valid number." + Colors.RESET);
            }
        }
    }
    
    // Method to get student information
    public static Student getStudentInfo() {
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "============================================================" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "           STUDENT INFORMATION ENTRY                       " + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "============================================================" + Colors.RESET);
        
        System.out.print("\n" + Colors.BOLD + "Enter Student Name: " + Colors.RESET);
        String name = scanner.nextLine().trim();
        
        System.out.print(Colors.BOLD + "Enter Roll Number: " + Colors.RESET);
        String rollNo = scanner.nextLine().trim();
        
        System.out.print(Colors.BOLD + "Enter Class: " + Colors.RESET);
        String className = scanner.nextLine().trim();
        
        return new Student(name, rollNo, className);
    }
    
    // Method to get theory subjects
    public static List<Subject> getTheorySubjects() {
        System.out.println("\n" + Colors.BOLD + Colors.BG_GREEN + Colors.WHITE + 
                          "============================================================" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_GREEN + Colors.WHITE + 
                          "              THEORY SUBJECTS (5)                          " + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_GREEN + Colors.WHITE + 
                          "============================================================" + Colors.RESET);
        System.out.println(Colors.YELLOW + "Note: All theory subjects are out of 100 marks" + Colors.RESET + "\n");
        
        List<Subject> theorySubjects = new ArrayList<>();
        
        // Get subject names
        System.out.println(Colors.BOLD + Colors.UNDERLINE + "Enter Theory Subject Names:" + Colors.RESET);
        for (int i = 1; i <= 5; i++) {
            System.out.print("Theory Subject " + i + ": ");
            String subjectName = scanner.nextLine().trim();
            theorySubjects.add(new Subject(subjectName, 100, 0));
        }
        
        System.out.println("\n" + Colors.BOLD + Colors.UNDERLINE + "Enter Marks for Theory Subjects:" + Colors.RESET);
        // Get marks for each subject
        for (int i = 0; i < theorySubjects.size(); i++) {
            Subject subject = theorySubjects.get(i);
            double marks = getValidMarks(subject.getName(), subject.getMaxMarks());
            theorySubjects.set(i, new Subject(subject.getName(), subject.getMaxMarks(), marks));
        }
        
        return theorySubjects;
    }
    
    // Method to get practical subjects
    public static List<Subject> getPracticalSubjects() {
        System.out.println("\n" + Colors.BOLD + Colors.BG_MAGENTA + Colors.WHITE + 
                          "============================================================" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_MAGENTA + Colors.WHITE + 
                          "             PRACTICAL SUBJECTS (2)                        " + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_MAGENTA + Colors.WHITE + 
                          "============================================================" + Colors.RESET);
        System.out.println(Colors.YELLOW + "Note: All practical subjects are out of 25 marks" + Colors.RESET + "\n");
        
        List<Subject> practicalSubjects = new ArrayList<>();
        
        // Get subject names
        System.out.println(Colors.BOLD + Colors.UNDERLINE + "Enter Practical Subject Names:" + Colors.RESET);
        for (int i = 1; i <= 2; i++) {
            System.out.print("Practical Subject " + i + ": ");
            String subjectName = scanner.nextLine().trim();
            practicalSubjects.add(new Subject(subjectName, 25, 0));
        }
        
        System.out.println("\n" + Colors.BOLD + Colors.UNDERLINE + "Enter Marks for Practical Subjects:" + Colors.RESET);
        // Get marks for each subject
        for (int i = 0; i < practicalSubjects.size(); i++) {
            Subject subject = practicalSubjects.get(i);
            double marks = getValidMarks(subject.getName(), subject.getMaxMarks());
            practicalSubjects.set(i, new Subject(subject.getName(), subject.getMaxMarks(), marks));
        }
        
        return practicalSubjects;
    }
    
    // Method to calculate grade based on percentage
    public static Grade calculateGrade(double percentage) {
        if (percentage >= 90) {
            return new Grade("A+", Colors.BRIGHT_GREEN);
        } else if (percentage >= 80) {
            return new Grade("A", Colors.GREEN);
        } else if (percentage >= 70) {
            return new Grade("B+", Colors.CYAN);
        } else if (percentage >= 60) {
            return new Grade("B", Colors.BLUE);
        } else if (percentage >= 50) {
            return new Grade("C", Colors.YELLOW);
        } else if (percentage >= 33) {
            return new Grade("D", Colors.MAGENTA);
        } else {
            return new Grade("F", Colors.RED);
        }
    }
    
    // Method to calculate remark based on theory subjects performance
    public static Remark calculateRemark(List<Subject> theorySubjects) {
        int failedCount = 0;
        for (Subject subject : theorySubjects) {
            if (subject.getObtainedMarks() < 33) {
                failedCount++;
            }
        }
        
        if (failedCount >= 3) {
            return new Remark("Year Back", Colors.BRIGHT_RED);
        } else if (failedCount > 0) {
            return new Remark("ATKT", Colors.YELLOW);
        } else {
            return new Remark("Pass", Colors.BRIGHT_GREEN);
        }
    }
    
    // Method to print the complete formatted marksheet
    public static void printMarksheet(Student student, List<Subject> theorySubjects, List<Subject> practicalSubjects) {
        clearScreen();
        
        // Calculate totals
        double theoryTotalObtained = theorySubjects.stream().mapToDouble(Subject::getObtainedMarks).sum();
        int theoryTotalMax = theorySubjects.stream().mapToInt(Subject::getMaxMarks).sum();
        
        double practicalTotalObtained = practicalSubjects.stream().mapToDouble(Subject::getObtainedMarks).sum();
        int practicalTotalMax = practicalSubjects.stream().mapToInt(Subject::getMaxMarks).sum();
        
        double grandTotalObtained = theoryTotalObtained + practicalTotalObtained;
        int grandTotalMax = theoryTotalMax + practicalTotalMax;
        
        double percentage = (grandTotalObtained / grandTotalMax) * 100;
        Grade grade = calculateGrade(percentage);
        Remark remark = calculateRemark(theorySubjects);
        
        // Header
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "================================================================================");
        System.out.println("                              ST. MARY'S HIGH SCHOOL                              ");
        System.out.println("                                ACADEMIC MARKSHEET                                ");
        System.out.println("================================================================================" + Colors.RESET);
        
        // Student Information
        System.out.println("\n" + Colors.BOLD + Colors.BG_CYAN + Colors.BLACK + 
                          "                              STUDENT INFORMATION                              " + Colors.RESET);
        System.out.printf(Colors.BOLD + "Name: " + Colors.BRIGHT_WHITE + "%-25s " + Colors.RESET + 
                         Colors.BOLD + "Roll No: " + Colors.BRIGHT_WHITE + "%-15s " + Colors.RESET + 
                         Colors.BOLD + "Class: " + Colors.BRIGHT_WHITE + "%s" + Colors.RESET + "\n", 
                         student.getName(), student.getRollNo(), student.getClassName());
        System.out.println(Colors.BRIGHT_BLACK + "────────────────────────────────────────────────────────────────────────────────" + Colors.RESET);
        
        // Theory Subjects Table
        System.out.println("\n" + Colors.BOLD + Colors.BG_GREEN + Colors.WHITE + 
                          "                              THEORY SUBJECTS                                 " + Colors.RESET);
        System.out.printf(Colors.BOLD + "%-30s %12s %12s %12s" + Colors.RESET + "\n", 
                         "Subject Name", "Max Marks", "Obtained", "Status");
        System.out.println(Colors.BRIGHT_BLACK + "────────────────────────────────────────────────────────────────────────────────" + Colors.RESET);
        
        for (Subject subject : theorySubjects) {
            String status = subject.getObtainedMarks() >= 33 ? 
                           Colors.GREEN + "Pass" + Colors.RESET : 
                           Colors.RED + "Fail" + Colors.RESET;
            System.out.printf(Colors.CYAN + "%-30s" + Colors.RESET + " %12d " + Colors.BOLD + "%12.1f" + Colors.RESET + " %12s\n",
                             subject.getName(), subject.getMaxMarks(), subject.getObtainedMarks(), status);
        }
        
        System.out.println(Colors.BRIGHT_BLACK + "────────────────────────────────────────────────────────────────────────────────" + Colors.RESET);
        System.out.printf(Colors.BOLD + "%-30s %12d " + Colors.BRIGHT_YELLOW + "%12.1f" + Colors.RESET + " %12s\n",
                         "Theory Total:", theoryTotalMax, theoryTotalObtained, "");
        
        // Practical Subjects Table
        System.out.println("\n" + Colors.BOLD + Colors.BG_MAGENTA + Colors.WHITE + 
                          "                             PRACTICAL SUBJECTS                               " + Colors.RESET);
        System.out.printf(Colors.BOLD + "%-30s %12s %12s %12s" + Colors.RESET + "\n", 
                         "Subject Name", "Max Marks", "Obtained", "Status");
        System.out.println(Colors.BRIGHT_BLACK + "────────────────────────────────────────────────────────────────────────────────" + Colors.RESET);
        
        for (Subject subject : practicalSubjects) {
            String status = subject.getObtainedMarks() >= 13 ? // 50% of 25
                           Colors.GREEN + "Pass" + Colors.RESET : 
                           Colors.RED + "Fail" + Colors.RESET;
            System.out.printf(Colors.CYAN + "%-30s" + Colors.RESET + " %12d " + Colors.BOLD + "%12.1f" + Colors.RESET + " %12s\n",
                             subject.getName(), subject.getMaxMarks(), subject.getObtainedMarks(), status);
        }
        
        System.out.println(Colors.BRIGHT_BLACK + "────────────────────────────────────────────────────────────────────────────────" + Colors.RESET);
        System.out.printf(Colors.BOLD + "%-30s %12d " + Colors.BRIGHT_YELLOW + "%12.1f" + Colors.RESET + " %12s\n",
                         "Practical Total:", practicalTotalMax, practicalTotalObtained, "");
        
        // Grand Total and Results
        System.out.println("\n" + Colors.BOLD + Colors.BG_YELLOW + Colors.BLACK + 
                          "                               OVERALL RESULTS                                " + Colors.RESET);
        System.out.println(Colors.BRIGHT_BLACK + Colors.RESET);
        System.out.printf(Colors.BOLD + "%-30s " + Colors.BRIGHT_WHITE + "%12d " + Colors.BRIGHT_CYAN + "%12.1f" + Colors.RESET + "\n",
                         "GRAND TOTAL:", grandTotalMax, grandTotalObtained);
        System.out.printf(Colors.BOLD + "%-30s %12s " + Colors.BRIGHT_CYAN + "%11.2f%%" + Colors.RESET + "\n",
                         "PERCENTAGE:", "", percentage);
        System.out.printf(Colors.BOLD + "%-30s %12s " + grade.getColor() + Colors.BOLD + "%12s" + Colors.RESET + "\n",
                         "GRADE:", "", grade.getGrade());
        System.out.printf(Colors.BOLD + "%-30s %12s " + remark.getColor() + Colors.BOLD + "%12s" + Colors.RESET + "\n",
                         "REMARK:", "", remark.getRemark());
        
        
        // Footer
        System.out.println("\n" + Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "Grade Scale: A+ (90+) | A (80-89) | B+ (70-79) | B (60-69) | C (50-59) | D (33-49) | F (<33)" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "                              Principal Signature                              " + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "================================================================================" + Colors.RESET);
    }
    
    // Main method
    public static void main(String[] args) {
        try {
            // Welcome message
            clearScreen();
            System.out.println(Colors.BOLD + Colors.BG_CYAN + Colors.WHITE + 
                              "************************************************************");
            System.out.println("         WELCOME TO MARKSHEET GENERATOR         ");
            System.out.println("************************************************************" + Colors.RESET);
            
            System.out.print("\n" + Colors.YELLOW + "Press Enter to continue..." + Colors.RESET);
            scanner.nextLine();
            
            // Get all required information
            Student student = getStudentInfo();
            List<Subject> theorySubjects = getTheorySubjects();
            List<Subject> practicalSubjects = getPracticalSubjects();
            
            // Generate and display marksheet
            System.out.print("\n" + Colors.GREEN + " All data entered successfully! Press Enter to generate marksheet..." + Colors.RESET);
            scanner.nextLine();
            printMarksheet(student, theorySubjects, practicalSubjects);
            
            // Final message
            System.out.println("\n" + Colors.BOLD + Colors.BRIGHT_GREEN + "🎉 Marksheet generated successfully!" + Colors.RESET);
            System.out.println(Colors.YELLOW + "Thank you for using Marksheet Generator!" + Colors.RESET);
            
        } catch (Exception e) {
            System.out.println("\n" + Colors.RED + " An error occurred: " + e.getMessage() + Colors.RESET);
        } finally {
            scanner.close();
        }
    }
}
