package slidingWindow;

//https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
/*
You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.

Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.



Example 1:

Input: s = "aabaaaacaabc", k = 2
Output: 8
Explanation:
Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
A total of 3 + 5 = 8 minutes is needed.
It can be proven that 8 is the minimum number of minutes needed.
Example 2:

Input: s = "a", k = 1
Output: -1
Explanation: It is not possible to take one 'b' or 'c' so return -1
 */
public class Take_k_of_each_character_from_left_and_right {

    public int takeCharacters(String s, int k) {

        int n = s.length();
        int[] count = new int[3];

        // Count total occurrences
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Check feasibility
        for (int c : count) {
            if (c < k) {
                return -1;
            }
        }

        // Maximum allowed count inside the window
        count[0] -= k;
        count[1] -= k;
        count[2] -= k;

        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < n; right++) {

            count[s.charAt(right) - 'a']--;

            while (count[s.charAt(right) - 'a'] < 0) {
                count[s.charAt(left) - 'a']++;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}