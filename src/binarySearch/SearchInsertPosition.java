package binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
	
   public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = 0;
        if(target > nums[end]) return nums.length;
        while(start < end) {
        	mid = start + (end - start)/2;
        	if( target > nums[mid])
        	    start = mid + 1;
        	else 
        	    end = mid;
        }
        return start;
    }
   
	public static int searchInsert1(int[] nums, int target) {
		int start = 0, end = nums.length - 1, mid = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;

			if (target == nums[mid])
				return mid;
			else if (target < nums[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return start;
	}
   
   //WRONG IMPLEMENTATION
   public static int searchInsert2(int[] nums, int target) {
       int start = 0, end = nums.length-1, mid = 0;
       
       if(target > nums[end]) return nums.length;
       
       while(start < end) {
    	   mid = start + (end - start)/2;
        	if( target < nums[mid])
       	       end = mid -1 ;
         	else 
       	       start = mid; //due to this infinite loop. Ex -  arr = {5,6} and target = 5
       }
       
     //System.out.println(" start = "+ start + "--- end = "+ end +"    mid = "+mid);
       return start;
   }

   
   
   
	public static void main(String[] args) {
		int[] arr = {1,3,5,6}; 
		print(arr, 2, searchInsert1(arr, 2)) ;
		print(arr, 5, searchInsert1(arr, 5)) ;
		print(arr, 7, searchInsert1(arr, 7)) ;
		print(arr, 0, searchInsert1(arr, 0)) ;
	}
	
	public static void print(int[] arr, int target, int ans) {
		System.out.println("arr= "+ Arrays.toString(arr)+ " target = "+ target + " index = "+ ans);
	}

}
