class q21 {

public static void main(String args[]){
    int length_of_brick=15 ;
    int breadth_of_brick= 8;
    int height_of_brick= 5;
int length_of_wall= 1500; //because 15 m =1500 cm 
int breadth_of_wall = 1000;
int height_of_wall = 800;
int volumebrick= length_of_brick*breadth_of_brick*height_of_brick;
int volumewall=length_of_wall*breadth_of_wall*height_of_wall;


 int totalbricks = volumewall/volumebrick;
System.out.println("total bricks :"+totalbricks);
}
}