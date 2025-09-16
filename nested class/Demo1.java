// example showing the concept of nested class 
// static nested class 

class Demo1{ // Enclosing class | Outer class
    static int num=23;
    private static String name = " priyansh ";
    static class NestedClass{ // static Nested class 
        void display(){
            System.out.println("num : "+num);
            System.out.println("name : "+name);
        }
    }
    public static void main(String args[]){
        NestedClass obj = new NestedClass();
        obj.display();
    }
}