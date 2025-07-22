package numbers;

import java.util.Arrays;

/*
Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print �not possible�.
Examples:
For simplicity of implementation, we have considered input number as a string.

Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"
	
*/	
public class NextGrNumBySwap {

	public static void main(String[] args) {
		 char digits[] = { '5','3','4','9','7','6' }; 
	     int n = digits.length; 
	     findNext(digits, n); 

	}
	
	public static void findNext(char[] arr, int len)
	{
	
		// I) Start from the right most digit  
        // and find the first digit that is smaller  
        // than the digit next to it. 	
	   int i= arr[len-1]; 
	   while(arr[i]< arr[i-1])
		 i--;
	   
	   // If no such digit is found, then all  
       // digits are in descending order means  
       // there cannot be a greater number with  
       // same set of digits 
       if (i == 0)  
       { 
           System.out.println("Not possible"); 
       }  
       else
       {
    	   int x = arr[i - 1], min = i; 
           
           // II) Find the smallest digit on right  
           // side of (i-1)'th digit that is greater  
           // than number[i-1] 
           for (int j = i + 1; j < len; j++)  
           { 
               if (arr[j] > x && arr[j] < arr[min])  
               { 
                   min = j; 
               } 
           } 
 
           // III) Swap the above found smallest  
           // digit with number[i-1] 
           swap(arr, i - 1, min); 
 
           // IV) Sort the digits after (i-1)  
           // in ascending order 
           Arrays.sort(arr, i, len); 
           System.out.print("Next number with same" + 
                                   " set of digits is "); 
           for (i = 0; i < len; i++) 
               System.out.print(arr[i]); 
       } 
    }	   
	   
	// Utility function to swap two digit 
    static void swap(char ar[], int i, int j)  
    { 
        char temp = ar[i]; 
        ar[i] = ar[j]; 
        ar[j] = temp; 
    }    
	   
	   
}
	








