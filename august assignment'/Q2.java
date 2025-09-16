//

    public class Q2 {
    static void series(int n) {
        int term = 1;  // first term
        System.out.print(term + " ");
        
        if (n > 1) {
            term = 2;  
            System.out.print(term + " ");
        }
        
        if (n > 2) {
            term = 2;  
            System.out.print(term + " ");
        }
        
    
        for (int i = 4; i <= n; i++) {
            term = term * 4;
            System.out.print(term + " ");
        }
    }

    public static void main(String[] args) {
        series(6);
    }
}

