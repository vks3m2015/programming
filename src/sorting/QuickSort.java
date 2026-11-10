package sorting;

import java.util.Arrays;

//https://www.youtube.com/watch?v=8MNB0Mba_Dc

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            // Find the correct position of the pivot
            int pivotIndex = partition(arr, low, high);

            // Sort elements to the left of the pivot
            quickSort(arr, low, pivotIndex - 1);

            // Sort elements to the right of the pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        // Choose the last element as the pivot
        int pivot = arr[high];

        // Boundary of elements smaller than or equal to pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 1, 7, 0, 10, 2};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
