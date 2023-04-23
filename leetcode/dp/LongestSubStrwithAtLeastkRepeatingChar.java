package leetcode.dp;

public class LongestSubStrwithAtLeastkRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ahdgetasssjfdlfglllooeirijrrr";
		LongestSubStrwithAtLeastkRepeatingChar lc = new LongestSubStrwithAtLeastkRepeatingChar();
		System.out.println(lc.longestSubstring(s, 2));
	}

	public int longestSubstring(String s, int k) {
		return longest(s.toCharArray(), 0, s.length(), k, 0);
	}

	private int longest(char[] s, int start, int end, int k, int longest) {
		int[] hist = new int['z' - 'a' + 1]; // histogram i.e. characters' counts
		for (int i = start; i < end; i++)
			hist[s[i] - 'a']++;
		for (int i = start; i < end; i++) {
			if (hist[s[i] - 'a'] < k) { // split upon not good character
				if (i - start > longest)
					longest = longest(s, start, i, k, longest);
				while (i < end && hist[s[i] - 'a'] < k)
					i++; // skip all not good characters
				if (end - i > longest)
					longest = longest(s, i, end, k, longest);
				return longest;
			}
		}
		return end - start; // if we didn't exit earlier it means all characters in fragment are good
	}

}
