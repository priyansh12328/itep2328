class q25 {
    public static void main(String args[]){
        
        int brickLength = 24;  
        int brickBreadth = 15; 
        int numberOfBricks = 100;
    
        int area1Brick = brickLength*brickBreadth;
        int totalAreaCm2 = area1Brick*numberOfBricks;
        double totalAreaM2 = totalAreaCm2/10000.0;

        System.out.println("Total area of the path = " + totalAreaCm2 + " cm  square ");
        System.out.println("Total area of the path = " + totalAreaM2 + " metre sqaure");
    }
}
    
