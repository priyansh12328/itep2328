//28) WAP to check whether entered number is prime or not.
import java.util.Scanner;
class Q28{
    void Prime(int n){
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println(n+" is a prime.");
        }
        else{
            System.out.println(n+" is not a prime.");
        }
    }
    public static void main(String ahrs[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        Q28 obj=new Q28();
        obj.Prime(n);
    }
}