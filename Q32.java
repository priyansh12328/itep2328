/*

32.Create a class MathOperation with two data member X and Y to store the operand and third data member 
R to store result of operation.Create method members
 init - to input X and Y from user 
    add - to add X and Y and store in R
    multiply - to multiply X and Y and store in R
    power - to calculate X Y and store in R
    display- to display Result R

*/
import java.util.Scanner;

class MathOperation {
    int X, Y, R;

    void init() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter X: ");
        X = sc.nextInt();
        System.out.print("Enter Y: ");
        Y = sc.nextInt();
    }

    void add() { R = X + Y; }
    void multiply() { R = X * Y; }
    void power() { R = (int)Math.pow(X, Y); }
    void display() { System.out.println("Result = " + R); }
}

public class Q32 {
    public static void main(String[] args) {
        MathOperation m = new MathOperation();
        m.init();
        m.add(); m.display();
        m.multiply(); m.display();
        m.power(); m.display();
    }
}
