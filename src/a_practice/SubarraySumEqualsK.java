package a_practice;

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

        int len = nums.length;
        int[] subarraySum = new int[len];

        int sum = 0;
        for(int i = 0; i < len; i++){
            sum = sum + nums[i];
            subarraySum[i] = sum;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0 ; i< nums.length; i++){
            // Handle subarrays starting at index 0
            if(subarraySum[i] == k){
                ans++;
            }
            int supplementary = subarraySum[i] - k;
            if(map.get(supplementary) != null){
                  ans = ans + map.get(supplementary);
            }
            map.put(subarraySum[i], map.getOrDefault(subarraySum[i], 0) + 1);
        }
        return ans;
    }


}
