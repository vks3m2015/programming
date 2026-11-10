package slidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/dsa/count-distinct-elements-in-every-window-of-size-k/

public class CountDistinctCharsInEveryWindowOfSizeK {

    public static void main(String[] args) {

        String str = "aabacbebebe";
        int k = 3;

        countDistinct(str, k);
    }

    public static void countDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        for(int right = 0; right < s.length(); right++){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if(right - left + 1 > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }

            if(right - left + 1 == k){
                System.out.println(map.keySet());
            }

        }
    }

    public static void countDistinct(){

    }
}
