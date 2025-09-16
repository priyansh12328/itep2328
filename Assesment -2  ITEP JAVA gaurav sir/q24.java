class q24 {
    public static void main (String args[]){
int wallLength =20*100;
int wallBreadth =2 * 100 ;
int wallThickness  = (int)(0.75 *100 );


double bricklength = 25;
double brickBreadth = 10;
double brickthickness = 7.5;


double wallvolume = wallLength*wallBreadth*wallThickness;

double brickvolume= bricklength*brickBreadth*brickthickness;

double numberofbricks = wallvolume/brickvolume;
double costperthousand = 900;
double totalcost = (numberofbricks/1000.0)*costperthousand;

System.out.println("number of bricks required :" + numberofbricks);
System.out.println("total cost to build  the wall :$"+totalcost);




}

}