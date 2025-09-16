//7) WAP showing the concept of Selection sort (Ascending order | Descending order.

class Q07 {
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

        // Ascending order
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.print("\nAscending Order: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        // Descending order
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }

        System.out.print("\nDescending Order: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
