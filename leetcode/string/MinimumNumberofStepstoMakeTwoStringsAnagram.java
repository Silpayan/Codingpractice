package leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
/*
 * 5333. Minimum Number of Steps to Make Two Strings Anagram

Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "friend", t = "family";//s = "anagram", t = "mangaar";//"leetcode", t = "practice";//s = "bab", t = "aba";
		System.out.println(new MinimumNumberofStepstoMakeTwoStringsAnagram().minSteps(s,t));
	}
	
	public int minSteps(String s, String t) {
		
		Map<Character,Integer> charCount = new HashMap<Character,Integer>();
		int count = 0;
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);;
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		System.out.println(charCount);
		
		for(int i=0;i<t.length();i++) {
			char c = t.charAt(i);
			System.out.println(c);
			if (charCount.containsKey(c)) {
				int charC = charCount.get(c);
				if (charC > 1) {
					charCount.put(c, charC - 1);
				} else if(charC==1) {
					charCount.remove(c);
					}
			}
		}
		
		System.out.println(charCount);
		
		Set<Character> keyChars = charCount.keySet();
		
		for(char c:keyChars) {
			count += charCount.get(c);
		}
		
		return count;
    }

}
