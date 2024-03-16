package arrays;

import java.util.Arrays;

public class MajorityElement {

	/*
	 * https://leetcode.com/problems/majority-element/
	 * Given an array nums of size n, return the majority element. The majority element is the element that appears more than n / 2 times. You may assume that the majority element always exists in the array.
	 * Ex - Input: nums = [2,2,1,1,1,2,2]  Output: 2
	 */
	
	
	// Boyer-Moore Voting Algorithm   t-> O(n)  s->O(1)
	public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        //Count the count of candidate
        count = 0;
        for (int index = 0; index < nums.length; index++) {
          if (nums[index] == candidate)
            count++;
        }
        if (count > (nums.length / 2))
          return candidate;
        
        return -1;
    }
	
	//Sorting approach t-> O(nlgn) s-> O(1) or O(n)
	static int majorityElement_2(int[] nums) {
		Arrays.sort(nums);
		int candidate = nums[nums.length / 2];

		int count = 0;
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] == candidate)
				count++;
		}
		if (count > (nums.length / 2))
			return candidate;

		return -1;
	}
	
	//Divide and Conquer Approach t-> O(nlgn) s-> O(lgn)
	public static int majorityElement_3(int[] nums) {
		return majorityElementRec(nums, 0, nums.length-1);
	}
	
	public static int majorityElementRec(int[] nums, int lo, int hi) {
		
		if(lo == hi) {
		   return nums[lo];	
		}
		
		int mid = lo + (hi - lo) /2;
		int leftMajorityElement = majorityElementRec(nums, lo, mid);
		int rightMajorityElement = majorityElementRec(nums, mid+1, hi);
		
		if(leftMajorityElement == rightMajorityElement)
			return leftMajorityElement;
		
		int leftCount = countOfElementInArray(nums, leftMajorityElement, lo, hi);
		int righCount = countOfElementInArray(nums, rightMajorityElement, lo, hi);
		
		return leftCount > righCount ? leftMajorityElement : rightMajorityElement;
	}
	
	private static int countOfElementInArray(int[] arr, int num, int lo, int hi) {
		int count = 0;
		for(int i = lo; i<= hi; i++) {
			if(num == arr[i])
			  count++;
		}
		return count;
	}
	
	//HashMap Approach
	public static int majorityElement_4(int[] nums) {
		return -1;
	}
	
	public static void main(String[] args) {
		

	}

}
 