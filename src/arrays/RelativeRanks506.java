package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/relative-ranks/description/?envType=problem-list-v2&envId=array
/*
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.

Example 1:
Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 */
public class RelativeRanks506 {

    public static void main(String[] args) {

        int[] score = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    public static String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] ans = new String[n];

        int[][] score_positions = new int[n][2];

        for (int i = 0; i < n; i++) {
            score_positions[i][0] = score[i];
            score_positions[i][1] = i;
        }

        Arrays.sort(score_positions, (a, b) -> b[0] - a[0]);

        System.out.println(Arrays.deepToString(score_positions));

        for (int i = 0; i < n; i++) {
            int index = score_positions[i][1];

            if (i == 0) {
                ans[index] = "Gold Medal";
            } else if (i == 1) {
                ans[index] = "Silver Medal";
            } else if (i == 2) {
                ans[index] = "Bronze Medal";
            } else {
                ans[index] = String.valueOf(i + 1);
            }
        }

        return ans;

    }

    public static String[] findRelativeRanksUsingMaxHeap(int[] score) {

        int n = score.length;
        String[] ans = new String[n];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] - p1[1]);

        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{score[i], i});
        }

        int rank = 1;

        while (!maxHeap.isEmpty()) {

            int[] entry = maxHeap.poll();

            if (rank == 0) {
                ans[entry[1]] = "Gold Medal";
            } else if (rank == 2) {
                ans[entry[1]] = "Silver Medal";
            } else if (rank == 3) {
                ans[entry[1]] = "Bronze Medal";
            } else {
                ans[entry[1]] = String.valueOf(rank);
            }

            rank++;
        }
        return ans;

    }
}
