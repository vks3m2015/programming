package tricky;

/*
 * Find the smallest window in a string containing all characters of another string
   Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2 efficiently.
   For Example:

   Input :  string = "this is a test string"
   pattern = "tist"
   Output :  Minimum window is "t stri"
   Explanation: "t stri" contains all the characters
              of pattern.
              
   //https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/           
 */
public class SmallestWindow {

	public static void main(String[] args) {
		
	   String str = "abbaaaccba"; 
	   String pat = "abc"; 
       System.out.print("Smallest window is :  " + smallestWindow(str, pat));
                       
	}
	
	public static String smallestWindow(String str, String pattern)
	{
		int[] pattern_countArr = new int[256];
		int[] str_countArr = new int[256];
		
		int count =0, start_index =-1, start =0;
		
		int min_length = Integer.MAX_VALUE;
		
		for(int i=0; i<pattern.length(); i++)
			pattern_countArr[pattern.charAt(i)]++;
		
		for(int i=0; i<str.length(); i++)
		{
			if(pattern_countArr[str.charAt(i)] == 0) continue;
			
			str_countArr[str.charAt(i)]++;
			
			if(str_countArr[str.charAt(i)] <= pattern_countArr[str.charAt(i)])
			{
				count++;
			}
			
			if(count == pattern.length())
			{
				while(str_countArr[str.charAt(start)] > pattern_countArr[str.charAt(start)] || pattern_countArr[str.charAt(start)] == 0)
				{
					if(str_countArr[str.charAt(start)] > pattern_countArr[str.charAt(start)])
						str_countArr[str.charAt(start)]--;
					
					start++;
						
				}
				
				int window_len = i - start + 1;
				
				if(window_len < min_length)
				{
					min_length = window_len;
					start_index = start;
				}	
			}
			
		}	
		
		 if (start_index == -1) 
	     { 
	           System.out.println("No such window exists"); 
	           return ""; 
	     } 
	       
	        // Return substring starting from start_index 
	        // and length min_len 
	        return str.substring(start_index, start_index + min_length); 
		
	}
	
}
