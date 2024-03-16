package stack;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/description/
//1.Implementation using two stacks
//2.Implementation using one stack
//3.Implementation using LinkedList
public class MinStack {
	
	Stack<Integer> stack;
	Stack<Integer> minTillNowStack;
	
    public MinStack() {
        stack = new Stack<>();
        minTillNowStack = new Stack<>();
    }
    
    public void push(int val) {
    	int min = !minTillNowStack.empty() ? Math.min(val, minTillNowStack.peek()) : val;
    	//System.out.println(" push min ="+ min);
    	stack.push(val);
    	minTillNowStack.push(min);
    }
    
    public void pop() {
       stack.pop();
       minTillNowStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minTillNowStack.peek();
    }

	public static void main(String[] args) {
		MinStack2 minStack = new MinStack2();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);

		System.out.println(minStack.getMin());
		
		MinStack3 minStack3 = new MinStack3();
		minStack3.push(-2);
		minStack3.push(0);
		minStack3.push(-3);

		System.out.println(minStack3.getMin());
	}
}

//Implementation using Single Stack
class MinStack2{
	
	Stack<Entry> stack;
	
	MinStack2(){
		stack = new Stack<>();
	}
	
    public void push(int val) {
    	int min = !stack.empty() ? Math.min(val, stack.peek().min) : val;
    	stack.push(new Entry(val, min));
    }
    
    public void pop() {
       stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
	
}

class Entry{
	int val;
	int min;
	
	Entry(int val, int min){
		this.val = val;
		this.min = min;
	}
}


class Node{
	int val;
	int min;
	Node next;
	
	Node(int val, int min, Node node){
		this.val = val;
		this.min = min;
		this.next = node;
	}
}

//Implementation using LinkedList
class MinStack3{
	Node top;
	
	public void push(int val) {
    	if(top == null) {
    		top = new Node(val, val, null);
    	}else {
    		top = new Node(val, Math.min(val, top.min), top);
    	}
    }
    
    public void pop() {
       top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
}