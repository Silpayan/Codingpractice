package leetcode.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 692. Top K Frequent Words
 */
public class TopKFrequentWords {

	public static void main(String[] args) {

		String words[] = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		//{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};//{"i","love", "leetcode", "i","love","coding"};
		int k = 4;
		System.out.println("Top K Frequent Words : "+topKFrequent(words, k));
	}

	public static List<String> topKFrequent(String[] words, int k) {
		// build hash map : character and how often it appears
	    HashMap<String, Integer> frqMap = new HashMap();
	    for (String n: words) {
	      frqMap.put(n, frqMap.getOrDefault(n, 0) + 1);
	    }

	    // init heap 'the less frequent element first'
	    PriorityQueue<String> sortedByFrq =
	            new PriorityQueue<String>((w1,w2) -> frqMap.get(w1).equals(frqMap.get(w2)) ? 
	            		w2.compareTo(w1) : frqMap.get(w1)-frqMap.get(w2));
	    /*
	    *Lamda expression for sorting
	    *1. if frequency is same then compare the words
	    *2. Else higher frequency words go first
	    */

	    // keep k top frequent elements in the heap
	    for (String n: frqMap.keySet()) {
	      sortedByFrq.add(n);
	      if (sortedByFrq.size() > k)
	        sortedByFrq.poll();
	    }

	    // build output list
	    List<String> top_k = new LinkedList();
	    while (!sortedByFrq.isEmpty())
	      top_k.add(sortedByFrq.poll());
	    Collections.reverse(top_k);
	    
	    
	    return top_k;
    }
}
