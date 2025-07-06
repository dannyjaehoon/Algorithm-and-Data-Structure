package sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element of unsorted part
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    /**
     * ## 🛠 How It Works
     * - Start from the first element (index 0)
     * - Find the minimum element in the unsorted portion
     * - Swap it with the element at the current index
     * - Move to the next index and repeat the process
     * - Continue until the array is sorted
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        selectionSort(arr);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
