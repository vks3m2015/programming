package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/remove-element/

/* Similar
 * @see MoveZerosAtEnd
 * @see RemoveDuplicatesFromSortedArray
 * @see RemoveElement
 * @see RemoveLinkedListElements
 */

public class RemoveElement {

	//Easy Impl
	public int removeElement2(int[] nums, int val) {
		int m = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != val) {
				nums[m] = nums[i];
				m++;
			}
		}
		return m;
	}

	// Self -Correct
	public int removeElement(int[] nums, int val) {

		int start = 0, end = nums.length - 1;

		while (start < end) {

			while (nums[start] != val)
				start++;

			// System.out.println("start 1 = "+ start); System.out.println("start & end
			// values = "+ start +", "+ end);

			while (nums[end] == val)
				end--;

			System.out.println("===========================");
			System.out.println("arr = " + Arrays.toString(nums));
			System.out.println("start & end values = " + start + ", " + end);

			if (start < end) {
				int temp;
				temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}

			// nums[start++] = nums[end--];

			System.out.println("After swap arr = " + Arrays.toString(nums));
			// System.out.println("1.start & end values = "+ start +", "+ end);
		}
		return start - 1;

	}

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();

		int[] arr = { 3, 2, 2, 3 };
		int[] arr1 = { 3, 2, 2, 3, 4, 6, 3, 8, 3 };
		int[] arr2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int k = re.removeElement(arr2, 2);
		System.out.println(k);

	}

}
