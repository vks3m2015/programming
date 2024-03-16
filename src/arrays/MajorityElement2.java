package arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

	public static List<Integer> majorityElement(int[] nums) {
		
        int candidate1 = -1, candidate2= -1, count1 = 0, count2 = 0;

        for (int num : nums) {
            
            if(num == candidate1) {
            	count1++;
           
            }else if(num == candidate2) {
            	count2++;
            
            }else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            
            }else if(count2 == 0){
            	candidate2 = num;
            	count2 = 1;
            
            }else {
            	count1--;
            	count2--;
            	
            }	
        }

        //Checking the count of candidates key from above
        List<Integer> ans = new ArrayList<>();
        count1 = 0; count2 = 0;
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] == candidate1)
            count1++;
          else if(nums[i] == candidate2)
        	count2++;
        }
        
        if (count1 > (nums.length / 3))
          ans.add(candidate1);
          
        if (count2 > (nums.length / 3))
           ans.add(candidate2);
        
        return ans;
    }
	
	public static void main(String[] args) {
		int[] arr = {2,1,1,3,1,4,5,6};  //ans - 1
		int[] arr1 = {3,2,3};   // ans - 3
		int[] arr2 = {1};     //ans - 1
		int[] arr3 = {1,2};  //ans - 1,2

	}

}
