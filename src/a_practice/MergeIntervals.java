package a_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {

    public static void main(String[] args) {

    }

   List<int[]> mergeInt(int[][] arr){

      Arrays.sort(arr, (a,b) -> a[0]-b[0]);

      List<int[]> ans = new ArrayList<>();
      ans.add(arr[0]);

      for(int i=1; i<arr.length; i++){

          int[] last = ans.getLast();

          if( arr[i][0] <= last[1]){
              last[1] = Math.max(arr[i][1], last[1]);

          }else{
              ans.add(arr[i]);
          }
      }
      return ans;
    }
}
