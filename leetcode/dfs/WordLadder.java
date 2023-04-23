package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import javafx.util.Pair;

public class WordLadder {

	public static void main(String[] args) {

		String beginWord = "hit",
				endWord = "cog";
		Set<String> wordList = new HashSet<String>();//{"hot","dot","dog","lot","log","cog"};
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		System.out.println(ladderLength(beginWord, endWord, wordList));

	}

	/*public int ladderLength(String beginWord, String endWord, List<String> wordList) {

	    // Since all words are of same length.
	    int L = beginWord.length();

	    // Dictionary to hold combination of words that can be formed,
	    // from any given word. By changing one letter at a time.
	    HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

	    wordList.forEach(
	        word -> {
	          for (int i = 0; i < L; i++) {
	            // Key is the generic word
	            // Value is a list of words which have the same intermediate generic word.
	            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
	            ArrayList<String> transformations =
	                allComboDict.getOrDefault(newWord, new ArrayList<String>());
	            transformations.add(word);
	            allComboDict.put(newWord, transformations);
	          }
	        });

	    // Queue for BFS
	    Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
	    Q.add(new Pair(beginWord, 1));

	    // Visited to make sure we don't repeat processing same word.
	    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
	    visited.put(beginWord, true);

	    while (!Q.isEmpty()) {
	      Pair<String, Integer> node = Q.remove();
	      String word = node.getKey();
	      int level = node.getValue();
	      for (int i = 0; i < L; i++) {

	        // Intermediate words for current word
	        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

	        // Next states are all the words which share the same intermediate state.
	        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
	          // If at any point if we find what we are looking for
	          // i.e. the end word - we can return with the answer.
	          if (adjacentWord.equals(endWord)) {
	            return level + 1;
	          }
	          // Otherwise, add it to the BFS Queue. Also mark it visited
	          if (!visited.containsKey(adjacentWord)) {
	            visited.put(adjacentWord, true);
	            Q.add(new Pair(adjacentWord, level + 1));
	          }
	        }
	      }
	    }

	    return 0;
	  }*/

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 1;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}
			beginSet = temp;
			len++;
		}
		return 0;
	}
}
