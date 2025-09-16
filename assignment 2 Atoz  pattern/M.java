class M {
    public static void main (String args[]){
        

        for (int i = 1; i<=4;i++){
            for(int j = 1;j<=7; j++){

           if(j==1||j==7||i==1&&j==2||i==2&&j==3||i==3&&j==4||i==2&&j==5||i==1&&j==6)

            System.out.print("*");
            else{
                System.out.print(" ");
            }
            }
        System.out.println();
        }
    }
}