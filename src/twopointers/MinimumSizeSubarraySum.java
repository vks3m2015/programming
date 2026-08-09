package twopointers;

//https://leetcode.com/problems/minimum-size-subarray-sum/
/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

	
	public int minSubArrayLen(int target, int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int startIdx = 0, endIdx = 0, winSum = 0, minLen = Integer.MAX_VALUE;

		while (startIdx < nums.length) {

			winSum += nums[endIdx];
			endIdx++;

			while (winSum > target) {
				minLen = Math.min(minLen, endIdx - startIdx);
				winSum -= nums[startIdx];
				startIdx++;
			}
		}
		return minLen;
	}

	public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen2(target, nums));

	}



        public static int minSubArrayLen2(int target, int[] nums) {

            int left = 0;
            int sum = 0;
            int minLength = Integer.MAX_VALUE;

            for (int right = 0; right < nums.length; right++) {

                // Expand window
                sum += nums[right];

                // Shrink window while sum >= target
                while (sum >= target) {

                    minLength = Math.min(minLength, right - left + 1);

                    sum -= nums[left];
                    left++;
                }
            }

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }



}
