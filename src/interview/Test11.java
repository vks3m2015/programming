package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test11 {

	public static void main(String[] args) {
		System.out.println(secLargest("I am goodadsaADFFA programmer"));
		
//		System.out.println(anagram("AAAB", "AABB"));

	}
	
	
	public static boolean anagram(String str1, String str2) {
		
		if(str1.length() != str2.length())
			return false;
		
		Set<Character> set = new HashSet<>();
		for(int i = 0 ; i<str1.length(); i++) {
			set.add(str1.charAt(i));
		}
		
		for(int i = 0 ; i<str2.length(); i++) {
		   if(!set.contains(str2.charAt(i)))	{
			   return false;
		   }
		}
		return true;
	}
	
	
	public static String secLargest(String str){
		  String[] strArr = str.split("\\s+");
		  int largest = Integer.MIN_VALUE , secondLargest = largest, largestIndex = 0, secondLargestIndex = largestIndex;
		  
		   for(int i = 0 ; i< strArr.length; i++){
		      int len = strArr[i].length() ;
			  if(len > largest){
			    secondLargest = largest;
			    secondLargestIndex = largestIndex;
				largest = len;
				largestIndex = i;
			  }
		   }
		   
		  return strArr[secondLargestIndex];
		  
	}

}
