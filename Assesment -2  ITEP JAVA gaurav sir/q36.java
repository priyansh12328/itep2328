 class q36 {
    public static void main(String args[]) {
        double d = 15.0;
        double radius = d / 2;
        double height = 7.0;
        double pi = 3.1416;

        double curvedSurfaceArea = 2 * pi * radius * height;
        System.out.println("curved surface area:  "+curvedSurfaceArea);
        double endsArea = 2 * pi * radius * radius;
        System.out.println("ends area of cylinder :"+endsArea);

        double totalSurfaceArea = curvedSurfaceArea + endsArea;

        System.out.println("Surface area of the cylinder = " + totalSurfaceArea + " metre  square");
    }
}
