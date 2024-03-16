package threepointers;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortColors {
	
   public static void sortColors(int[] nums) {
	   
	   int l = 0, m=0, h= nums.length-1;
	   
	   while(m<=h) {
		   Arrays.stream(nums).forEach(System.out::print);
		  System.out.println(" --- ");
		   if(nums[m] == 0) {
			   swap(l, m, nums);
			   l++;
			   m++;
		   }
		   
		   else if(nums[m] == 1)
			   m++;
		   
		   else if(nums[m] == 2) {
			   swap(m, h, nums);
			   h--;
		   }  
	   }
    }

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
    }

	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		sortColors(nums);
		
		Arrays.stream(nums).forEach(System.out::print);
		//System.out.println(Stream.of(nums).);

	}

}
