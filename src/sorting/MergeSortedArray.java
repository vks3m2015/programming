package sorting;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray {
	
	//filling nums1 from back
	//Sol - https://leetcode.com/problems/merge-sorted-array/discuss/29704/My-clean-java-solution
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int tail1 = m-1, tail2 = n-1, terminal = m+n-1;
		
		while(tail1 >= 0 && tail2 >= 0) {
			
			if(nums2[tail2] >= nums1[tail1]) {
				nums1[terminal--] = nums2[tail2--];
			}else {
				nums1[terminal--] = nums1[tail1--];
			}
		}
		
		while (tail2 >= 0) { //only need to combine with remaining nums2, if any
	        nums1[terminal--] = nums2[tail2--];
	    }
	}

	 //Correct but not optimized
	 public void merge2(int[] nums1, int m, int[] nums2, int n) {
	        int i = 0, j = 0, k = m-1;
	        
	        while(j < n && i<= k) {
	        	
	        	System.out.println(" i = "+i + " j ="+ j + " k = "+ k);
	        	System.out.println(" num1 = "+ Arrays.toString(nums1) + "  and nums2 = "+ Arrays.toString(nums2));
	        	System.out.println("=======================================");
	        	
	        	if(nums1[i] <= nums2[j]) {
	        		i++;
	        		
	        	}else {
	        		
	        		//make space in nums1
	        		int t = k;
	        		while(t >= i) {
	        			nums1[t+1] = nums1[t--];
	        		}
	        		k++;
	        		
	        		nums1[i++] = nums2[j++]; 
	        	}
	        }
	        
	        while(j < n) {
	        	nums1[i++] = nums2[j++];
	        }
	 }
	 
	public static void main(String[] args) {
       int[] nums1 = {1,2,3, 0,0, 0};
       int[] nums2 = {2, 5, 6};
       
       new MergeSortedArray().merge(nums1, 3, nums2, 3);
       
       System.out.println(Arrays.toString(nums1));
		
	}

}
