//) WAP to convert temp from f to c

import java.util.Scanner;

 class Q15 {
    static void temp() {   
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = sc.nextDouble();
        double c = (f - 32) * 5 / 9.0;
        System.out.println("Celsius = " + c);
    }

    public static void main(String[] args) {
        temp();
    }
}