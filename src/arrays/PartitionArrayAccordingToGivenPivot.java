package arrays;

//https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
public class PartitionArrayAccordingToGivenPivot {


	//many possible solutions
   public int[] pivotArray(int[] nums, int pivot) {
        
	   int len = nums.length;
	   int smallerCount = 0, equalCount = 0;
	   int[] ans = new int[len];
	   
	   for(int num: nums) {
		   if(num < pivot) smallerCount++;
		   else if(num == pivot) equalCount++;
	   }
	   
	   int smallerIndx = 0, equalIndex = smallerCount, greaterIndex = smallerCount + equalCount;
	   
	   for(int num: nums) {
		   if(num > pivot) ans[greaterIndex++] = num;
		   else if(num < pivot) ans[smallerIndx++] = num;
		   else ans[equalIndex++] = num;
	   }
	   return ans;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
