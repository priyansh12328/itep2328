class q33{


    public static void main (String args[]){

int garlength=30;
int garbreadth=20;
int pathwaywide1=3;
int pathwaywide2=4;


int totalarea= garlength*garbreadth;
System.out.println("totalarea: "+totalarea);

int patharea1= garlength*pathwaywide1;
System.out.println("patharea1: "+patharea1);

int patharea2= garbreadth*pathwaywide2;
System.out.println("patharea2: "+patharea2);

int overlaparea=pathwaywide1*pathwaywide2;
System.out.println("overlaparea:" +overlaparea);

int totalpatharea=patharea1+patharea2-overlaparea;
System.out.println("total path area :" +totalpatharea);

int usablesarea= totalarea-totalpatharea;

System.out.println("usablle area: "+usablesarea);

    }
}