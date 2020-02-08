package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}

	List<String> ans = new ArrayList<String>();
	int count = 0;
	
	public List<String> generateParenthesis(int n) {
		// List<String> ans = new ArrayList<String>();
		backtrack("", 0, 0, n);
		return ans;
	}

	public void backtrack(String cur, int open, int close, int max) {
		System.out.println(count++);
		if (cur.length() == max * 2) {
			ans.add(cur);
			System.out.println(cur);
			return;
		}

		if (open < max)//Sicne only 2 bracket so just use 2 calls like binary tree traversal!
			backtrack(cur + "(", open + 1, close, max);
		if (close < open)
			backtrack(cur + ")", open, close + 1, max);
	}
	
	//Try Recursion and analyze complexity
	

}
