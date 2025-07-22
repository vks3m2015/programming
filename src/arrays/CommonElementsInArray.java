package arrays;

import java.util.Scanner;

//Find common elements in three sorted arrays
//https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays

public class CommonElementsInArray {

	public static void main(String[] arg)
	{
		int length1, length2, length3;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements in array 1");
		length1 = sc.nextInt();
		
		int[] array1 = new int[length1];
		System.out.println("enter elememts of array 1");
		for(int i =0; i<length1; i++ )
		{
			array1[i] = sc.nextInt();
		}	
		
		
		System.out.println("Enter number of elements in array 2");
		length2 = sc.nextInt();
		
		int[] array2 = new int[length1];
		System.out.println("enter elememts of array 2");
		for(int i =0; i<length2; i++ )
		{
			array2[i] = sc.nextInt();
		}	
		
		
		System.out.println("Enter number of elements in array 3");
		length3 = sc.nextInt();
		
		int[] array3 = new int[length1];
		System.out.println("enter elememts of array 3");
		for(int i =0; i<length3; i++ )
		{
			array3[i] = sc.nextInt();
		}	
		
		
		
	}
	
	//Logic is simple just increase the index of smallest element
	
	public void findCommon(int[] ar1, int[] ar2, int[] ar3)
	{
		// Initialize starting indexes for ar1[], ar2[] and ar3[]
        int i = 0, j = 0, k = 0;
 
        // Iterate through three arrays while all arrays have elements
        while (i < ar1.length && j < ar2.length && k < ar3.length)
        {
             // If x = y and y = z, print any of them and move ahead
             // in all arrays
             if (ar1[i] == ar2[j] && ar2[j] == ar3[k])
             {   System.out.print(ar1[i]+" ");   i++; j++; k++; }
 
             // x < y
             else if (ar1[i] < ar2[j])
                 i++;
 
             // y < z
             else if (ar2[j] < ar3[k])
                 j++;
 
             // We reach here when x > y and z < y, i.e., z is smallest
             else
                 k++;
		
	  }
	}
}
