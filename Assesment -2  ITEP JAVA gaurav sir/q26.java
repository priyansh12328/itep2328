class q26 {
    public static void main(String args[])
    {
        int l1=1200; //m to cm directly change
        int b1=  240 ;
       int areaofpath=l1*b1;
        int l2brick=24;
        int b2brick=15;
      int  areaof1brick=(l2brick*b2brick);
       int numberofbricks=(areaofpath/areaof1brick);
       System.out.println("no of bricks: "+numberofbricks);
    }
}