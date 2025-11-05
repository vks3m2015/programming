package searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target1 = 23;
        binarySearchLoop(sortedArray, target1);
    }


    int binarySearchRecursive(int[] arr, int startIndex,  int endIndex, int key ){

        // Base case: If the search range is invalid (left > right), the key is not found.
        if(startIndex > endIndex){
            return -1;
        }

        int midIndex = startIndex + (endIndex - startIndex )/2;
        if (arr[midIndex] == key){
            return midIndex;
        }

        if(key < arr[midIndex]){
            return binarySearchRecursive(arr, startIndex, midIndex -1, key);
        }else {
            return binarySearchRecursive(arr, midIndex+ 1, endIndex, key);
        }
    }

    public static int binarySearchLoop(int[] arr, int target) {
        int low = 0; // Initialize the lower bound of the search space
        int high = arr.length - 1; // Initialize the upper bound of the search space

        // Continue the loop as long as the search space is valid
        while (low <= high) {
            // Calculate the middle index to avoid potential integer overflow
            int mid = low + (high - low) / 2;

            // Check if the target is found at the middle index
            if (arr[mid] == target) {
                return mid; // Target found, return its index
            }
            // If the target is greater than the middle element, search in the right half
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            // If the target is smaller than the middle element, search in the left half
            else {
                high = mid - 1;
            }
        }
        // If the loop finishes, the target was not found in the array
        return -1;
    }

}


