import java.util.Scanner;

interface Showable {
    void calculate();

}
class Demo5{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
System.out.println("enter value");
int a = sc.nextInt();
int b = sc.nextInt();

Showable obj = ()->{

System.out.println("Sum :"+(a+b));

};
obj.calculate();
    }
}