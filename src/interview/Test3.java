package interview;

public class Test3 {

	public static void main(String[] args) {
		
	}

   public static int removeDuplicates(int[] nums) {
        
	   int slow = 0;
	   
	   for(int fast = 1; fast < nums.length; fast++) {
		   
		   if(nums[fast] != nums[slow]) {
			   nums[++slow] = nums[fast];
		   }
		   
	   }
	  return slow;
	   
    }
}
