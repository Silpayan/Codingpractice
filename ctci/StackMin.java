package ctci;

import java.util.Stack;

/*
 * Stack Min : How would you designa stack which, in addition to push and pop, has a function min which returns the 
 * minimum element? Push, pop and min should all operate in O(n) time.
 */
public class StackMin extends Stack<Integer>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackMin sm = new StackMin();
		
		System.out.println("Now Min : "+sm.min()+" Popping : "+sm.pop());
		sm.push(5);sm.push(7);sm.push(2);
		System.out.println("Now Min : "+sm.min()+" Popping : "+sm.pop()+" Now min : "+sm.min());
		sm.push(13);sm.push(3);sm.push(12);
		System.out.println("Now Min : "+sm.min()+" Popping : "+sm.pop()+" Now min : "+sm.min());

	}
	//private static Stack<Integer> stk = new Stack<Integer>();
	private static Stack<Integer> min = new Stack<Integer>();
	
	public void push(int val) {
		super.push(val);
		if(min.isEmpty() || val<min()) {
			min.push(val);
		}
	}
	
	public Integer pop() {
		if(super.isEmpty())
			return Integer.MAX_VALUE;// If not used Exception in thread "main" java.util.EmptyStackException
		
		int val = super.pop();
		
		if(val==min()) {
			min.pop();
		}
		
		
		return val;
	}

	public Integer min() {
		if(min.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return min.peek();
	}
}
