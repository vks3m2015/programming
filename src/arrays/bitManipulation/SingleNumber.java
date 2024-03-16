package arrays.bitManipulation;

//https://leetcode.com/problems/single-number/
public class SingleNumber {

	//XOR Operation
    public int singleNumber(int[] nums) {
       int ans=0;
	   for(int x:nums)
	   ans^=x;
	   return ans;
    }
    
	public static void main(String[] args) {

	}

}
