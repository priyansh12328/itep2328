// example showing the concept of polymorphism 
// method overloading 
//concept of polyymorphism = many forms 
class Q01{
    void greaterin(int a,int b){
        int res = a>b ? a : b;
        System.out.println("Greater Number : "+res);
    }
    void greaterin(int a,int b,int c){
        int res = a>b ? (a>c ? a : c) : (b>c ? b : c);
        System.out.println("Greater Number : "+res);
    }
    public static void main(String args[]){
        Q01 obj = new Q01();
        obj.greaterin(56,67);
        obj.greaterin(43,345,56);
    }
}