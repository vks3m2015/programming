package binarySearch.rotatedArray ;

import java.util.Arrays;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int minIndex = searchMinIndex(nums);
        
      //  System.out.println(" minIndex = "+ minIndex);
        int left = 0, right = nums.length -1;
        
       // if(target == nums[minIndex]) return minIndex;
       
        if(target >= nums[minIndex] && target <= nums[right])
    	     left = minIndex;
        else
        	 right = minIndex -1;
        
       // System.out.println(" left = "+ left + " right ="+ right);
        return searchInSortedArray(nums, left, right, target);
    }
    
    public static int searchMinIndex(int[] nums) {
    	
    	int left = 0, right = nums.length -1, mid;
    	
    	while(left < right) {
    		mid = left + (right - left )/2;
    		
    		if(nums[mid] > nums[right])
    		   left = mid + 1;
    		else
    			right = mid;
    	}
    	return left;
    }
    
    public static int searchInSortedArray(int[] nums, int left, int right, int target) {
           
    	while(left <= right) {
        	
        	int mid = left + (right - left )/2;
        	
        	if(nums[mid] == target)
        		return mid;
        	else if(nums[mid] < target)
        		left = mid + 1;
        	else
        		right = mid -1;
        }
         return -1;
    }
	
	public static void main(String[] args) {
		int[] arr = {1};
		printResult(arr, 2, search(arr, 2));
		
		int[] arr1 = {1, 3};
		printResult(arr1, 3, search(arr1, 3));
		
		int[] arr2 = {4,5,6,7,0,1,2};
		printResult(arr2, 0, search(arr2, 0));
		

	}
	
	public static void printResult(int[] nums, int target, int index) {
		System.out.println(" Arr = "+ Arrays.toString(nums) + "\n search key = " + target + "\n Found at index = "+ index);
	    System.out.println();
	}

}
