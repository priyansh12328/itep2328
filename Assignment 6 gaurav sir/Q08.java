//8) WAP showing the concept of Bubble sort (Ascending order | Descending order)
class Q08 {
    public static void main(String args[]) {
        int n = args.length;

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        System.out.print("Original Array: ");
        for (int x : arr) {
            System.out.print(x + "\t");
        }

        // Ascending Order 
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("\nAscending Order: ");
        for (int x : arr) {
            System.out.print(x + "  ");
        }

        // Descending Order 
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("\nDescending Order: ");
        for (int x : arr) {
            System.out.print(x + "  ");
        }
    }
}
