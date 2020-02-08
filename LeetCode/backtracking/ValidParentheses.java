package leetcode.backtracking;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ValidParentheses parentheses = new ValidParentheses();
		System.out.println(parentheses.isValid("["));//"()[]{}"   ")([)]"
	}

	public boolean isValid(String s) {
		//Very slow!!!!
		Stack<Character> st = new Stack<Character>();

		for (char c:s.toCharArray()) {
			//char c = s.charAt(i);
			System.out.println(c);
			if (c == '{' || c == '[' || c == '(') {
				st.push(c);
				// continue;
			} else {
				if (!st.isEmpty() && ((c == '}' && '{' == st.pop()) || (c == ']' && '[' == st.pop()) || (c == ')' && '(' == st.pop())) ) {
					continue;
				} else
					return false;
			}
		}

		return st.isEmpty();
	}
	
	
	public boolean isValidLC(String s) {
		  
	    if(s==null) return true;
	    Stack<Character> st = new Stack<>();
	    
	    for(char c: s.toCharArray())
	    {
	        if(c == '{' || c == '[' || c == '(')
	            st.push(c);
	        else if(c == '}' && (st.isEmpty() || st.pop() != '{'))
	                return false;
	        else if(c == ']' && (st.isEmpty() || st.pop() != '['))
	                return false;
	        else if(c == ')' && (st.isEmpty() || st.pop() != '('))
	                return false;
	        
	    }
	    
	    return st.isEmpty();
	}
	
	

}
