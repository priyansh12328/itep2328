// example showing the concept of polymorphism 
// method overloading // generates error
class error{
    int greater(int a,int b){
        return a>b ? a : b;
    }
    double greater(int a,double b){
        return a>b ? a : b; 
    }
}
class Q05{
    public static void main(String args[]){
        error obj = new error();
        System.out.println("Greater Number : "+obj.greater(56,67));
        System.out.println("Greater Number : "+obj.greater(434,6));
    }
}
