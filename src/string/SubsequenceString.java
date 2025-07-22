package string;

/* Given two strings str1 and str2, find if str1 is a subsequence of str2
 * 
 * Input: str1 = "AXY", str2 = "ADXCPY"
   Output: True (str1 is a subsequence of str2)

   Input: str1 = "AXY", str2 = "YADXCP"
   Output: False (str1 is not a subsequence of str2)
 */

public class SubsequenceString {

	public static boolean isSubsequence(String str1, String str2)
	{
		int i=0, j=0;     // i for str1 and j for str2
		int len1 = str1.length(), len2 = str2.length();
		
		while(i < len1 && j < len2)
		{
			if(str1.charAt(i) == str2.charAt(j) )
			{
				i++;
				j++;
			}
			else 
				j++;
			
		}
		if(i == len1)
			return true;
		else
			return false;
		
	}
	
	public static boolean isSubsequenceRec(String str1, String str2, int len1, int len2)
	{
	    if(len1 == 0)
		    return true;
	    
	    if(len2 == 0)
	    	return false;
	    
		if(str1.charAt(len1 -1) == str2.charAt(len2 -1))
			return isSubsequenceRec(str1, str2, len1 -1, len2 -1);
		else
			return isSubsequenceRec(str1, str2, len1 , len2 -1);
	}
	
	
	public static void main(String[] args) {
         System.out.println(isSubsequence("AB", "CxApqrBz"));
         System.out.println(isSubsequence("axyz", "y"));
         System.out.println(isSubsequenceRec("a", "a", 1, 1));

	}

}
