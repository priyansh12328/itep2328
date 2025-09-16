//0	7	14	21	28	35	…..nth
import java.util.Scanner;
class Q10{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int n =  sc.nextInt();
    int a = 0 ,d =7;
        for(int i = 0;i<=n;i++)
    {
         int series = a + i * d;
            System.out.print(series + " ");
    
    
    }
    
    }}