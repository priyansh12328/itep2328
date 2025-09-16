public class Q3 {
    public static void main(String[] args) {
        int n = 6;   // no of lines 
        int num = 1; // start krna h 

        for (int i = 1; i <= n; i++) {
            System.out.print(num + " ");
            // j print stars 
            for (int j = 1; j <= num; j++) {
                System.out.print("*");
            }
            System.out.println();

            // update number for next line difference print krwara h 1,2,3,4,5 jo difference h 
           num = num + i;
        }
    }
}
