package a_todo;
//how many times a substring repeats consecutively (adjacently) inside another string.
/*
🧩 Example
Input:  main = "abcabcabcxyz"   sub  = "abc"
"abc" occurs 3 times consecutively at the start.
So the answer should be 3.

Input:  main = "abcxyzabcabc"   sub  = "abc"
Then only the last two are consecutive —
so the answer is 2 (not counting the earlier isolated one).
 */

//TURING interview question
public class AdjacentSubstringCount {
    public static void main(String[] args) {
        /*String main = "abcabcabcxyz";
        String sub = "abc";*/

       /* String main = "abcxyz";
        String sub = "abc";*/

        String main = "abcxyzabcabc";
        String sub = "abc";

        System.out.println("Chatgpt Adjacent occurrences: " + countAdjacentOccurrences(main, sub));
        System.out.println("Perplexity Adjacent occurrences: " + countAdjacentOccurrences2(main, sub));
        System.out.println("Gemini Adjacent occurrences: " + countAdjacentOccurrences3(main, sub));
    }

    //Chatgpt
    public static int countAdjacentOccurrences(String mainStr, String subStr) {
        int count = 0;
        int maxCount = 0;
        int i = 0;

        while (i <= mainStr.length() - subStr.length()) {
            // Check if substring matches
            if (mainStr.substring(i, i + subStr.length()).equals(subStr)) {
                count++;
                i += subStr.length();  // Move ahead by subStr length to check adjacency
            } else {
                // Reset count if non-adjacent pattern found
                maxCount = Math.max(maxCount, count);
                count = 0;
                i++;
            }
        }

        // Final max in case string ends with consecutive matches
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    //Perplexity
    public static int countAdjacentOccurrences2(String mainString, String subString) {
        int count = 0;
        int i = 0;
        int len = subString.length();

        while (i <= mainString.length() - len) {
            int tempCount = 0;
            while (i + len <= mainString.length() &&
                    mainString.substring(i, i + len).equals(subString)) {
                tempCount++;
                i += len;
            }
            if (tempCount > 0) {
                count += tempCount;
            } else {
                i++;
            }
        }
        return count;
    }

    //Gemini
    public static int countAdjacentOccurrences3(String mainString, String subString) {
        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(subString, index)) != -1) {
            // Check if the next characters are also the same substring
            int nextIndex = index + subString.length();
            while (mainString.startsWith(subString, nextIndex)) {
                count++;
                nextIndex += subString.length();
            }
            // Move index forward for the next search
            count++; // Count the first occurrence
            index += subString.length();
        }

        return count;
    }
}

