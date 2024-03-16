package sorting;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
public class TargetIndicesAfterSorting {

    public List<Integer> targetIndices(int[] nums, int target) {
        
    	int lessThan = 0, equals = 0;   //less than target and equal to target
    	for(int i =0; i< nums.length; i++) {
    		if(nums[i]< target) lessThan++;
    		if(nums[i] == target) equals++;
    	}
    	
    	List<Integer> result = new ArrayList<>();
    	for(int i = 1; i<=equals; i++) {
    		result.add(i + lessThan -1);
    	}
    	return result;
    } 
    
	public static void main(String[] args) {

	}

}
