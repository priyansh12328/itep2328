//5) WAP to reverse individual elements of an array   

    class Q05{ 
    public static void main(String args[]){
        
        int n=args.length;
        int arr[]=new int[n];
        System.out.println("Enter array elements...");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(args[i]);
        }
        System.out.println("Original array...");
        for(int x : arr){
        System.out.print(x+"\t");
        }

        //reverse

        for(int i=0;i<n;i++){
            int num=arr[i];
            int rev=0,digit;
            while(num!=0){
                digit=num%10;
                rev=(rev*10)+digit;
                num=num/10;
            }
            arr[i]=rev;
        }
        System.out.println("\nAfter reverse individual elements of an array... ");
        for(int x:arr){
            System.out.print(x+"\t");
        }
    }
} 

