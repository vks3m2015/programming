package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram/
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 */
public class Anagram {

    public static void main(String[] args) {

        isValidAnagram("a", "ab");

    }

    static boolean isValidAnagram(String s, String t){

        Map<Character, Integer> countMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
        }

        System.out.println("countMap 1 "+ countMap);

        for(char ch : t.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0)-1);
        }

        System.out.println("countMap 2 "+ countMap);

        for(Integer val : countMap.values()){
            if (val != 0) return false;
        }
        return true;
    }

    //Array map more fast
    public boolean isAnagram(String s, String t) {
        int[] freq= new int[26]; // if letters are lowercase a-z only
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            freq[ch-'a']--;
        }
        for(int i: freq){
            if(i!=0) return false;
        }
        return true;
    }

    //using sort
    static boolean areAnagrams(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        // Sort both strings
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        // Compare sorted strings
        return Arrays.equals(s1Array, s2Array);
    }
}
