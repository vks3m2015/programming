package stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/description/
//Search in Rotated array
public class NextGreaterElementII {

	// Traversal of array from left to right
	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] output = new int[n];
		Arrays.fill(output, -1);
		Stack<Integer> stack = new Stack<>(); // store index

		for (int i = 0; i < 2 * n; i++) {

			while (!stack.empty() && nums[i % n] > nums[stack.peek()]) {
				output[stack.pop()] = nums[i % n];
			}

			stack.push(i % n);

			System.out.println("i = " + i + " output arr = " + Arrays.toString(output));
			System.out.println(" stack = " + stack.toString());

		}
		/*
		 * while (!stack.empty()) { output[stack.pop()] = -1; }
		 */
		return output;
	}

	//Other way
	// Traversal of array from right to left
	public int[] nextGreaterElements2(int[] nums) {
		int[] res = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * nums.length - 1; i >= 0; --i) {
			while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop();
			}
			res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
			stack.push(i % nums.length);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 }; // {2,3,4,5,-1}
		int[] nums1 = { 1, 2, 1 }; // {2,-1,2}
		int[] output = nextGreaterElements(nums1);

		System.out.println(Arrays.toString(output));

	}

}
