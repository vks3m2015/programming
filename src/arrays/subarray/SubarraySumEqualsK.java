package arrays.subarray;

//https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

nums can be negative, positive, zero as well

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        int prefixSum = 0;
        int count =0;
        for(int num : nums){
            prefixSum += num;

            int complementry = prefixSum - k;
            count += prefixSumMap.getOrDefault(complementry, 0);

            prefixSumMap.put(
                    prefixSum,
                    prefixSumMap.getOrDefault(prefixSum, 0) + 1
            );
        }
        return  count;
    }
}
