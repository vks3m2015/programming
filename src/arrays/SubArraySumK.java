package arrays;

import java.util.HashMap;
import java.util.Map;

//Ex. 1 Input: arr = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8 Output:  [4, 2, 1, 1]
public class SubArraySumK {

    public static void main(String[] args) {
       int[] arr = {3, 1, 2, 7, 4, 2, 1, 1, 5};
       int k = 8;
       //usingHashing(arr, k);
       usingSlidingWindow(arr, k);
    }

    //Approach -1
    static void usingHashing(int[] arr, int k){
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < arr.length; i++){
           currSum += arr[i];
           map.put(currSum, i);

           if(map.get(currSum - k) != null){
               int startIndex = map.get(currSum - k) + 1;
               int endIndex = i;
               printArr(arr, startIndex, endIndex);
           }
       }
    }

    private static void printArr(int[] arr, int startIndex, int endIndex) {
        for(int i = startIndex; i<=endIndex; i++){
            System.out.println(" element of subarr = "+ arr[i]);
        }
    }

    //Approach - 2
    static void usingSlidingWindow(int[] arr, int k){

        int winSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length ; right++) {

            winSum += arr[right];

            while(winSum > k && left <= right){
                winSum = winSum - arr[left];
                left++;
            }

            if(winSum == k){
                printArr(arr, left, right);
            }
        }
    }

    static void usingHashing(){
        int[] arr = {10, 15, -5, 15, -10, 5};
        int target = 5;

        Map<Integer, Integer> map = new HashMap<>(); // prefixSum -> index
        int prefixSum = 0;

        int start = 0, end = -1;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: prefix sum itself equals target
            if (prefixSum == target) {
                start = 0;
                end = i;
                break;
            }

            // Case 2: subarray found between previous prefix and current index
            if (map.containsKey(prefixSum - target)) {
                start = map.get(prefixSum - target) + 1;
                end = i;
                break;
            }

            // Store prefix sum if not present
            map.putIfAbsent(prefixSum, i);
        }

        if (end == -1) {
            System.out.println("No subarray found");
        } else {
            System.out.println("Subarray found from index " + start + " to " + end);
            System.out.print("Subarray = [");
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + (i < end ? ", " : ""));
            }
            System.out.println("]");
        }
    }
}










