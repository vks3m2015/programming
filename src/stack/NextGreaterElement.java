package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
//Sol - https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
public class NextGreaterElement {

   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	   
	   Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
	  
	   Stack<Integer> stack = new Stack<>();
	   
	   for(int num : nums2) {
		   
		   while(!stack.isEmpty() && num > stack.peek()) {
			   map.put(stack.pop(), num);
		   }
		   stack.push(num);
	   }

	   for (int i = 0; i < nums1.length; i++)
		   nums1[i] = map.getOrDefault(nums1[i], -1);
       return nums1;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
