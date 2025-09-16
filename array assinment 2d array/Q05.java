
class Q05{
    public static void main(String args[]){
     int arr[][]= {
        {1,2,3},
        {4,5,6},
        {7,8,9}
             };


     for (int r = 0 ; r<arr.length;r++){
        for(int c = 0 ;c<arr.length;c++){
           if(r<c)
            {
                System.out.print(arr[r][c]+" ");
            }
        }
     }

    }
}