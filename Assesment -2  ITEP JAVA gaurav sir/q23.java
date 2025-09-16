class q23 {

    public static void main(String args[])
{

int lengthcartoon=15;
int breadthcartoon = 9;
int heightcartoon= 12;
int cubicalside = 3;


 int boxfitlength = lengthcartoon/cubicalside;
 int boxfitbreadth = breadthcartoon/cubicalside;
 int boxfitheight = heightcartoon/cubicalside;


 int totalcubebox = boxfitlength*boxfitbreadth*boxfitheight;
 System.out.println("total cube box size :"+totalcubebox);


}
}