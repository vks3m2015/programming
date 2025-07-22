/*  https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * 
 * Sort an array of 0s, 1s and 2s
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
Examples:

Input :  {0, 1, 2, 0, 1, 2}
Output : {0, 0, 1, 1, 2, 2}

Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2} */

import java.util.Scanner;

public class NationalFagProblem {

	static void sortArray(int[] array) {
		int length = array.length;
		int low = 0, mid = 0, high = length - 1, temp;

		while (mid <= high) {
			
			switch (array[mid]) {
			case 0:
				temp = array[low];
				array[low] = array[mid];
				array[mid] = temp;
				low++;
				mid++; // ------
				break;

			case 1:
				mid++;
				break;

			case 2:
				temp = array[mid];
				array[mid] = array[high];
				array[high] = temp;
				high--;
				break;
			}

		}
	}
	
	 static void printArray(int arr[])
	 {
	     int arr_size = arr.length;
	        for (int i = 0; i < arr_size; i++)
	            System.out.print(arr[i]+" ");
	        System.out.println("");
	}
	 
	public static void main(String[] arg)
	{
		Scanner sc = new Scanner(System.in);
	    System.out.println(" Please enter number of Elements");	
	    
	    int length = sc.nextInt();
	    
	    int[] input = new int[length];
	    
	    System.out.println(" enter integers ");
	    
	    for(int i = 0; i < length; i++)
	    {
	    	input[i] = sc.nextInt();
	    	
	    	//System.out.println(" hi ...");
	    }	
	    //System.out.println(" hi  again  ...");
	    printArray(input);
	    sortArray(input);
	    
	    printArray(input);
	    
	}

}
