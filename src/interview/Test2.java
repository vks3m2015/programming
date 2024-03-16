package interview;

import java.util.Stack;

public class Test2 {

	public static void main(String[] args) {
		System.out.println(isValidSeq("[{()}]"));

	}
	
	static boolean isValidSeq(String str) {
		char[] chArr = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for(Character ch : chArr) {
			
			if(ch == '{' || ch == '(' || ch == '[') {
				stack.add(ch);
			}else if(ch == ')' && stack.peek() == '(') {
				stack.pop();
			}else if(ch == '}' && stack.peek() == '{') {
				stack.pop();
			}else if(ch == ']' && stack.peek() == '[') {
				stack.pop();
			}	
		}
		
		return stack.isEmpty() ? true : false;
		
	}
	

}
