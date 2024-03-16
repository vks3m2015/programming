package sorting;

import java.util.Arrays;
import java.util.Collections;

//https://leetcode.com/problems/largest-number/
public class LargestNumber {

	
	
    public static String largestNumber(int[] nums) {
    	if(nums == null || nums.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
		    s_num[i] = String.valueOf(nums[i]);
			
		// Comparator to decide which string should come first in concatenation
		Arrays.sort(s_num, (str1, str2) -> {
			 String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
		});
		
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
		if(s_num[0].charAt(0) == '0')
			return "0";
            
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	        sb.append(s);
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		int[] nums = {3,30,34,5,9};   //ans - 9534330
		int[] nums1 = {10, 2};
		System.out.println(largestNumber(nums));
		System.out.println(largestNumber(nums1));

	}

}
