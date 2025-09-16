import java.util.Scanner;

interface Showable {
    void calculate();

}
class Demo4{
    public static void main(String args[]){
Showable obj = ()->{
Scanner sc = new Scanner(System.in);
System.out.println("enter value");
int a = sc.nextInt();
int b = sc.nextInt();
System.out.println("Sum :"+(a+b));

};
obj.calculate();
    }
}