package hashing;

//https://leetcode.com/problems/ransom-note/
public class RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {
	    
		int[] magazineHash = new int[26];
		
		for(char ch : magazine.toCharArray()) {
			magazineHash[ch - 'a']++;
		}
		
		for(char ch : ransomNote.toCharArray()) {
			if(magazineHash[ch-'a'] == 0) return false;
			magazineHash[ch-'a']--;
		}
		return true;
	}
	
	public static void main(String[] args) {
	  print("a", "b", canConstruct("a", "b"));
	  print("aa", "ab", canConstruct("aa", "ab"));
	  print("aa", "aab", canConstruct("aa", "aab"));
		
	}
	
	public static void print(String ransomNote, String magazine, boolean output) {
		System.out.println(" RansomNote = "+ransomNote + "  magazine = "+ magazine + " Result = "+ output);
	}

}
