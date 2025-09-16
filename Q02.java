/*
2.Create a class to calculate addition of two numbers 
(data member) using following member functions. 
Create members function
1.init - to input numbers from user
2.add - to calculate and display result
*/
import java.util.Scanner;
class addition {
    int num1, num2 ;     // its a data memebers as a question require ment

    void init(){         //1) func to input
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter first no:  ");
        num1 = sc.nextInt();

         System.out.print("Enter second no : ");
        num2 = sc.nextInt();

    }
    //func tocalculate and display sum 
    void add(){
        int sum = num1 + num2 ; 
        System.out.println ("Sum = "+ sum);

    }

}
class Q02 {
    public static void main(String args[]){
        addition obj = new addition();
        obj.init();
        obj.add();
    }
}