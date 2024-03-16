package arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
/*
 * Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j 
 * such that |nums[i] - nums[j]| == k.
 */
public class Abs_Diff {

	public static int countKDifference(int[] nums, int k) {
        int count = 0;
		 Map<Integer, Integer> countMap = new HashMap<>();
		 
		 for(int num : nums)
			 countMap.put(num, countMap.getOrDefault(num, 0)+1);
		 
		 for(int key : countMap.keySet()) {
			 
			 if(countMap.containsKey(key + k) )
				 count = count + ( countMap.get(key) * countMap.get(key + k));
		 }
		 return count;
       
   }
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,4};
		int k = 2;
		
		int count = countKDifference(nums, k);
		
		System.out.println(count);

	}

}
