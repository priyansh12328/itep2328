//27) WAP to find out the factors of a number.
import java.util.Scanner;
class Q27{
    void factor(int n){
        System.out.println("Factors of a number : ");
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i+"\t");
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        Q27 obj=new Q27();
        obj.factor( n);
    }
}
