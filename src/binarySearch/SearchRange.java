package binarySearch;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
/*
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
    	
    	int[] result = {-1, -1};
    	
    	if (nums == null || nums.length == 0)
			return result;
					
    	result[0] = binarySearch_LeftRightMost(nums, 10, true);
    	result[1] = binarySearch_LeftRightMost(nums, 10, false);
		return result;
    }
    
    //we can have two different method also for LeftMost and rightMost. Below is single method with adjustment using flag
   static int binarySearch_LeftRightMost(int[] arr, int key, boolean leftMost) {
    	
    	int left = 0, right = arr.length -1;
    	
    	int startIndex = -1;
    	
    	while(left <= right) {
    		System.out.println("in while left ="+left + "   right ="+right);
    		int mid = left + (right -left)/2;
    		
    		if(arr[mid] == key) {
    		  startIndex = mid;	
    		  
    		  if(leftMost)
                 right = mid - 1;
    		  else
    			 left = mid + 1;
    			
    		}else if(arr[mid] > key) 
    			right = mid -1;
    		
    		else 
    			left = mid +1;
    		
    	}
		return startIndex;
    }
    
    public static void main(String[] args) {
    	
        int[] arr = {3,6,10,10,13};
    	int leftMostIndex = binarySearch_LeftRightMost(arr, 10, true);
    	int rightMostIndex = binarySearch_LeftRightMost(arr, 10, false);
    	System.out.println(leftMostIndex);
    	System.out.println(rightMostIndex);
	}
    
    
  static int binarySearch(int[] arr, int key) {
    	
    	int left = 0, right = arr.length -1;
    	
    	while(left <= right) {
    		
    		int mid = left + (right -left)/2;
    		
    		if(arr[mid] == key) {
    			return mid;
    		
    		}else if(arr[mid] > key) {
    			right = mid -1;
    		
    		}else {
    			left = mid +1;
    		}
    	}
		return -1;
    }

}
