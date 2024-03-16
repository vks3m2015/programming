package arrays;

//https://leetcode.com/problems/single-element-in-a-sorted-array/
/*
 * You are given a sorted array consisting of only integers where every element appears exactly twice, 
 * except for one element which appears exactly once.
   Return the single element that appears only once.
   
   Input: nums = [1,1,2,3,3,4,4,8,8]
   Output: 2
 */
public class SingleNumberSortedArray {

	
	
	//Linear Scan
    public int singleNonDuplicate(int[] nums) {
        
    	for(int i =0; i< nums.length -2; i = i+ 2) {
    		 
    		if(nums[i] != nums[i+1])
    			return nums[i];
    	}
    	return nums[nums.length-1];
    }
    
    //XOR 
    public int singleNonDuplicate2(int[] nums) {
        int ans=0;
 	   for(int x:nums)
 	   ans^=x;
 	   return ans;
     }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
