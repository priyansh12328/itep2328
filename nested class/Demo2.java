// example showing the concept of nested class 
// static nested class 
/*
class EnclosingClass{ // Enclosing class | Outer class
    static int num=100;
    private static String name = "Saksham ";
    static class NestedClass{ // static Nested class 
        void display(){
            System.out.println("num : "+num);
            System.out.println("name : "+name);
        }
    }
}
class Demo2{
    public static void main(String args[]){
        EnclosingClass.NestedClass obj = new EnclosingClass.NestedClass();
        obj.display();
    }
}
*/  
class priyansh{ // Enclosing class | Outer class
    static int num=100;
    private static String name = "Saksham ";
    static class indoreclass{ // static Nested class 
        void display(){
            System.out.println("num : "+num);
            System.out.println("name : "+name);
        }
    }
}
class DEmo2{
    public static void main(String args[]){
    priyansh.indoreclass obj = new priyansh.indoreclass();
        obj.display();
    }
}