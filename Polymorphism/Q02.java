// example showing the concept of polymorphism 
// method overloading 
class poly{
    void greater(int a,int b){
        int res = a>b ? a : b;
        System.out.println("Greater Number : "+res);
    }
    void greater(double a,double b){
        double res = a>b ? a : b;
        System.out.println("Greater Number... : "+res);
    }
}
class Q02{
    public static void main(String args[]){
        poly obj = new poly();
        obj.greater(5.6,6.7);
        obj.greater(43,56);
    }
}
