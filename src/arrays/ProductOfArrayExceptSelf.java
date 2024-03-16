package arrays;

import java.util.Arrays;
import java.util.stream.Stream;

//https://leetcode.com/problems/product-of-array-except-self/
/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the 
 * elements of nums except nums[i]
 */
//Sol - https://www.youtube.com/watch?v=gREVHiZjXeQ
//Expectation - t(n) and no division operation used
public class ProductOfArrayExceptSelf {

	//Idea - for a particular element if we know product of elements to right of it and left of it. 
	//Then product can be easily calculated
    public static int[] productExceptSelf(int[] nums) {
    	
    	//multipurpose - to store cumulative product from left to right elements of array and final output as well
    	//We can also have two different arrays - one to store cumulative product of elements from left to right and one for to store lative product of elements from right to left. But to save space we are reusing ans[] array.
    	int[] ans = new int[nums.length];
    	
    	ans[0] = nums[0];
    	for(int i =1; i< nums.length-1; i++) {
    		ans[i] = ans[i-1] * nums[i];
    	}
    	
    	int cumProductFromRightToLeft = 1;
    	for(int i = nums.length - 1; i>0; i--) {
    		ans[i] = ans[i-1] * cumProductFromRightToLeft;
    		cumProductFromRightToLeft = cumProductFromRightToLeft * nums[i];
    	}
    	
    	ans[0] = cumProductFromRightToLeft;
    	return ans;
    }

	public static void main(String[] args) {

		int[] nums = {1,2,3,4};  //Ans - [24, 12, 3, 4]
		int[] ans = productExceptSelf(nums);
		
		System.out.println(Arrays.toString(ans));
		
	}

}
