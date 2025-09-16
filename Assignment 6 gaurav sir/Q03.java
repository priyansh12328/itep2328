//3) WAP to take n number of elements of an array from user and find out the average of all the elements.
/*public class Q03 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter elements as command line arguments!");
            return;
        }

        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }

        double avg = (double) sum / args.length;

        System.out.println("Average of all elements = " + avg);
    }
}
*/

class Q03{
    public static void main(String args[]){
        
        int n=args.length;

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(args[i]);

        }
        for(int x : arr){
            System.out.print(x+"\t");
        }
        double sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        double avg=sum/n;
        System.out.println("\nSum of all the elements : "+avg);
    }
}