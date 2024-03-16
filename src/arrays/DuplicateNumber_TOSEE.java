package arrays;

//https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumber_TOSEE {

	//Approach - Cycle Detection in Linked List - TOSEE
	//https://leetcode.com/problems/find-the-duplicate-number/solution/
	
	//Bucketing Approach
	public int findDuplicate(int[] nums) {
		
		int[] bucket = new int[nums.length];
    	for(int i=0; i< nums.length; i++) {
    		bucket[nums[i]]++;
    	}
    	
    	for(int i=0; i< bucket.length; i++) {
    		if(bucket[i] > 0) return i;
    	}
		return -1;
    }
	
	//Approach - Negative Marking
    public int findDuplicate2(int[] nums) {
		
		int duplicate = -1;
    	for(int i=0; i< nums.length; i++) {
    		int curr = Math.abs(nums[i]);
    		if(nums[curr] < 0) {
    			duplicate = curr;
    			break;
    		}	
    		nums[curr] *= -1;
    	}
    	
    	//restore array
    	for(int i=0; i< nums.length; i++) {
    		nums[i] = Math.abs(nums[i]);
    	}
		return duplicate;
    }
	
    //Approach - Sort Array and compare adjacent elements
    
    //Approach - Use Set
    
    //Approach - Place a element in array at its index. i.e place 3 to at index 3 in array. And 
    public int findDuplicate3(int[] nums) {
    	return placeNumToIndex(nums, 0 );
    }
    
    
    int placeNumToIndex(int[] nums, int num) {
    	
    	 if (num == nums[num])
             return num;
    	 
    	int nextNum = nums[num];
    	nums[num] = num;
    	
    	return placeNumToIndex(nums, nextNum);
    }
    
   
	
	public static void main(String[] args) {

	}

}
