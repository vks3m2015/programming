package arrays.twosum;

import java.util.Arrays;
import java.util.HashSet;

//Given an array arr[] of n integers and a target value, check if there exists a pair whose sum equals the target
public class TwoSum {





    static boolean twoSum(int[] arr, int target){

        // Create a HashSet to store the elements
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            // Calculate the complement that added to
            // arr[i], equals the target
            int complement = target - arr[i];

            // Check if the complement exists in the set
            if (set.contains(complement)) {
                return true;
            }

            // Add the current element to the set
            set.add(arr[i]);
        }
        // If no pair is found
        return false;
    }

    static boolean twoSumTwoPointerApproach(int[] arr, int target){

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        // Iterate while left pointer is less than right
        while (left < right) {
            int sum = arr[left] + arr[right];

            // Check if the sum matches the target
            if (sum == target)
                return true;
            else if (sum < target)
                // Move left pointer to the right
                left++;
            else
                // Move right pointer to the left
                right--;
        }
        // If no pair is found
        return false;
    }
}
