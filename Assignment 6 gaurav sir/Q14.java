//WAP to find out simple interest
import java.util.Scanner;

 class Q14 {
    static void calculateSI() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double p = sc.nextDouble();

        System.out.print("Enter Rate: ");
        double r = sc.nextDouble();
        
        System.out.print("Enter Time: ");
        double t = sc.nextDouble();

        double si = (p * r * t) / 100;
        System.out.println("Simple Interest = " + si);
    }

    public static void main(String args[]) {
        calculateSI();
    }
}