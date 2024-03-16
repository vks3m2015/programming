package arrays;

public class MaximumSubArray {

	//https://leetcode.com/problems/maximum-subarray/
	
	/*
	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	A subarray is a contiguous part of an array.

			Example 1:

			Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
			Output: 6
			Explanation: [4,-1,2,1] has the largest sum = 6. */
	
	
	
	//Kadane's Algorithm - O(N)
	 public static int maxSubArray(int[] nums) {
	 
		 int currentSum = 0;
		 int maxSum = Integer.MIN_VALUE;
		 
		 for(int i=0; i<nums.length; i++) {
			 
			 currentSum += nums[i];
			 
			 if(currentSum > maxSum)
				 maxSum = currentSum;
			 
			 if(currentSum < 0)
				 currentSum =0;
		 }
		 return maxSum;
	 }
	
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; //6
		int[] arr2 = {-2,-1,-3};
		System.out.println(maxSubArray(arr2));

	}

}
