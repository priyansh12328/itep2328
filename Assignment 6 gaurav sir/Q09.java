//9) WAP to find out the largest(maximum) element from an array

class Q09{
    public static void main(String args[]){
        
        int n=args.length;
        int max=0;
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(args[i]);
        }
        for(int i=0;i<n;i++){
            if(arr[i]>arr[max]){
                arr[max]=arr[i];
            }
        }
        System.out.println("Largest(maximum) element from an array : "+arr[max]);
    }
}