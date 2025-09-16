//41) WAP to check whether entered array is a palindrome or not.
import java.util.Scanner;
class Q41{
    static void reverse(int num){
        int temp=num;
        int digit=0,rev=0;
        while(temp!=0){
            digit=temp%10;
            rev=(rev*10)+digit;
            temp=temp/10;
        }
        if(num==rev){
            System.out.print(num+" is  a palindrome.");
        }
        else{
            System.out.print(num+" is not a palindrome.");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num=sc.nextInt();
        reverse(num);
    }
}