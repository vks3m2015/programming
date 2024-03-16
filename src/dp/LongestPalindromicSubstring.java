package dp;

//https://leetcode.com/problems/longest-palindromic-substring/
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
public class LongestPalindromicSubstring {
	
	//Approach2 - Expand around Center
	public static String longestPalindrome2(String s) {
		return s;
	}
		 

	//Aprroach 1- Dynamic Programming
	 public static String longestPalindrome(String s) {
		 
		int len = s.length(); 
		boolean[][] dp = new boolean[len][len];
		
		int maxLen = 1, startIndex = 0;
		
		//Storing info of sub string of length 1 
		for(int start = 0; start <  len; start++) {
			dp[start][start] = true;
		}
		
		//Storing info of substring of length 2
		for(int start = 0; start <  len-1; start++) {
			if(s.charAt(start) == s.charAt(start+1) ) {
			    dp[start][start+1] = true;
    			
			    maxLen = 2;
    			startIndex = start;
			}    
		}
		 
		//for substring of length greater than 2
        for(int subStrLen = 3; subStrLen <= len; subStrLen++) {
        	
        	for(int start = 0; start< len-subStrLen+1; start++) {
        		int end = start + subStrLen -1;
        		
        		if(s.charAt(start) == s.charAt(end) && dp[start+1][end-1]) {
        			dp[start][end] = true;
        			
        			if(subStrLen > maxLen) {
        				maxLen = subStrLen;
        				startIndex = start;
        			}
        		}
        	}
        }
		return s.substring(startIndex, startIndex+maxLen);
	 }
	 
	public static void main(String[] args) {

		System.out.println(longestPalindrome("forgeeksskeegfor"));
	}

}
