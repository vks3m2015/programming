package twopointers;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public int removeDuplicates2(int[] nums) {


        int last = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[last]){
                nums[++last] = nums[i];
                count = 1;
            }else if(nums[i] == nums[last] && count < 2){
                nums[++last] = nums[i];
                count++;
            }
        }
        return last+1;
    }
}
