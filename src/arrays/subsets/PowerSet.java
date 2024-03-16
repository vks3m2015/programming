package arrays.subsets;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
//Given an integer array nums of unique elements, return all possible subsets (the power set).

//Sol - https://www.youtube.com/watch?v=REOH22Xwdkk

//Make decision tree 
public class PowerSet {
	
	static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

	//Recursive Approach
	public static void subsets(int[] nums, int currIndex,  ArrayList<Integer> currSet){
		
		if(currIndex == nums.length) {
			ans.add(new ArrayList<>(currSet));
			return;
		}
		
	    //Include Current Index Element
		currSet.add(nums[currIndex]);
		subsets(nums, currIndex +1, currSet);
		
		//Exclude Current Index Element
	   currSet.remove(currSet.size() -1 );
	   subsets(nums, currIndex +1, currSet);
	}
	
	public static void main(String[] args) {
     
		int[] nums = {1,2,3};
		subsets(nums, 0, new ArrayList<Integer>());
		
		for(ArrayList<Integer> set : ans)
			System.out.println("set == "+set);
	}
}