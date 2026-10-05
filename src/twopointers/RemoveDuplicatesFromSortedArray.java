package twopointers;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that 
//each unique element appears only once. The relative order of the elements should be kept the same.

/* Similar
 * @see MoveZerosAtEnd
 * @see RemoveDuplicatesFromSortedArray
 * @see RemoveElement
 */

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}



