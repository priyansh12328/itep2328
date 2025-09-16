//31) 1+11+111+1111+11111+….
import java.util.Scanner;
class Q31{
    void series(int n){
        int res=0,sum=0;
        for(int i=0;i<n;i++){
            
            res=(res*10)+1;
            System.out.print(res+"+");
            sum+=res;
        }
        System.out.print("\nSum : "+sum);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of terms : ");
        int n=sc.nextInt();
        Q31 obj=new Q31();
        obj.series(n);
    }
}