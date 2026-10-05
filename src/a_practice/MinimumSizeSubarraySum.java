package a_practice;

import java.util.Arrays;

/*
Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7, nums[] = {2,3,4,8,1,2,4};

        System.out.println(minSubArrayLen(target, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int winSum = 0,  minLen=Integer.MAX_VALUE;
        int left = 0;

        for(int right=0; right<nums.length; right++){

            winSum = winSum+nums[right];

            while (winSum >= target){
                System.out.println("window arrays "+ Arrays.toString(Arrays.copyOfRange(nums, left, right+1 )));
                System.out.println("BEFORE minLen = "+ minLen + " winSum == "+ winSum);
                minLen = Math.min(minLen, (right-left+1));
                winSum = winSum - nums[left];
                left++;
                System.out.println("minLen = "+ minLen + " winSum == "+ winSum);


            }
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
