package sorting;

import java.util.Arrays;

public class ArraySort {

   public int[] sortArray(int[] nums) {
     
	   mergeSort(nums, 0, nums.length-1);
	   return nums;
	   
    }
   
    void mergeSort(int[] nums, int startIdx, int endIdx) {
    	
    	System.out.println(" inside merge sort arr = "+ Arrays.toString( Arrays.copyOfRange(nums, startIdx, endIdx+1))+
    			" and start index = "+ startIdx + "  endIdx = "+ endIdx);
    	int mid = startIdx + (endIdx - startIdx)/2;
    	
    	if(startIdx == endIdx) return;
    	
    	mergeSort(nums, startIdx, mid);
    	mergeSort(nums, mid+1, endIdx);
    	
    	mergeSortedArray(nums, startIdx, mid, mid+1, endIdx);
    	
    } 
   
    void mergeSortedArray(int[] nums, int startIdx1, int endIdx1, int startIdx2, int endIdx2) {
    	
    	    System.out.println("Merging arrays arr1 = "+ Arrays.toString( Arrays.copyOfRange(nums, startIdx1, endIdx1+1))
    	    + " and arr2  = "+ Arrays.toString( Arrays.copyOfRange(nums, startIdx2, endIdx2+1)) );
    		
    	    
    	    int[] temp = new int[endIdx1 - startIdx1 + 1 + endIdx2 - startIdx2 + 1];
    	    
    	    System.out.println(" temp length = "+ temp.length);
    		
    		int i = startIdx1, j = startIdx2, k = 0;
    		
    		while(i<= endIdx1 && j <= endIdx2) {
    			
    			while(nums[i] < nums[j] && i<=endIdx1) {
    				temp[k++] = nums[i++];
    				
    			}
    			
    			System.out.println(" temp1 = "+ Arrays.toString(temp) + " k = "+ k + " i ="+ i + " j ="+ j);
    			while(nums[j] < nums[i] && j <= endIdx2) {
    				temp[k++] = nums[j++];
    				System.out.println(" inside while k = "+ k);
    			}
    			
    			System.out.println(" temp2 = "+ Arrays.toString(temp) + " k = "+ k + " i ="+ i + " j ="+ j);
    		}
    		
    		while(i<=endIdx1) temp[k++] = nums[i++];
    		while(j<=endIdx2) temp[k++] = nums[j++];
    		
    		
    	
            //copy temp to arr 
    		
    		System.out.println(" temp3 arr = "+ Arrays.toString(temp) + " k = "+ k + " i ="+ i + " j ="+ j);
    		
    		for (int l = startIdx1, m = 0 ; l <= endIdx2; l++){
                nums[l] = temp[m++];
            }
    		
    		System.out.println("After Merging arr = "+ Arrays.toString( Arrays.copyOfRange(nums, startIdx1, endIdx2+1)));
    }
    
	
	public static void main(String[] args) {
		ArraySort as = new ArraySort();
		
		int[] arr = {6, 19, 10, 3, 15};
		
		int[] arrSorted = as.sortArray(arr);
		
		System.out.println(Arrays.toString(arrSorted));
		

	}

}
