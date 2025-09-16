//WAP to search an element in array using binary search.
import java.util.Scanner;
class Q07{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);

    System.out.println("enter no of elements you want to entered");
    int n = sc.nextInt();
    int arr[] = new int[n];

     for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();

     }
     for(int i = 0;i<n-1;i++){
        for(int j = 0;j<n-1-i;j++){   //bubblesort n-1-i is method for sorting 
            if (arr[j]>arr[j+1]){
                 int temp = arr[j];
                  arr[j]=arr[j+1];
                 arr[j+1]=temp;

            }
        
        }

    }
    System.out.println("array sorting :");
    for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
    
    }
 int low = 0;
 int mid;
 int high = n-1;
 System.out.println("enter input element");
 int element = sc.nextInt();
 while(low<=high){
    mid= (low+high)/2;
    if(arr[mid]==element)
    break;
    else if (element>arr[mid])
    low=mid+1;
    else 
    high=mid-1;

 }
if(low<=high)
System.out.println("element found ");
else  
System.out.println("invalid");
}

}
