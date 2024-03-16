package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Sol - https://www.youtube.com/watch?v=j48e8ac7r20&t=309s
//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
/*
 * Given an array of integers and a number K. Find the count of distinct elements in every window 
 * of size K in the array.
Example 1:
Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
Explanation: Window 1 of size k = 4 is
1 2 1 3. Number of distinct elements in
this window are 3
 */

public class DistictElementsInAWindow {

	
	public static ArrayList<Integer> countDistinct(int nums[], int length, int k){
	
		ArrayList<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> countMap = new HashMap<>();
		
		for(int i =0; i<k; i++) {
			countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
		}
		
		ans.add(countMap.size());
		
		for(int i=k; i< length; i++) {
			
			if(countMap.get(nums[i-k])== 1) {
				countMap.remove(nums[i-k]);
			}else {
				
				countMap.put(nums[i-k], countMap.get(nums[i-k])-1);
			}
			
			countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
			ans.add(countMap.size());
		}
		
		return ans;
    }
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,1,3,4,2,3};
		ArrayList<Integer> ans = countDistinct(nums, 7, 4);  // ans - 3 4 4 3
		
		System.out.println(ans);
	}

}
