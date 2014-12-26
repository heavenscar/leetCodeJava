package leetcode.datastructure;

/***********************************************************************************************************
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *	push(x) -- Push element x onto stack.
 *	pop() -- Removes the element on top of the stack.
 *	top() -- Get the top element.
 *	getMin() -- Retrieve the minimum element in the stack.
 *
 *  2014-12-26, solved by Andong Wang.
 ***********************************************************************************************************/


class MinStack {
	
	private class Stack {
		Node first;
		class Node { int value;	Node next; }
		
		void push(int x) {
			Node oldfirst = first;
			first = new Node();
			first.value = x;
			first.next = oldfirst;
		}
		int pop() {
			int x = first.value;
			first = first.next;
			return x;
		}
		int top() {
			return first.value;
		}
	}
	
	private Stack mainStack = new Stack();
	private Stack minStack = new Stack();
	
	public void push(int x) {
		mainStack.push(x);
		if (x <= getMin()) minStack.push(x);
	}

	public void pop() {
		int x = mainStack.pop();
		if (x == getMin()) minStack.pop();
	}
	
	public int top() {
		return mainStack.top();
	}
	
	public int getMin() {
		if (minStack.first == null) return Integer.MAX_VALUE;
		return minStack.top();
	}
	
     public static void main(String[] args) {
     	MinStack minStack = new MinStack();
     	minStack.push(-1);
     	System.out.println();
     	System.out.println(minStack.top());
     	System.out.println(minStack.getMin());
     }
}
