/*
calculate the ssum all even element and all oddelement 
1 2 3 
4 5 6
7 8 9 

*/

class Q01{
public static void main (String args[]){
 



    int arr[][]={
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };

int evensum = 0;  
int oddsum = 0;

 for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j]%2==0){
                    evensum = evensum + arr[i][j];
    
    }
                else{ 
                oddsum = oddsum + arr[i][j];
        }
    }
 }
              
                System.out.println("sum of even element = "+evensum);
                System.out.println("Sum of odd element = "+oddsum);
        }
}
