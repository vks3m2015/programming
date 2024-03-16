package arrays;

//https://leetcode.com/problems/contiguous-array/
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
     
    	int zeros = 0, ones = 0;
    	for(int num : nums) {
    		if(num == 0)  
    			zeros++ ;
    		else
    			ones++;
    	}
    	
    	int left = 0, right = nums.length -1;
    	while(left < right) {
    		
    		if(ones == zeros) {
    			return right - left + 1;
    		}
    		
    		else if(ones> zeros) {
    			if(nums[left] == 1) {
    				left++;
    				ones--;
    			}else if(nums[right] == 1) {
    				right--;
    				ones--;
    			}else {
    				left++;
    				zeros--;
    			}
    		}
    		
    		else if(ones < zeros) {
    			if(nums[left] == 0) {
    				left++;
    				zeros--;
    			}else if(nums[right] == 0) {
    				right--;
    				zeros--;
    			}else {
    				left++;
    				ones--;
    			}
    		}
    	}
    	return 0;
    	
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,1,0,1,1,1,0};   //4
		System.out.println(findMaxLength(nums));

	}

}
