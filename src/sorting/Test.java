package sorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		Integer[] arr = {5, 8, 3,4,1, 5};
		
		//if a < b return negative
		/*
		 * Arrays.sort(arr, (a, b) -> { return a-b; });
		 */
		
		//System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString( Arrays.copyOfRange(arr, 1, 3)));
		
		
	}

}
