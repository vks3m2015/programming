package interview;

import java.util.Arrays;

public class Test19 {

	public static void main(String[] args) {
		
		int[] arr = {1,1,1,5,3,5,10,23,1,3};
		
		int[] arr1 = {1,5,3,10,23};
		int[] arr2 = {1,5,3};
		int[] arr3 = {1};
		int[] arr4 = {1};
		
		
		
		
		
		
		
	   removeDuplicate(arr);
		
		
		

	}
	
	
	
	static void subList() {
		
		
	}
	
	
	
	static int[] removeDuplicate(int[] arr){
		
		
		int slow =0;
		
		boolean[] flag = new boolean[100];
		
		int temp;
		
		for(int i= 0; i<arr.length; i++) {

			if(!flag[arr[i]]) {
				flag[arr[i]] = true;
				arr[slow++] = arr[i];
			}
			
		}
		
		for(int j = slow; j<arr.length; j++) {
			arr[j] = -1;
		}
		
		System.out.println(" arr = "+Arrays.toString(arr));
		
		return arr;
	}
	
	

}
