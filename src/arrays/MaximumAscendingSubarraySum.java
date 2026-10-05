package arrays;

//https://leetcode.com/problems/maximum-ascending-subarray-sum/description/

public class MaximumAscendingSubarraySum {

    public static void main(String[] args) {

        int[] nums = {10,20,30,40,50};
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {

        int maxSum = nums[0], currSum = nums[0];
        for(int i = 1; i < nums.length; i++){

            if(nums[i-1] < nums[i]){
                currSum+= nums[i];
                //System.out.println(" currSum = "+ currSum);
            } else {
                currSum = nums[i];
               // System.out.println(" currSum2 = "+ currSum);

            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
