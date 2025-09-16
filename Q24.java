/*
24.Create a class Rectangle with two protected data members (length and breadth).Declare a Constructor 
which accepts length and breadth of a Rectangle
Create another class Area which calculates the area of a Rectangle.
Create another class Perimeter which calculates the perimeter of a Rectangle.

*/

class Rectangle {
    protected int length, breadth;
    Rectangle(int l, int b) { length = l; breadth = b; }
}

class Area extends Rectangle {
    Area(int l, int b) { super(l, b); }
    void calcArea() {
        System.out.println("Area = " + (length * breadth));
    }
}

class Perimeter extends Rectangle {
    Perimeter(int l, int b) { super(l, b); }
    void calcPerimeter() {
        System.out.println("Perimeter = " + (2 * (length + breadth)));
    }
}

public class Q24 {
    public static void main(String[] args) {
        Area a = new Area(5, 10);
        a.calcArea();
        Perimeter p = new Perimeter(5, 10);
        p.calcPerimeter();
    }
}

