import java.util.Scanner;





class Subject {
    private String name;
    private int maxMarks;
    private double obtainedMarks;
    
    public Subject(String name, int maxMarks, double obtainedMarks) {
        this.name = name;
        this.maxMarks = maxMarks;
        this.obtainedMarks = obtainedMarks;
    }
    //value gate kri 
    public String getname(){return name;}
    public int getMaxMarks(){return maxMarks;}
    public Double getObtainedMarks(){return obtainedMarks;}

    //next is check subject is passed (33% passed)
    public  boolean isPassed(){
        return obtainedMarks >=(maxMarks*0.33);
    }

    
}
//class to represent student infoermation
class Student {
    private String name;
    private String rollNo;
    private String className;

    public Student (String name,String rollNo,String className){
        this.name = name;
        this.rollno = rollNo;
        this.className = getClassName;

    }
    //get the value 
     public String getName() { return name; }
    public String getRollNo() { return rollNo; }
    public String getClassName() { return className; }
}
//remark class to hold remark and its color 
class Remark {
    private String remark ;
    private String color ;

    public Remark(String remark , String color ){
        this.remark = remark ; 
        this.color = color ; 

    }
    //geetting the value 
    public String getRemark(){return remark; }
    public string getcolor(){return color ;}
}
public  class marksheets {
    private static Scanner sc =  new Scanner(System.in);

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
            }
             catch (NumberFormatException e) {
                System.out.println(Colors.RED + " Invalid! Please enter a valid number." + Colors.RESET);
            }
        
        }
     }
     // method to get student information 

     public static  student getStudentInfo() {
        System.out.println(Colors.BOLD + Colors.BG_BLUE +colors.WHITE+"-----------------------------------------------------------"
        +Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "           STUDENT INFORMATION ENTRY                       " + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_BLUE + Colors.WHITE + 
                          "-----------------------------------------------" + Colors.RESET);
        
        System.out.print("\n" + Colors.BOLD + "Enter Student Name: " + Colors.RESET);
        String name = sc.nextLine().trim();
         System.out.print(Colors.BOLD + "Enter Roll Number: " + Colors.RESET);
        String rollNo =sc.nextLine().trim();
        
        System.out.print(Colors.BOLD + "Enter Class: " + Colors.RESET);
        String className = sc.nextLine().trim();
        
        return new Student(name, rollNo, className);
    }
         public static List<Subject> getTheorySubjects() {
        System.out.println("\n" + Colors.BOLD + Colors.BG_GREEN + Colors.WHITE + 
                          "------------------------------------------------------------" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_GREEN + Colors.WHITE + 
                          "              THEORY SUBJECTS (5)                          " + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_GREEN + Colors.WHITE + 
                          "------------------------------------------------------------" + Colors.RESET);
        System.out.println(Colors.YELLOW + "Note: All theory subjects are out of 100 marks" + Colors.RESET + "\n");
        
        List<Subject> theorySubjects = new ArrayList<>();
        
     //get subject names 
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
                          "-----------------------------------------------------------" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_MAGENTA + Colors.WHITE + 
                          "             PRACTICAL SUBJECTS (2)                        " + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BG_MAGENTA + Colors.WHITE + 
                          "------------------------------------------------------------" + Colors.RESET);
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
    








}