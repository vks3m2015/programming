package arrays;

//https://leetcode.com/problems/move-zeroes/
//Sol - https://www.youtube.com/watch?v=1PEncepEIoE

/* Similar
 * @see MoveZerosAtEnd
 * @see RemoveDuplicatesFromSortedArray
 * @see RemoveElement
 */
public class MoveZerosAtEnd {
	
    public void moveZeroes(int[] nums) {
    	
    	int slow =0;
    	for(int fast = 0; fast< nums.length; fast++) {
    		
    		//Can do swapping here also
    		if(nums[fast] != 0) {
    			nums[slow++] = nums[fast];
    		}
    	}
    	
    	for(int i = slow; i< nums.length; i++) {
    		nums[i] = 0;
    	}
        
    }
    
	public static void main(String[] args) {
		

	}

}
