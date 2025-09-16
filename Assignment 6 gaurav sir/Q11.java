//11) WAP showing the concept of Insertion sort
class Q11 {
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

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.print("\nSorted Array: ");
        for (int x : arr) {
            System.out.print(x + "\t");
        }
    }
}
