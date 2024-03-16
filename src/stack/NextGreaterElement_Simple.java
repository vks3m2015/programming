package stack;

import java.util.Arrays;
import java.util.Stack;

//Description - https://www.geeksforgeeks.org/next-greater-element/

//In - [8,4,7,10] out - [10,7,10,-1]
public class NextGreaterElement_Simple {

	
	//traversing nums arr from left to right. we can also traverse from right to left
	public static int[] nextGreaterElement(int[] nums) {
		
		int[] output = new int[nums.length];
		Stack<Integer> stack = new Stack<>();  //storing indices of elements of nums
		
		for(int i = 0; i < nums.length; i++) {
			
			while(!stack.empty() && nums[i] > nums[stack.peek()]) {
				output[stack.pop()] = nums[i];
				//System.out.println("while");
			}
			stack.push(i);
		}
		
		while(!stack.empty()) {
			output[stack.pop()] = -1;
			//System.out.println("while");
		}
		
		return output;
	}
	
	
	
	public static void main(String[] args) {
         int[] nums = {8,4,7,10};
         int[] output = nextGreaterElement(nums);
         
         System.out.println(Arrays.toString(output));
		
		
	}

}
