package sorting;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;

        for(int i = 0; i < n-1; i++) {
            swapped = false;

            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
    /*
    ## 🛠 How It Works
    - Compare each pair of adjacent items
    - Swap them if they are in the wrong order
    - Repeat the process for all elements until no swaps are needed
     */
    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 4, 2};
        bubbleSort(arr);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
