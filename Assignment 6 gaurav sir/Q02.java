//2) WAP to take n number of elements of an array from user and find out the sum of all the elements.
class Q02{
    public static void main(String args[]){
        
        int n=args.length;

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            
            arr[i]=Integer.parseInt(args[i]);

        }
        for(int x : arr){
            System.out.print(x+"\t");
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        System.out.println("\nSum of all the elements : "+sum);
    }
}

/*public class Q02 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter elements as command line arguments!");
            return;
        }

        int sum = 0;
        System.out.print("Elements: ");
        for (int i = 0; i < args.length; i++) {
            int val = Integer.parseInt(args[i]);
            System.out.print(val + " ");
            sum += val;
        }

        System.out.println("\nSum of all elements = " + sum);
    }
}
*/
/*public class Q02 {
    public static void main(String[] args) {
        // If no arguments are passed
        if (args.length == 0) {
            System.out.println("Please provide numbers as command line arguments.");
            return;
        }

        int sum = 0;

        // Loop through arguments and add them
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);  // Convert String → int
        }

        System.out.println("Sum of all elements = " + sum);
    }
}
*/