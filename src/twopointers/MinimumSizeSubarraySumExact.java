package twopointers;

public class MinimumSizeSubarraySumExact {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2,8, 4, 3};

        System.out.println( minSubArraySumEqualsTarget(target, nums));
    }

    public static int minSubArraySumEqualsTarget(int target, int[] nums) {

        int left = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            windowSum += nums[right];

            // Since all numbers are positive,
            // shrink while sum is greater than target
            while (windowSum > target) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == target) {
                minLength = Math.min(
                        minLength,
                        right - left + 1
                );
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
