package arrays.bitManipulation;

//https://leetcode.com/problems/single-number-ii/
//Sol - https://www.youtube.com/watch?v=cOFAmaMBVps
public class SingleNumber2_TODO {

	
	//Approach - Sort array
	//t-> O(nlogn)
	public static int singleNumber2(int[] nums) {
		return 0;
	}
	
	
	//Approach - sum of 1's at each position of number in its binary representation. This sum will be either multiple of 3 or sum%3 = 1.
	//If sum is multiple of 0 then at that position of the single number is 0 else 1
	//t-> O(32*n) (this is not O(n))
	 public static int singleNumber(int[] nums) {
		 int ans = 0;
		 int shift = 1;
		 for(int i = 1; i<= 32; i++) {
			 
			 int count1 = 0;
			 for(int num: nums) {
				 
				 //find that bit at position shift is set (1) or unset (0)
				 if((num & shift) != 0) {  
					 count1++;
				 }
			 }
			 
			 if(count1 % 3 == 1)
				ans = ans + shift;
			 
			 shift = shift<<1;
		 }
	   return ans;     
    }  
	 
	public static void main(String[] args) {
		int[] nums = {0,1,0,1,0,1,99};
		System.out.println(singleNumber(nums));
		

	}

}
