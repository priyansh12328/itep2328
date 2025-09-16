//24) WAP to find out the sum of N natural number.

import java.util.Scanner;
class Q24{
    static void natural(double n){
        double res=(n*(n+1))/2;
        System.out.println("sum of N natural number : "+res);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of terms : ");
        double n=sc.nextDouble();
        natural(n);
    }
}
