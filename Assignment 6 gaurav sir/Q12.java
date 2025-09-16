//12) Java Program to Sort Names in an Alphabetical Order 
import java.util.Arrays;

class Q12{
    public static void main(String args[]) {
        int n = args.length;

        System.out.print("Original Names: ");
        for (String name : args) {
            System.out.print(name + "\t");
        }

        Arrays.sort(args);

        System.out.print("\nSorted Names: ");
        for (String name : args) {
            System.out.print(name + "\t");
        }
    }
}
