package arrays.subarray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
/*
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstringHashMapSol(str));
    }

    public static int lengthOfLongestSubstringAI(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Duplicate found
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {

        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            Character currentChar = s.charAt(right);
            if(!set.contains(currentChar)){
                set.add(currentChar);

            }else{
                while(set.contains(currentChar)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right-left+1 );
        }
        return ans;
    }

    public static int lengthOfLongestSubstringHashMapSol(String s){
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                System.out.println("inside....");
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
