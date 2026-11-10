package a_practice;

import java.util.HashSet;
import java.util.Set;

public class Practice {

    public static void main(String[] args) {
     sameLenStr("1234567890");
    }



    public static void sameLenStr(String str ){

        StringBuilder sb = new StringBuilder();
       // sb.append("ab");
        //sb.deleteCharAt(0);

       // System.out.println(sb.toString());

        int left = 0;
        for(int right = 0; right < str.length(); right++){

            sb.append(str.charAt(right));

            if(sb.length() > 3){
                sb.deleteCharAt(0);
            }

            System.out.println(sb);

        }

    }

   /* public int lengthOfLongestSubstring(String s) {

        Set<Character> ch = new HashSet<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++ ){


        }
    }*/
}
