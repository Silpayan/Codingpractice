package leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 
 * 5329. Reduce Array Size to The Half
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 */
public class ReduceArraySizetoTheHalf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(new ReduceArraySizetoTheHalf().minSetSize(arr));
	}

	
public int minSetSize(int[] arr) {
        
	Map<Integer,Integer> mnumFrq = new HashMap<Integer,Integer>();
		for(int a:arr) {
			mnumFrq.put(a,mnumFrq.getOrDefault(a, 0)+1);
		}
		
		PriorityQueue<Integer> sortedByFrq =
	            new PriorityQueue<Integer>((w1,w2) -> mnumFrq.get(w1).equals(mnumFrq.get(w2)) ? 
	            		w2.compareTo(w1) : mnumFrq.get(w1)-mnumFrq.get(w2));
	    /*
	    *Lamda expression for sorting
	    *1. if frequency is same then compare the words
	    *2. Else higher frequency words go first
	    */

	    // keep k top frequent elements in the heap
		int k = arr.length;
	    for (Integer n: mnumFrq.keySet()) {
	      sortedByFrq.add(n);
	      if (sortedByFrq.size() > k)
	        sortedByFrq.poll();
	    }

	    // build output list
	    List<Integer> top_k = new LinkedList();
	    while (!sortedByFrq.isEmpty())
	      top_k.add(sortedByFrq.poll());
	    
	    Collections.reverse(top_k);
	    
	    System.out.println(top_k);
		return top_k.size();
    }

}
