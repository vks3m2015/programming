package string;

import java.util.HashMap;

public class FirstUniqueChar {

   public int firstUniqCharacter(String s) {
       
	   HashMap<Character, Integer> count = new HashMap<>();
	   for(char ch : s.toCharArray()) {
		   count.put(ch, count.getOrDefault(ch, 0)+ 1);
	   }
	   
	   for(int i = 0; i<s.length(); i++) {
		   if(count.get(s.charAt(i)) == 1) return i;
	   }
	   return -1;
    }
   
   public int firstUniqCharacter2(String s) {
	   HashMap<Character, Integer> map = new HashMap<>();
	   for(int i = 0; i<s.length(); i++) {
		   if(!map.containsKey(s.charAt(i)))
			   map.put(s.charAt(i), i);
		   else
			   map.put(s.charAt(i), -1);
	   }
	   
	   int min = Integer.MAX_VALUE;
	   
	   for(char ch : map.keySet()) {
		   if(map.get(ch) < min && map.get(ch) > -1) 
			   min = map.get(ch);
	   }
	   return min == Integer.MAX_VALUE ? -1 : min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
