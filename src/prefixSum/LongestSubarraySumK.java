package prefixSum;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
/*
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Subarrays with sum = -5 are [-5] and [-5, 8, -14, 2, 4]. The length of the longest subarray with a sum of -5 is 5.
 */
public class LongestSubarraySumK {

    public static void main(String[] args) {

    }


    public int longestSubarray(int[] arr, int k) {

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            int sumLen = 0;

            // Subarray starts at index 0
            if (prefixSum == k) {
                sumLen = i + 1;

            } else {   //Although removing this else will also be correct no effect on result

                int sup = prefixSum - k;
                if (prefixSumMap.containsKey(sup)) {
                    sumLen = i - prefixSumMap.get(sup);
                }
            }

            ans = Math.max(ans, sumLen);

            // map.putIfAbsent(prefixSum, i);
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }
        return ans;
    }


    public int longestSubarrayAI(int[] nums, int k) {

        Map<Long, Integer> map = new HashMap<>();

        long prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            // Subarray starts at index 0
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Find an earlier prefix sum
            long required = prefixSum - k;

            if (map.containsKey(required)) {
                int length = i - map.get(required);
                maxLength = Math.max(maxLength, length);
            }

            // Preserve the earliest index
            map.putIfAbsent(prefixSum, i);
        }

        return maxLength;
    }
}