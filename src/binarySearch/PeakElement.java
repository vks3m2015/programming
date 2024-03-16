package binarySearch;

//https://leetcode.com/problems/find-peak-element/
public class PeakElement {

	
	//O(lgn) - Binary Scan
	public static int findPeakElement(int[] nums) {

		int right = nums.length - 1, left = 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1])
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}
	
	//O(n) - Linear Scan
	public static int findPeakElement2(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
	}

	 
	public static void main(String[] args) {
		int[] arr = {1,2,3,1};
		int idx = findPeakElement(arr);
		System.out.println(arr[idx]);

	}

}
