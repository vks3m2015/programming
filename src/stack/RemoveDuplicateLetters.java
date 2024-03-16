package stack;

import java.util.Stack;

//https://leetcode.com/problems/remove-duplicate-letters/description/
//s consists of lowercase English letters.
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
    
    	char[] arr = s.toCharArray();
    	
    	//Count array
    	int[] count = new int[26];
    	for(char ch : arr) {
    		count[ch - 'a']++;
    	}
    	
    	Stack<Character> stack = new Stack<>();
    	boolean[] inStack = new boolean[26];
    	
    	for(char ch : arr) {
    		count[ch - 'a']--;
    		
    		if(inStack[ch - 'a']) continue;
    		
    		while(!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
    			Character topChar = stack.pop();
    			inStack[topChar - 'a'] = false;
    		}
    		
    		stack.push(ch);
    		inStack[ch - 'a'] = true;
    	}
    	
    	//System.out.println(stack.toString());
    	StringBuilder sb = new StringBuilder();
    	for(char ch : stack) {
    		sb.append(ch);
    	}
    	
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		String str = removeDuplicateLetters("bcabc");   //abc
		System.out.println("Input - bcabc , Output - "+str);
	    
		str = removeDuplicateLetters("cbacdcbc");   //acdb
		System.out.println("Input - cbacdcbc , Output - "+ str);
		
	}
	

}
