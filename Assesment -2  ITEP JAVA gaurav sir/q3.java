class q3 {
public static void main(String args[])
{
int length_tile  = 13;
int breadth_tile = 7;
int length_rectangular_region = 520;
int breadth_rectangular_region = 140;
int area_of_tile;

  area_of_tile= (length_tile * breadth_tile );
int area_of_region ;
area_of_region = (length_rectangular_region*breadth_rectangular_region );

int total;
total = (area_of_region/area_of_tile);
System.out.println(total);



}
}13