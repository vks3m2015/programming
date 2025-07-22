package pendingPrograms;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

	public static void main(String[] args) {
		String expr;
		int testCases = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter number of test cases..");
		testCases = sc.nextInt();
		
		while(testCases > 0)
		{	
		   System.out.println("------------------------------------------------------------");	
		   System.out.println(" Enter Expression");
		   expr = sc.nextLine();
		   //System.out.println("  entered expr == "+expr);
		   System.out.println(" is paranthesis are balanced: "+ isBalancedParenthesis(expr));
		   System.out.println(" depth =="+maxDepthBalancedParenthesis(expr));
		   testCases--;
		}
		
		sc.close();
	}
	
	public static boolean isBalancedParenthesis(String expr)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<expr.length(); i++)
		{
			char exp = expr.charAt(i);
			
			if(exp == '{' || exp == '[' || exp == '(')
			{
				stack.push(exp);
			}	
			
			if(exp == '}' || exp == ']' || exp == ')')
			{
				if(stack.isEmpty())
					return false;
				
				char  top = (char) stack.peek();
				if(isMatch(exp, top))
				{
					stack.pop();
				}	
				else
					return false;
			}	
		}
		
		if(stack.empty())
			return true;
		else
			return false;
	}
	
	public static boolean isMatch(char inputChar, char stackChar)
	{
		if(inputChar == '}' && stackChar == '{')
			return true;
		
		if(inputChar == ']' && stackChar == '[')
			return true;
		
		if(inputChar == ')' && stackChar == '(')
			return true;
		
		return false;
		
	}
	
	public static int maxDepthBalancedParenthesis(String expr)
	{
		Stack<Character> stack = new Stack<Character>();
		int currentDepth=0, maxDepth=0; 
		
		for(int i=0; i<expr.length(); i++)
		{
			char exp = expr.charAt(i);
			
			if(exp == '{' || exp == '[' || exp == '(')
			{
				stack.push(exp);
				currentDepth++;
				
				if(currentDepth > maxDepth)
					maxDepth = currentDepth;
			}	
			
			if(exp == '}' || exp == ']' || exp == ')')
			{
				if(stack.isEmpty())
					return -1;
				
				char  top = (char) stack.peek();
				if(isMatch(exp, top))
				{
					stack.pop();
					currentDepth--;
				}	
				else
					return -1;
			}	
		}
		
		if(stack.empty())
			return maxDepth;
		else
			return -1;
	}
	
	

}
