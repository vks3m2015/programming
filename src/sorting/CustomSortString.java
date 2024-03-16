package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/custom-sort-string/
/*
 * You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
   Permute the characters of s so that they match the order that order was sorted.
 */
public class CustomSortString {

	/*
	 * Input: order = "cba", s = "abcd" Output: "cbad"
	 */
	// order and s consist of lowercase English letters.

	public static String customSortString(String order, String s) {

		StringBuilder ans = new StringBuilder();
		
		// frequency hashing using array
		int[] freq = new int[26];
		for (char ch : s.toCharArray())
			freq[ch - 'a']++;
		
		for (char orderChar : order.toCharArray()) {
			while (freq[orderChar - 'a'] > 0) {
				ans.append(orderChar);
				freq[orderChar - 'a']--;
			}
		}

		for (int i =0; i<26; i++) {
			int count = freq[i];
			while (count > 0) {
				ans.append((char)(i + 'a'));
				count--;
			}
		}
		return ans.toString();
	}

	public static String customSortString2(String order, String s) {

		StringBuilder ans = new StringBuilder();
		// frequency hashing using Map
		Map<Character, Integer> fmap = new HashMap<>();

		for (Character ch : s.toCharArray())
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

		for (char ch : order.toCharArray()) {
			Integer count = fmap.get(ch);
			while (count != null && count > 0) {
				ans.append(ch);
				count--;
			}
			fmap.remove(ch);
		}

		for (char ch : fmap.keySet()) {
			Integer count = fmap.get(ch);
			while (count != null && count > 0) {
				ans.append(ch);
				count--;
			}

		}

		return ans.toString();
	}

	/*
	 * //not able to decide order in all scenarios public static String
	 * customSortString2(String order, String s) {
	 * 
	 * StringBuilder ans = new StringBuilder();
	 * 
	 * //index hashing Map<Character, Integer> fmap = new HashMap<>();
	 * 
	 * for(int i = 0; i < order.length(); i++) fmap.put(order.charAt(i), i);
	 * 
	 * Character[] strArr = s.chars(). mapToObj(c -> (char)c).
	 * toArray(Character[]::new);
	 * 
	 * Arrays.sort(strArr, (a, b) -> {
	 * 
	 * if(fmap.get(a) == null || fmap.get(b) == null) return 0;
	 * 
	 * return fmap.get(a) - fmap.get(b);
	 * 
	 * });
	 * 
	 * // Creating a string using append() method for (int i = 0; i < strArr.length;
	 * i++) { ans.append(strArr[i]); } return ans.toString(); }
	 */

	public static void main(String[] args) {
		// System.out.println(customSortString2("cba", "abcd")); //cbad
		// System.out.println(customSortString2("cbafg", "abcd")); //cbad
		System.out.println(customSortString2("ebv", "bwve")); // exvw
		// System.out.println(customSortString2("exv", "xwvee")); //"eexvw" //coming -
		// xweev
	}

}
