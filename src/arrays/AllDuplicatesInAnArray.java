package arrays;

import java.util.ArrayList;
import java.util.List;

public class AllDuplicatesInAnArray {

	//https://leetcode.com/problems/find-all-duplicates-in-an-array/
	/*
	 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
	 * and each integer appears once or twice, return an array of all the integers that appears twice.
       You must write an algorithm that runs in O(n) time and uses only constant extra space.
       Example 1:
       Input: nums = [4,3,2,7,8,2,3,1]
       Output: [2,3]
	 */

//Approach -> works because number range [1..n] So array indices can be used as flag to mark that element has already
	//appeared
	
    public List<Integer> findDuplicates(int[] nums) {
    
    	List<Integer> ans = new ArrayList<>();
    	
    	for(int i = 0; i< nums.length; i++) {
    		
    		int a = Math.abs(nums[i]);
    		
    		if(nums[a-1] < 0)
    			ans.add(a);
    		
    		nums[a-1] = -nums[a-1];
    	}
    	return ans;
    }
    
    
	public static void main(String[] args) {
		
	}

}
