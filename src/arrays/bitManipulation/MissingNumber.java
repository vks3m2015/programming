package arrays.bitManipulation;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {

	//Approach - 1
	//Idea - a^a = 0 if we do xor of a number from itself it return 0
	 public int missingNumber(int[] nums) {

	    	int arrLength = nums.length;
	    	int xor = arrLength;
	    	for(int i=0; i<arrLength; i++) {
	    		xor = xor ^ i ^ nums[i];   // a^a^b = b
	    	}
			return  xor;
	    }
	 
	 
	//Approach-2 
	//Idea - Sum of 1..n integers should be n(n+1)/2 
    public int missingNumber2(int[] nums) {

    	int arrLength = nums.length;
    	int arrSum = 0;
    	for(int i=0; i<arrLength; i++) {
    		arrSum += nums[i];
    	}
		return  arrLength * ( arrLength + 1) / 2 - arrSum;
    }
    
    //Just code optimization of above approach
    public int missingNumber2_1(int[] nums) {
    	
    	int arrSum = nums.length;
    	for(int i=0; i< nums.length; i++) {
    		arrSum = arrSum + i -  nums[i];
    	}
		return arrSum;
    }
    
   
    
    
    
	public static void main(String[] args) {

	}

}
