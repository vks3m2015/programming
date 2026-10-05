package a_concepts;

import java.util.Arrays;

public class Concept {

    public static void main(String[] args) {
        System.out.println( 43 < 'a'); //true

        String str = "vks";

        char[] ch = str.toCharArray();

        System.out.println("ch == "+ Arrays.toString(ch));

        System.out.println(ch[0]);
        System.out.println(ch[0] - 0);

    }
}
