/*
13.Create class Plot with data members length and breadth.
 Create constructor. Create member functions
a)float calcArea()->to return area of plot
b)Plot compare(Plot p)-> which takes Object of Plot class
 as argument and return 0 if area of argument object is same
  as current object, 1 if current object area is > then
   argument object and
 -1 if area of argument object is > then current object.*/

 class Plot {
    float length, breadth; //data memebers 

    Plot(float l, float b) {
        length = l;
        breadth = b;
    }

    float calcArea() {
        return length * breadth;
    }

    int compare(Plot p) {
        float area1 = this.calcArea();
        float area2 = p.calcArea();
        if (area1 == area2) return 0;
        else if (area1 > area2) return 1;
        else return -1;
    }
}

public class Q13 {
    public static void main(String[] args) {
        Plot p1 = new Plot(10, 20);
        Plot p2 = new Plot(15, 15);
        System.out.println("Compare Result = " + p1.compare(p2));
    }
}
