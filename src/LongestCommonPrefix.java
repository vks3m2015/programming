public class LongestCommonPrefix {

    //https://leetcode.com/problems/longest-common-prefix/description/
    /*
    Input: strs = ["flower","flow","flight"]
     Output: "fl"
     */
    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        //String[] strs = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(strs));

    }

    //Myself
    public static String longestCommonPrefix(String[] strs) {
        int commonIndex = 0;
        boolean flag = false;
        int l = shortestLenStr(strs);
        for (int j = 0; j < l; j++) {
            System.out.println(" while..");
            char ch = strs[0].charAt(commonIndex);
            for (int i = 1; i < strs.length; i++) {
                if (ch != strs[i].charAt(commonIndex)) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            commonIndex++;
        }
        System.out.println("commonIndex ==  " + commonIndex);
        return commonIndex == 0 ? "" : strs[0].substring(0, commonIndex);
    }

    static int shortestLenStr(String[] strs) {
        int l = 200;
        for (String str : strs) {
            if (l < str.length()) {
                l = str.length();
            }
        }
        return l;
    }

    //From Leetcode
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {
                if (prefix.length() == 0) return "";
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
