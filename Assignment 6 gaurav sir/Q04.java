//4) WAP to reverse all the elements of an array


class Q04{
    public static void main(String args[]){
        
        int n=args.length;

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(args[i]);

        }
        for(int x : arr){
            System.out.print(x+"\t");
        }
        System.out.println("\nAfter reverse..");
        for(int i=0;i<n/2;i++){
        
            int temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
        }
        
        for(int x : arr){
            System.out.print(x+"\t");
        }

    }
}