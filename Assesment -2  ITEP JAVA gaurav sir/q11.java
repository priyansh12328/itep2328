import java.util.*;

class q11 
{


    public static void main(String args[]){

double area=320;
int base=8;//in the ratio
int height=5;//in the form of ratio 
 int area1= (base*height)/2 ; //using the ratio 
 

System.out.println( "area of ratio :"+area1);


double ratio = (area/area1);
System.out.println( "on dividing area: "+ratio);


double root;
root = Math.sqrt(ratio);



System.out.println("on finding the ratio root value :"+root);
 double b2;
 double h2;
 b2= (root*base); //base 
h2 = (root*height);

System.out.println("final base of triangle:"+b2);

System.out.println( "fianl height of triangle:"+h2);
    }
}