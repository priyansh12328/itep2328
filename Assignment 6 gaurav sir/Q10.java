//10) WAP to find out the smallest(minimum) element from an array

class Q10{
    public static void main(String args[]){
        
        int n=args.length;
        int min=0;
        int arr[]=new int[n];
        System.out.println("Enter array elements...");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(args[i]);
        }
        for(int i=0;i<n;i++){
            if(arr[i]<arr[min]){
                arr[min]=arr[i];
            }
        }
        System.out.println("Smallest(minimum) element from an array : "+arr[min]);
    }
}