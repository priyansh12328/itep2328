// example showing the concept of polymorphism 
// Constructor overloading 
class Constructor{
    Constructor(int a,int b){
        int res = a>b ? a : b;
        System.out.println("Greater Number : "+res);
    }
    Constructor(double a,double b){
        double res = a>b ? a : b;
        System.out.println("Greater Number... : "+res);
    }
}
class Q4{
    public static void main(String args[]){
        new Constructor(5.6,6.7);
        new Constructor(43,56);
    }
}
