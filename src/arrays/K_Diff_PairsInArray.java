package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/k-diff-pairs-in-an-array/
/*
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
nums[i] - nums[j] == k
Notice that |val| denotes the absolute value of val.

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
 */
public class K_Diff_PairsInArray {
	
	//HashMap Approach
	// t-> O(n)
	 public static int findPairs1(int[] nums, int k) {
		 int count = 0;
		 Map<Integer, Integer> countMap = new HashMap<>();
		 
		 for(int num : nums)
			 countMap.put(num, countMap.getOrDefault(num, 0)+1);
		 
		 for(int key : countMap.keySet()) {
			 
			 if(k > 0 && countMap.containsKey(key + k) || k == 0 && countMap.get(key)> 1)
				 count++;
		 }
		 return count;
	 }
	
	
	//BinarySerach Approach
	//t-> O(nlgn) exetime - 12ms
    public static int findPairs2(int[] nums, int k) {
    	Arrays.sort(nums);
    	int count = 0;
    	for(int i = 0; i< nums.length-1; i++) {

            //If duplicates
            if (i != 0 && nums[i] == nums[i - 1])continue;
    		
    		if(binarySerach(nums, i+1, nums.length-1, nums[i] + k))
    		 count++;
    	}
		return count;
    }
    
    static boolean binarySerach(int[] nums, int startIndex, int endIndex, int key){
    	
    	if(startIndex > endIndex)
    		return false;
    	
    	int midIndex = startIndex + (endIndex- startIndex)/2 ;
    	if(nums[midIndex] == key ) {
    		return true;
    	}else if(nums[midIndex] > key) {
    		return binarySerach(nums, startIndex, midIndex-1, key);
    	}else {
    		return binarySerach(nums, midIndex+1, endIndex, key);
    	}
    }

	public static void main(String[] args) {
          int[] nums = {3,1,4,1,5} ; int k = 2;   //count = 2 
          int[] nums2 = {1,3,1,5,4}; int k1 = 0;  //count = 1 (1,1)
	}

}
