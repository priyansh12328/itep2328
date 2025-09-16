// example showing the concept of polymorphism 
// method overloading 
//two class different names are thare in the code 
class Test{
    double greater(int a,double b){
        return a>b ? a : b;
    }
    double greater(double a,int b){
        return a>b ? a : b; 
    }
}
class Q03{
    public static void main(String args[]){
        Test obj = new Test();
        System.out.println("Greater Number : "+obj.greater(56,6.7));
        System.out.println("Greater Number : "+obj.greater(43.4,6));
    }
}