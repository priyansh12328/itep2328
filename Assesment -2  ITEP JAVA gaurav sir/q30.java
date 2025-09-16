class q30 {

public static void main (String args[]) {
int tilelen =5;
int tilebread=8;

int areaonetile =tilelen*tilebread;

int bedroomlen=200;
int bedroombread =400;

int areaofbedroom = bedroomlen*bedroombread;

int nooftiles= areaofbedroom/areaonetile;
System.out.println("tiles required:"+nooftiles);


}    
}