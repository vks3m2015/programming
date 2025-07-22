import java.util.Arrays;
import java.util.Scanner;

/* https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
 * 
 * Sort an array according to the order defined by another array
Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those are in A2. For the elements not present in A2, append them at last in sorted order.

Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
       A2[] = {2, 1, 8, 3}
Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}

we can solve this also using HashMap ( to store elements in arr1 and occurrence of the elements)
*/


public class SortArrAccordingAnotherArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter number of test cases ");
		int cases = sc.nextInt();
		
		while(cases > 0)
		{	
			System.out.println(" enter number of elements in array 1 to be sorted");
			int length1 = sc.nextInt();
			int[] arr1 = new int[length1];
			
			for(int i=0; i< length1; i++)
				arr1[i] = sc.nextInt();
			
			System.out.println(" enter number of elements in array 2 ");
			int length2 = sc.nextInt();
			int[] arr2 = new int[length2];
			
			for(int i=0; i< length2; i++)
				arr2[i] = sc.nextInt();
			
			sortAccording(arr1, length1, arr2, length2);
			cases--;
			
		}	
		sc.close();	

	}
	
	public static void sortAccording(int[] arr1, int length1, int[] arr2, int length2)
	{
		int[] tempArr = new int[length1];
		int[] visited = new int[length1];
		
		for(int i=0; i< length1; i++)
		{
			tempArr[i] = arr1[i];
			visited[i] = 0;
		}
		
		Arrays.sort(tempArr);
		
		int indexA1 = 0;
		for(int i=0; i< length2; i++)
		{
			int element = arr2[i];
			
			int indexInTempArr = getFirst(tempArr, element, 0, (length1 -1));
			
			//System.out.println(" index from getFirst = "+indexInTempArr);
			if(indexInTempArr == -1) continue;
			
			//System.out.println(" tempArr[indexInTempArr] = "+tempArr[indexInTempArr]);
			while(indexInTempArr < length1 && tempArr[indexInTempArr] == element)
			{
				arr1[indexA1++] = tempArr[indexInTempArr];
				visited[indexInTempArr] = 1;
				indexInTempArr++;
			}	
			
			
		}
		
		// Now copy all items of tempArr[] which are  
        // not present in arr2[] 
        for (int i = 0; i < length1; i++) 
            if (visited[i] == 0) 
            	arr1[indexA1++] = tempArr[i]; 
		
		
        printArray(arr1, length1);
		
		
	}
	
	/* 
	 * A Binary Search based function to find index of FIRST occurrence of element in tempArr[]. 
       If x is not present, then it returns -1 
     */
	
	public static int getFirst(int[] tempArr, int element, int low, int high)
	{
        int mid = (low + high)/2;
        
        if(low > high) return -1;
        
        if((tempArr[mid] == element) && ( mid == 0 || element > tempArr[mid -1]))
          return mid;
        	
        else if(tempArr[mid] < element)
        	return getFirst(tempArr, element, mid + 1, high);
        else
        	return getFirst(tempArr, element, low, mid -1);
		
		
 	}
	
	 // Utility function to print an array 
    static void printArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
}






