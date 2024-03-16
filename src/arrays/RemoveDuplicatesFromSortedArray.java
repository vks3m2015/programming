package arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that 
//each unique element appears only once. The relative order of the elements should be kept the same.

/* Similar
 * @see MoveZerosAtEnd
 * @see RemoveDuplicatesFromSortedArray
 * @see RemoveElement
 */
public class RemoveDuplicatesFromSortedArray {

   public int removeDuplicates(int[] nums) {
       
	   if(nums.length == 1) return 1;
	   int slow = 0, fast = 1;
	   
	   while(fast < nums.length) {
		   
		   if(nums[fast] != nums[slow]) {
			   nums[++slow] = nums[fast];
		   }
		   fast++;
	   }
	   return slow +1;
    }
   
   public int removeDuplicates2(int[] nums) {
       if(nums.length == 0)
           return 0;
       
       int addIndex = 1; //index that unique characters will be inserted at

       for(int i = 0; i < nums.length - 1; i++) {
           
           if(nums[i] < nums[i + 1]){ //if true, num[i + 1] is a new unique number
             nums[addIndex] = nums[i + 1];
             addIndex++;
           }
       }
       return addIndex;
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
