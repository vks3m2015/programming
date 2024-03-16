package twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {
	
	//Filling result arr from End
	 public static int[] sortedSquares(int[] nums) {
	       int[] result = new int[nums.length];
	       int left = 0, right = nums.length-1;
	       int resIndex = nums.length-1;
	       
	       while(left <= right){
	           if(Math.abs(nums[left]) > Math.abs(nums[right])){
	               result[resIndex--] = nums[left]*nums[left];
	               left++;
	           }else{
	               result[resIndex--] = nums[right]*nums[right];
	               right--;
	           }
	       }
	       return result;
	}

	 //Another Approach. Filling result arr from beginning
    public static int[] sortedSquares2(int[] nums) {
    	
    	int len = nums.length, left, right, ansPtr=0;
    	int[] result = new int[len];
    	
    	int index = searchFirstPositive(nums);
    	if(nums[index] == 0) {
    		result[0] = 0;
    		ansPtr++; 
    		left = index - 1;
    		right = index + 1;
    	}else {
    		left = index -1;
    		right = index;
    	}
    	
    	while(left >= 0 && right < len) {
    		if(Math.abs(nums[left]) <= Math.abs(nums[right])){
    			result[ansPtr++] = nums[left] * nums[left]; 
    			left--;
    		
    		}else {
    			result[ansPtr++] = nums[right] * nums[right]; 
    			right++;
    		}
    	}
    	
    	while(left >= 0) {
    		result[ansPtr++] = nums[left] * nums[left]; 
			left--;
    	}
    	
    	while(right < len) {
    		result[ansPtr++] = nums[right] * nums[right]; 
			right++;
    	}
		return result;
        
    }
    
    public static int searchFirstPositive(int[] nums) {
    	int start = 0, end = nums.length-1, mid = 0;
    	while(start < end) {
    		mid = start + (end - start)/2;
    		if(nums[mid] == 0) return mid;
    		else if(nums[mid] > 0)
    			 end = mid;
    		else
    			start = mid + 1;
    	}
    	return start;
    }

	public static void main(String[] args) {

		int[] arr = {-7,-3,2,3,11};
		
		// int[] arr = {-4,-1,0,3,10};
		System.out.println(Arrays.toString(sortedSquares(arr)));
	}

}
