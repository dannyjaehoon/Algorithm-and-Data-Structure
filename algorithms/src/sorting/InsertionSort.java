package sorting;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    /**
     * ## 🛠 How It Works
     * - Start from the second element (index 1)
     * - Compare it with the elements to its left
     * - Shift all larger elements one position to the right
     * - Insert the current element into its correct position
     * - Repeat for all remaining elements
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        insertionSort(arr);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
