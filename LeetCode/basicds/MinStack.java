package leetcode.basicds;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		MinStack obj = new MinStack();
		obj.push(x);
		obj.pop();
		int param_3 = obj.top();
		int param_4 = obj.getMin();
		
		/**
		 * Your MinStack object will be instantiated and called as such:
		 * MinStack obj = new MinStack();
		 * obj.push(x);
		 * obj.pop();
		 * int param_3 = obj.top();
		 * int param_4 = obj.getMin();
		 */

	}
	/** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack = new Stack<Integer>();
    
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.empty()){
            minStack.push(x);//making first one minimum
        } else {
            if(x<=minStack.peek()){
                System.out.println(minStack);
                minStack.push(x);//updating the min
                
            }
        }
        stack.push(x);//finally pushing the element
    }
    
    public void pop() {
        int x = stack.pop();
        
        if(x==minStack.peek()){
            
              minStack.pop();//removing current stack.pop from minStack
            System.out.println(minStack);
           }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        System.out.println(minStack);
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
