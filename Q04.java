/*4.Write a program to define a class Student with 
the following specification
Private members of class student
admno	integer
sname	string 
eng, math, science		float
total	float
ctotal() (a Function to calculate eng + math + science with float
 return type.)

Public member function of class student
takeData() (a Function to accept values for admno, 
sname, eng, science and invoke ctotal() to calculate total.)
showData() (a Function to display all the data members on
 the screen.)
*/

import  java.util.Scanner;

class Student {
    private int addno;  // addmission no
    private String sname ; // student name
    private float eng ,math  , science ;
    private float  total ; 

    private  float ctotal(){
        return eng + math + science;

    }
    public void takedata(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter addmission no : ");
        addno = sc.nextInt();
            sc.nextLine();
        System.out.println("enter a student name : ");
        sname = sc.nextLine();

        System.out.println("Enter a  English marks : " );
        eng = sc.nextFloat();

        System.out.println("enter a  math marks : ");
        math = sc.nextFloat();

        System.out.println("enter a  science marks : ");
        science = sc.nextFloat();

          total = ctotal(); // call private method
    }

    public  void showData(){

        System.out.println("Addmission no : " +addno);
        System.out.println("Name : " +sname);
        System.out.println("English :" +eng +" Math: " +math + "Science :"+science);
        System.out.println("Total : " +total);

    }

}
class Q04 {
    public static void main(String args[]){
        Student s = new Student();
        s.takedata();
        s.showData();
    }
}