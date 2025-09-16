///multipl of two matrixes

class Q07{
    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] mat2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] result = new int[3][3];

        //multiplication i j 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { 
                result[i][j] = 0;
                for (int k = 0; k < 3; k++) {      // for the third matix...resultatnt 
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        System.out.println("Multiplication 3*3 matrix :");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
