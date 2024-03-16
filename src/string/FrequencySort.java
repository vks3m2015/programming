package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class FrequencySort {
	
   public static String frequencySort(String s) {
		
	  Comparator<Map.Entry<Character, Integer>> comp = (k1, k2) -> { 
			  return k2.getValue() - k1.getValue();
		  };
		 
	   Map<Character, Integer> fmap = new HashMap<Character, Integer>();
	   
	   for(char ch : s.toCharArray()) {
		   fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
	   }
	   
	   List<Map.Entry<Character, Integer>> list = new ArrayList<>(fmap.entrySet());
	   Collections.sort(list, comp);
	   
	   char[] chArr = new char[s.length()]; int index = 0;
	   for(Map.Entry<Character, Integer> entry : list) {
		   int occ = entry.getValue();
		   char ch = entry.getKey();
		   while( occ > 0) {
			  chArr[index++] = ch;
			  occ--;
		   }
	   }
	  return new String(chArr);
    }

   //using Priority Queue
   public static String frequencySort2(String s) {
		
		  Comparator<Map.Entry<Character, Integer>> comp = (k1, k2) -> { 
				  return k2.getValue() - k1.getValue();
		   };
			 
		   Map<Character, Integer> fmap = new HashMap<Character, Integer>();
		   
		   for(char ch : s.toCharArray()) {
			   fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
		   }
		   
		   PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(comp);
		   queue.addAll(fmap.entrySet());
		   
		   StringBuilder sb = new StringBuilder(); 
		   while(!queue.isEmpty()){
			   Map.Entry<Character, Integer> entry = queue.poll();
			   for (int i = 0; i < (int)entry.getValue(); i++) 
	                sb.append(entry.getKey());
		   }
		  return sb.toString();
	    }

	public static void main(String[] args) {
		String str = frequencySort("tree");
        System.out.println(str);
        
        String str2 = frequencySort2("tree");
        System.out.println(str2);
	}

}
