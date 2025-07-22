package standardPrograms;
//https://www.geeksforgeeks.org/longest-decreasing-subsequence/
/*
Given an array of N integers, find the length of the longest subsequence of a given sequence such that all elements of the subsequence 
are sorted in strictly decreasing order.

Examples :
  Input: arr[] = [15, 27, 14, 38, 63, 55, 46, 65, 85]
  Output: 3
  Explanation: The longest decreasing sub sequence is {63, 55, 46}
*/

public class LongestDecreasingSubSequence {

	public static void main(String[] args) {
		
		 int arr[] = { 15, 27, 14, 38, 63, 55, 46, 65, 85 };
		 int arr1[] = {50, 3, 10, 7, 40, 80};
   
         System.out.print("Length of LDS is " + lenOfLongestDecSubSeq(arr1)); 
		
	}

	public static int lenOfLongestDecSubSeq(int[] arr)
	{
		int arrLength = arr.length;
		int[] lds = new int[arrLength];
		
		int[] nextElementIndex = new int[arrLength];
		
		//this array will store the longest decreasing subsequence (lds) starting from that element
		//initializing with 1
		for(int i=0; i<arrLength; i++)
			lds[i] = 1;
		
		//this array will store index of next element in longest decreasing subsequence starting from that element
		//initialize with -1
		for(int i=0; i<arrLength; i++)
			nextElementIndex[i] = -1;
		
		for(int i=arrLength-2; i>=0; i--)
		{
			for(int j=i; j<arrLength; j++)
			{
				if((arr[j] < arr[i]) && lds[j] >= lds[i])
				{
					lds[i] = lds[j] + 1;
					nextElementIndex[i] = j;
					
				}	
			}	    
		}	
		
		//now find max in array lds
		int max = Integer.MIN_VALUE;
		int index =-1;
		for(int i=0; i<arrLength; i++)
		{
			if(lds[i] > max)
			{
			   max = lds[i];
			   index = i;	
			}	
		}	
		
		
		//printing longest decreasing sub sequence
		while(index >= 0)
		{
			System.out.print(arr[index]+ "   ");
			index = nextElementIndex[index];
		}	
		
		
		return max;
		
	}
}
