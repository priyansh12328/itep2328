class q15 {
    public static void main(String args[]) {

        int length = 22; // this is for Shelly
        int breadth = 15;
        int area1 = length * breadth;
        System.out.println("Area of Shelly: " + area1);

        int side1 = 21; // for Racheal
        int area2 = side1 * side1;
        System.out.println("Area of Racheal: " + area2);

        if (area2 > area1) {
            System.out.println("Racheal's garden is bigger by " + (area2 - area1)+ " metre square" );
        } else if (area1 > area2) {
            System.out.println("Shelly's garden is bigger by " + (area1 - area2) );
        } else {
            System.out.println("Both gardens are of equal area.");
        }
    }
}
