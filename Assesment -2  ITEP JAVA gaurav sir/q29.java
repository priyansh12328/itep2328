class q29 {

public static void main (String args[]) {
        int tileSide = 10;
        int l1 = 800; //in cm
        int b1 = 900;


int areatilesquare= tileSide*tileSide;
int floorarea = l1*b1;

int tilesrequired= floorarea/areatilesquare;

System.out.println("tiles  required: "+tilesrequired);


}

}