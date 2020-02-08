package ctci.recusion;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsWithandWithOutDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("PermsWithOutDups : "+new PermutationsWithandWithOutDups().getPermsWithOutDups("123"));
		
		System.out.println("PermsWithDups : "+new PermutationsWithandWithOutDups().getPermsWithDups("123"));

	}
/**
 * getPermsWithOutDups
 */
	ArrayList<String> getPermsWithOutDups(String s) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}

	HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}

	void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
		/* Base case. Permutation has been completed. */
		if (remaining == 0) {
			result.add(prefix);
			return;
		}

		/* Try remaining letters for next char, and generate remaining permutations. */

		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c, count - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c, count);
			}
		}
	}
	
	
	/**
	 * getPermsWithDups
	 */
	ArrayList<String> getPermsWithDups(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPerms("", str, result);
		return result;
	}

	void getPerms(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0)
			result.add(prefix);

		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}

	}
