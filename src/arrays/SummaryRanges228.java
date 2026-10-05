package arrays;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/summary-ranges/description/?envType=problem-list-v2&envId=array
/*
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
 */

public class SummaryRanges228 {

    public static void main(String[] args) {
      int[] arr = {0,1,2,4,5,7};
     // arr = new int[]{0, 2, 3, 4, 6, 8, 9};
        arr = new int[]{-2, -1, 3};

        System.out.println(summaryRanges(arr));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int n = nums.length;

        if (n == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i < n; i++) {

            // Gap found
            if (nums[i] != nums[i - 1] + 1) {

                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }

                // Start a new range
                start = nums[i];
            }
        }

        // Add the last range
        if (start == nums[n - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[n - 1]);
        }

        return result;
    }
}
