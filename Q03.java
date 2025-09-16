/*.Create a class to calculate factorial with one data member to store the number and another to store factorial value. Create members function
1.init - to input number from user
2.fact - to calculate factorial
3.display- to display answer
*/
import java.util.Scanner;
class Factorial{
    int num ;
    int fact;

    void init(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number :");
        num = sc.nextInt();
     
    }
    void fact(){
        fact = 1 ;
        for(int i =1 ;i<=num ; i++){
            fact = fact * i;

        }

    }
    void display(){
        System.out.println("Factorial of "+num +" = " +fact );

    }
}
class  Q03 {
    public static void main(String args[]){

        Factorial obj = new Factorial();
        obj.init();
        obj.fact();
        obj.display();
    }
}