package binarySearch.rotatedArray;

import java.util.Arrays;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinimumInRotatedSortedArray {

   public static int findMin(int[] nums) {
        int left = 0, right = nums.length -1, mid;
        
        while(left < right) {
        	mid = left + (right - left )/2;
        	
        	if(nums[mid] > nums[right])
        		left = mid + 1;
        	else
        		right = mid;
        }
        return nums[left];
    }
	
	public static void main(String[] args) {
		int[] arr = {3,4,5,1,2};
		print(arr);

	}
	
	public static void print(int[] arr) {
		System.out.println(" Arr = "+ Arrays.toString(arr)+ "  Min = "+ findMin(arr));
	}

}
