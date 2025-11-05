package twopointersHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxNonRepeatingSubString {

    public static void main(String[] args) {
       // maxUniqueSubString("abcdapq");
        maxUniqueSubString("abcabcbb"); //abc
        maxUniqueSubString("pwwkew"); //wke
    }

   static void maxUniqueSubString(String str){

        int maxLenStartIndex = 0;
        int maxLenEndIndex = 0;
        int maxLen = Integer.MIN_VALUE;

        Map<Character, Integer> winMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < str.length(); right++) {

            char currChar = str.charAt(right);
            Integer index = winMap.get(currChar);

            if(index == null){
                winMap.put(currChar, right);

                int currLen = (right - left) + 1;
                if(currLen > maxLen){
                    maxLen = currLen;
                    maxLenEndIndex = right;
                    maxLenStartIndex = left;
                }

            }else{
                left = index + 1;
                winMap.put(currChar, right);

                int currLen = (right - left) + 1;
                if(currLen > maxLen){
                    maxLen = currLen;
                    maxLenEndIndex = right;
                    maxLenStartIndex = left;
                }
            }

        }
        System.out.println(" maxLenStartIndex = "+ maxLenStartIndex + " maxLenEndIndex= "+ maxLenEndIndex
                + " maxLen = "+ maxLen);
       System.out.println(str.substring(maxLenStartIndex, maxLenEndIndex+ 1));
    }

    static void usingSet(String s){
        int maxLen = 0;
        int start = 0, maxStart = 0;

        Set<Character> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                maxStart = left;
            }
        }

        System.out.println("Longest unique substring: " + s.substring(maxStart, maxStart + maxLen));
        System.out.println("Length: " + maxLen);

    }

    //USING HASHMAP
    public static void usingHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        int maxStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            // If char already seen, move start pointer to avoid duplicate
            if (map.containsKey(ch)) {
                // Only move start forward (never backward)
                start = Math.max(start, map.get(ch) + 1);
            }

            // Update last seen index of current char
            map.put(ch, end);

            // Update max substring info if needed
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }

        System.out.println("Longest unique substring: " + s.substring(maxStart, maxStart + maxLen));
        System.out.println("Length: " + maxLen);
    }
}
