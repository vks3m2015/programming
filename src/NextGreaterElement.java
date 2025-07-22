/*
 * Next Greater Element
   Given an array, print the Next Greater Element (NGE) for every element. 
   The Next greater Element for an element x is the first greater element on the right side of x in array. 
   Elements for which no greater element exist, consider next greater element as -1.
 */

import java.util.Stack;

public class NextGreaterElement {
	
	public static void printNextGreaterElement(int[] inputArr)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(inputArr[0]);
		
		for(int i=1; i<inputArr.length; i++)
		{
			
			int element = inputArr[i];
			
			while(!stack.isEmpty() && element > stack.peek())
			{
				System.out.println(" Next greater element for "+stack.pop() + " is "+ element);
				
			}	
			
			stack.push(element);
			
		}
		
		while(!stack.empty())
		{
			int top = (int)stack.pop();
			System.out.println(" next greater element for "+ top + "  is  null");
		}	
	}
	
	public static void main(String[] arg)
	{
		int[] inputArr = { 98, 23, 54, 12, 20, 7, 27 };
		printNextGreaterElement(inputArr);
	}

}
