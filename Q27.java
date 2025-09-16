/*
27. Create a class Shape with one member function
a) double calcArea()
Create a class Rectangle with two data members (length and breadth) and inherits Shape and calculate the area
Create a class Circle with one data members (radius) and inherits Shape and calculate the area

*/


abstract class Shape {
    abstract double calcArea();
}

class Rectangle extends Shape {
    double length, breadth;
    Rectangle(double l, double b) { length = l; breadth = b; }
    double calcArea() { return length * breadth; }
}

class Circle extends Shape {
    double radius;
    Circle(double r) { radius = r; }
    double calcArea() { return Math.PI * radius * radius; }
}

public class Q27 {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(10, 20);
        Shape s2 = new Circle(7);
        System.out.println("Rectangle Area = " + s1.calcArea());
        System.out.println("Circle Area = " + s2.calcArea());
    }
}
