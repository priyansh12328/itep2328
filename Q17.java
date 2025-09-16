/*

17.Create a class Box with data members (boxlabel, length , width, height)
 and function that calculate and return volume of that box. Now create a function 
 comapre that take an object of Box class as parameters and show boxlabel of object 
 who’s volume is greater?. you need to create two object of Box   class to compare.
**/
class Box {
    String boxlabel;
    int length, width, height;

    Box(String label, int l, int w, int h) {
        boxlabel = label;
        length = l;
        width = w;
        height = h;
    }

    int volume() {
        return length * width * height;
    }

    static void compare(Box b1, Box b2) {
        if (b1.volume() > b2.volume())
            System.out.println("Greater volume = " + b1.boxlabel);
        else
            System.out.println("Greater volume = " + b2.boxlabel);
    }
}

public class Q17 {
    public static void main(String[] args) {
        Box b1 = new Box("BoxA", 2, 3, 4);
        Box b2 = new Box("BoxB", 5, 2, 2);
        Box.compare(b1, b2);
    }
}
