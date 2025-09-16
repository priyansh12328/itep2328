class q34 {
    public static void main(String[] args) {
int b1=128;
int b2=92;
int height=40;


int wlkawaywidth=4;
int walkawaylength = height;
 double trapezoidArea = 0.5 * (b1 + b2) * height; //0.5 mean multiply with 1/2
System.out.println("trapezoid area: "+trapezoidArea);


  int walkwayArea = wlkawaywidth * walkawaylength;
System.out.println("walkwayarea: "+walkwayArea);

 double totalArea = trapezoidArea + walkwayArea;


        System.out.println("Total area after adding the walkway = " + totalArea + " m square");



    }}