/*
        {1,2,3},          {1,2,3},
        {4,5,6},    +     {4,5,6},
        {7,8,9}           {7,8,9}
             };

*/
class Q06 {
    public static void main(String args[]) {
        int[][] add1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] add2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] sum = new int[3][3];

        // adding matrix i j 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = add1[i][j] + add2[i][j];
            }
        }

        // Print result
        System.out.println("Sum of two matrices:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
