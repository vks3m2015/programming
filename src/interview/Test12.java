package interview;

public class Test12 {

	/*
	 * Problem Statement # Given an array of positive numbers and a positive number
	 * �k,� find the maximum sum of any contiguous subarray of size �k�. Example 1:
	 * Input: [2, 1, 5, 1, 3, 2], k=3 Output: 9 Explanation: Subarray with maximum
	 * sum is [5, 1, 3]. Example 2: Input: [2, 3, 4, 1, 5], k=2 Output: 7
	 * Explanation: Subarray with maximum sum is [3, 4].
	 */
	
	public static void main(String[] args) {
     
		int[] arr = {2,1,5,1,3,2}; int k =3;
		System.out.println(maxSum2(arr, k));

	}
	
	/*
	 * int maxSum(int[] arr, int k) {
	 * 
	 * int count = 0, sum =0, maxSum = 0 ;
	 * 
	 * for(int i = 0; i< k; i++) { sum = sum + arr[i]; }
	 * 
	 * maxSum = sum; for(int i = k; i<arr.length; i++) {
	 * 
	 * }
	 * 
	 * }
	 */
	
    public static int maxSum2(int[] arr, int k) {
		
		int count = 0, maxSum = 0 ;
		
		for(int i = 0; i< arr.length - k; i++) {
			
			int sum = 0;
			for(int j = i ; j < j+k; j++) {
				sum = sum + arr[j];
			}
			
			if(sum > maxSum) {
				maxSum = sum;
			}	
		}
		
		return maxSum;
	}

}
