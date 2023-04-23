package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/*
 * 347. Top K Frequent Elements
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		int nums[] = {1,3,3,3,1,1,2,2,3};//{1,2,3,6,7,8,10,11};//{1,2,2,3,3,4,4,5,5,6,8};//1,2,3,3,4,5
		int k=2;

		System.out.println("Top K Frequent Elements : " + topKFrequent(nums,k));
	}
public static List<Integer> topKFrequent(int[] nums, int k) {
    // build hash map : character and how often it appears
    HashMap<Integer, Integer> frqMap = new HashMap();
    for (int n: nums) {
      frqMap.put(n, frqMap.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    PriorityQueue<Integer> sortedByFrq =
            new PriorityQueue<Integer>((n1, n2) -> frqMap.get(n1) - frqMap.get(n2));//Lamda expression for sorting
    //It's a comparator written in lambda expression, which specifies how the pq should compare it's elements. 
    //In this case, the expression means the pq should give priority to the number whose count is greater.
    

    // keep k top frequent elements in the heap
    for (int n: frqMap.keySet()) {
      sortedByFrq.add(n);
      if (sortedByFrq.size() > k)
        sortedByFrq.poll();
    }

    // build output list
    List<Integer> top_k = new LinkedList();
    while (!sortedByFrq.isEmpty())
      top_k.add(sortedByFrq.poll());
    Collections.reverse(top_k);
    
    return top_k;
  }
}
