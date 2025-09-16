//
 import java.util.Scanner;

public class Q22 {
    static void Interest() {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter Principal: ");
        double p = sc.nextDouble();

        System.out.print("Enter Rate: ");
        double r = sc.nextDouble();

        System.out.print("Enter Time: ");
        double t = sc.nextDouble();

        if (p >= 500) {
            double ci = p * Math.pow((1 + r / 100), t) - p;
            System.out.println("Compound Interest = " + ci);
        } else {
            double si = (p * r * t) / 100;
            System.out.println("Simple Interest = " + si);
        }
    }

    public static void main(String[] args) {
        Interest();
    }
}
