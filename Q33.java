/*

33. Create a class MathOperation containing method ‘multiply’ to calculate
multiplication of following arguments.
a. two integers
b. three float
c. all elements of array
d. one double and one integer
*/
class MathOperation {
    int multiply(int a, int b) {
        return a * b;
    }

    float multiply(float a, float b, float c) {
        return a * b * c;
    }

    int multiply(int[] arr) {
        int prod = 1;
        for (int x : arr) prod *= x;
        return prod;
    }

    double multiply(double a, int b) {
        return a * b;
    }
}

public class Q33 {
    public static void main(String[] args) {
        MathOperation m = new MathOperation();
        System.out.println("Int multiply = " + m.multiply(3, 4));
        System.out.println("Float multiply = " + m.multiply(1.2f, 2.3f, 3.4f));
        System.out.println("Array multiply = " + m.multiply(new int[]{2,3,4}));
        System.out.println("Double-Int multiply = " + m.multiply(5.5, 2));
    }
}
