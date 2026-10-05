package arrays.subarray;
/*
Given an array of POSITIVE integer numbers and an integer k, find the length of the longest subarray whose sum is less than or equal to k.
Ex. 1 Input: arr = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8
Output: 5 [3, 1, 2, 1, 1]

Ex. 2 Input: arr = [10, 2, 5, 7, 1, 9] and k = 15
Output: 4 [2,5,7,1]
 */
public class LongestSubarraySumK {

    public static void main(String[] args) {

    }

    int longestSubarrayK(int[] arr, int k){

        int maxLen = Integer.MIN_VALUE;
        int currSum = 0;

        int left = 0;
        for(int right = 0; right < arr.length; right++){

            currSum = currSum + arr[right];

            while(currSum > k){
                currSum = currSum - arr[left];
                left++;
            }

            maxLen = Math.max(maxLen, right-left + 1);

        }
       return maxLen;
    }
}
