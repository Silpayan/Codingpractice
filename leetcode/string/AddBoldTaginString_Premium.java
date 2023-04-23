package leetcode.string;
/*
 * 
 *616. Add Bold Tag in String
Medium
Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:

Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
 

Example 2:

Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
 */
public class AddBoldTaginString_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcxyz123", dict[] = {"abc","123"};
		
		System.out.println(new AddBoldTaginString_Premium().boldWords(s, dict));
		
		s = "aaabbcc";
		String dict1[] = {"aaa","aab","bc"};
		
		System.out.println(new AddBoldTaginString_Premium().boldWords(s, dict1));

	}
	
	public String boldWords(String S, String[] words) {
        int N = S.length();
        boolean[] mask = new boolean[N];
        for (int i = 0; i < N; ++i)
            for (String word: words) search: {
                for (int k = 0; k < word.length(); ++k)
                    if (k+i >= S.length() || S.charAt(k+i) != word.charAt(k))
                        break search;

                for (int j = i; j < i+word.length(); ++j)
                    mask[j] = true;
            }

        StringBuilder ans = new StringBuilder();
        int anchor = 0;
        for (int i = 0; i < N; ++i) {
            if (mask[i] && (i == 0 || !mask[i-1]))
                ans.append("<b>");
            ans.append(S.charAt(i));
            if (mask[i] && (i == N-1 || !mask[i+1]))
                ans.append("</b>");
        }
        return ans.toString();
    }

    public boolean match(String S, int i, int j, String T) {
        for (int k = i; k < j; ++k)
            if (k >= S.length() || S.charAt(k) != T.charAt(k-i))
                return false;
        return true;
    }

}
