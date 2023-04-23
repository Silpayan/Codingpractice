package leetcode.array.matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class WeakestMat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int mat[][] = {{1,0},{1,0},{1,0},{1,1}};
			/*{{1,1,0,0,0},
				 {1,1,1,1,0},
				 {1,0,0,0,0},
				 {1,1,0,0,0},
				 {1,1,1,1,1}};*/
		int k = 4;
		System.out.println(new WeakestMat().kWeakestRows(mat, k));

	}

	public int[] kWeakestRows(int[][] mat, int k) {
        
        if(mat==null || mat.length==0 || mat[0].length==0){
            return new int[0];
        }
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        
        for(int row=0;row<mat.length;row++){
        	m.put(row,0);
            for(int col=0;col<mat[0].length;col++){
                
                if(mat[row][col]==0){
                    m.put(row,m.get(row)+1);
                    
                }
            }
            System.out.println("Sold count = "+m.get(row));
        }

	    PriorityQueue<Integer> sortedByFrq =
	            new PriorityQueue<Integer>((w1,w2) -> m.get(w1).equals(m.get(w2)) ? 
	            		w2.compareTo(w1) : m.get(w1)-m.get(w2));
	    /*
	    *Lamda expression for sorting
	    *1. if frequency is same then compare the words
	    *2. Else higher frequency words go first
	    */

	    // keep k top frequent elements in the heap
	    for (Integer n: m.keySet()) {
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
	    
	    
	    //return top_k;
	    
	    int res[]=new int[k];
	    int count=0;
	    for(int a:top_k) {
	    	res[count++]=a;
	    }
	    
	    return res;
    }

}
