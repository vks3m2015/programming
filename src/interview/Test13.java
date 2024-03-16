package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test13 {

	public static void main(String[] args) {

		int[] arr =  {4, 7, 2, 8, 5};  //n + n 
		
		int left = 0, right = arr.length -1;
		
		int temp; 
		while(left < right) {
		  temp = arr[left];
		  arr[left] = arr[right];
		  arr[right] = temp;
		  
		  left++;
		  right--;
			
		}
		
		System.out.println(" arr = "+Arrays.toString(arr));
	}
	
	

}
