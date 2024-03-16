package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ContainsDuplicate {
	
   public static boolean containsDuplicate(int[] nums) {
        
        final Set<Integer> hs = new HashSet<Integer>();
        
        for(int num : nums) {
        	if(hs.contains(num)) {
        		return true;
        	}
        	hs.add(num);
        }
        return false;
    }
   
   public static boolean containsDuplicate2(int[] nums) {
	   
	   Arrays.sort(nums);
	   for(int i= 1; i<nums.length; i++) {
		   if(nums[i] == nums[i-1] ) {
			   return true;
		   }
	   }
	   return false;
   }
   
   //Java8
   public static boolean containsDuplicate3(int[] nums) {
	   
	   return nums.length != Stream.of(nums).distinct().count();
	   
	   /*
	    * Set<Integer> seen = new HashSet<>();
    return Arrays.stream(nums).anyMatch(num -> !seen.add(num));
	    */
   }
   
	public static void main(String[] args) {
		
		int[] arr = {2,3,1,9,6,9};
		System.out.println(containsDuplicate(arr));

	}

}
