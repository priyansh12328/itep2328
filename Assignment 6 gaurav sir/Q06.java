//6) WAP to check whether entered array is a palindrome or not.

//6) WAP to check whether entered array is a palindrome or not

class Q06{
    public static void main(String args[]){
        
        int n=args.length;
        int arr[]=new int[n];
        int arr2[]=new int[n];
        boolean flag=true;
        System.out.println("Enter array elements...");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(args[i]);
        }

        for(int x: arr){
            System.out.print(x+"\t");
        }

        for(int i=0;i<n;i++){
            arr2[i]=arr[i];
        }
        for(int i=0;i<n/2;i++){
            int temp=arr2[i];
            arr2[i]=arr2[n-i-1];
            arr2[n-i-1]=temp;
        }
        System.out.println("\nAfter reverse...");
        for(int x:arr2){
            System.out.print(x+"\t");

        }
        for(int i=0;i<n;i++){
            if(arr[i]!=arr2[i]){
                flag=false;
                break;
            }
        }
        if(flag==true){
            System.out.println("\nEntered array is a palindrome.");
        }
        else{
            System.out.println("\nEntered array is not a palindrome.");
        }

    }
}