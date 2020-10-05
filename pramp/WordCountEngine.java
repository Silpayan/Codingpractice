package pramp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * mplement a document scanning function wordCountEngine, which receives a string document and returns a list 
 * of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending 
 * order. If two or more words have the same count, they should be sorted according to their order in the original 
 * sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, 
 * the words “Perfect” and “perfect” should be considered the same word.
 */
public class WordCountEngine {

	static String[][] wordCountEngine(String document) {
		// your code goes here

		//String[] words = document.split(" ");

		String[] words = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");

		Map<String, Integer> wordC = new HashMap<String, Integer>();

		//System.out.println(words.length);
		
		for (String word : words) {
			
			wordC.put(word, wordC.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> wordP = new PriorityQueue<String>(//(w1,w2) -> document.indexOf(w1) - document.indexOf(w2));
				(w1, w2) -> wordC.get(w1) != wordC.get(w2) ? wordC.get(w2) - wordC.get(w1) : document.indexOf(w2) - document.indexOf(w1));
		// checkPrior(w1,w2, wordC)
		
	    List<String> list = new ArrayList<String>(wordC.keySet());
	    
	    Collections.sort(list, (w1, w2) -> wordC.get(w1) != wordC.get(w2) ? wordC.get(w2) - wordC.get(w1) : document.indexOf(w2) - document.indexOf(w1));
	    

		for (String k : wordC.keySet()) {
			wordP.offer(k);
		}
		
		System.out.println("P Queue : "+wordP);
		
		System.out.println("List : "+list);

		String[][] result = new String[wordP.size()][2];
		//int i = 0;
		//for (String w : wordP) {
		for(int i=0;i<wordC.size();i++) {	
			result[i][0] = wordP.remove();
			result[i][1] = wordC.get(result[i][0]).toString();
			//i++;
		}

		return result;

		// a-z A-Z 0-9

		/*
		 * lmap.entrySet().stream()
		 * .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .forEach(entry
		 * -> result.add(new String[]{entry.getKey(), entry.getValue().toString()}) );
		 */
	}

	public static void main(String[] args) {
		
		String result1[][] = wordCountEngine("Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!");

		System.out.println("Result1 : ");
		for (String[] a : result1) {
			System.out.println(a[0] + ", " + a[1]);
		}
		
		result1 = wordCountEngine("To be, or not to be, that is the question:");

		/*System.out.println("Result1 : ");
		for (String[] a : result1) {
			System.out.println(a[0] + ", " + a[1]);
		}*/
		
		result1 = wordCountEngine("Cause I'm Slim Shady, yes I'm the real Shady, All you other Slim Shadys are just imitating So won't the real Slim Shady, please stand up, Please stand up, Please stand up");

		/*System.out.println("Result1 : ");
		for (String[] a : result1) {
			System.out.println(a[0] + ", " + a[1]);
		}*/
	}
	
	/*
	 * Expected : [["just","4"],["practice","3"],["perfect","2"],["makes","1"],["youll","1"],["get","1"],["by","1"]]
	 * Actual :   [[just, 4], [by, 1], [practice, 3], [youll, 1], [get, 1], [makes, 1], [perfect, 2]]
	 * 
	 * Expected : [["to","2"],["be","2"],["or","1"],["not","1"],["that","1"],["is","1"],["the","1"],["question","1"]]
     * Actual :   [[to, 2], [be, 2], [question, 1], [the, 1], [or, 1], [not, 1], [is, 1], [that, 1]]
	 * 
	 */
}

class Solution {
  
  
  static HashMap<String, Integer> dict = new HashMap<String, Integer>(); 
  static ArrayList<Word> con = new ArrayList<Word>(); 
  
  
  class Word implements Comparable<Word>{
    String word;
    int occur; 
    
    public Word(String in, int cc){
      word = in;
      occur = cc; 
    }
    
    public int compareTo(Word obj2){
      if(this.occur != obj2.occur){
        return obj2.occur - this.occur; 
      } else {
        return obj2.word.compareTo(this.word); 
      }
    }
  }
  
  static String[][] wordCountEngine(String document) {
    // your code goes here
   
    String[] tc = document.split(" "); 
    for(String trav: tc){
      if(dict.get(trav) != null){
        dict.put(trav, dict.get(trav)+1);
      } else {
        dict.put(trav, 1); 
      }
    }
    
    //sort the words 
    for(String ty: dict.keySet()){
        //con.add(new Word(ty, dict.get(ty))); 
    }
    Collections.sort(con); 
    
    String[][] ret = new String[dict.size()][2];
    int pos = 0; 
    for(Word tl: con){
      ret[pos][0] = tl.word; 
      ret[pos][1] = Integer.toString(tl.occur); 
      pos++; 
    }
    
    return ret; 
    
    /*
        HashMap -> Word to Occurences
        Object -> String, Occurences -> compareTo sort Occurences, sort by lexigraphical comp
    */
  }

  public static void main(String[] args) {

  }

}


