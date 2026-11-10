package slidingWindow.variableSize;

//https://leetcode.com/problems/minimum-size-subarray-sum/
/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {


    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(target, nums));

    }


    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Expand window
            sum += nums[right];

            // Shrink window while sum >= target
            while (sum >= target) {

                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    //O(n log n)
    public int minSubArrayLenPrefixSumAndBinarySearch(int target, int[] nums) {

        int n = nums.length;

        // Step 1: Build prefix sum array
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;

        // Step 2: Iterate over every starting index
        for (int i = 0; i < n; i++) {

            // Required prefix sum
            long requiredSum = prefix[i] + target;

            // Step 3: Binary search for smallest valid end index
            int end = lowerBound(prefix, i + 1, n + 1, requiredSum);

            // Step 4: Check if a valid subarray exists
            if (end <= n) {
                minLength = Math.min(minLength, end - i);
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Find the first index where arr[index] >= target
    private int lowerBound(long[] arr, int left, int right, long target) {

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    public int minSubArrayLen2(int target, int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int startIdx = 0, endIdx = 0, winSum = 0, minLen = Integer.MAX_VALUE;

        while (startIdx < nums.length) {

            winSum += nums[endIdx];
            endIdx++;

            while (winSum > target) {
                minLen = Math.min(minLen, endIdx - startIdx);
                winSum -= nums[startIdx];
                startIdx++;
            }
        }
        return minLen;
    }
}
