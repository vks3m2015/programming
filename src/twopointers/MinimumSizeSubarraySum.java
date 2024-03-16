package twopointers;

//https://leetcode.com/problems/minimum-size-subarray-sum/
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
		

	}

}
