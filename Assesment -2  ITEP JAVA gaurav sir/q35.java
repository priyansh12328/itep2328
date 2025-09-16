 class q35 {
    public static void main(String args[]) {
        double radiusofsurface = 7.7;
        double heightofsurface = 12;
        double pi = 3.14;

        double curvedSurfaceArea = 2 * pi * radiusofsurface * heightofsurface;
        double circularArea = 2 * pi * radiusofsurface * radiusofsurface;
System.out.println("curved surface area: "+curvedSurfaceArea);
System.out.println("circular area:"+circularArea);
        double totalSurfaceArea = curvedSurfaceArea + circularArea;

        System.out.println("Surface area of the cylinder = " + totalSurfaceArea + " cm square");
    }
}
