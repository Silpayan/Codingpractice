package leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin973 {
/*
 * 973. K Closest Points to Origin
 */
	public static void main(String[] args) {

		int points[][] = {{3,3},{5,-1},{-2,4}};//{{1,3},{-2,2}};
		int K = 2;
		points = kClosest(points, K);
		System.out.println();
		for(int a[] : points) {
			System.out.println(a[0]+" , "+ a[1]);
		}
	}
	
	public static int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        for(int dist:dists) {
        	System.out.print(dist+" ");
        }
        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
	
	/*
	 * Syupid complex
	 */
	public static int[][] kClosestSupid(int[][] points, int K) {
        int nearestPoint[][] = new int[K][2];
        HashMap<String, Integer> disMap = new HashMap();
	    for (int n[]: points) {
	    	disMap.put((n[0]+","+n[1]), n[0]*n[0]+n[1]*n[1]);
	    }

	    System.out.println(disMap);
	    
	    // init heap 'the less frequent element first'
	    PriorityQueue<String> sortedByDis =
	            new PriorityQueue<String>((n1,n2) -> disMap.get(n2)-disMap.get(n1));
	    
	    // keep k top frequent elements in the heap
	    for (String n: disMap.keySet()) {
	    	sortedByDis.add(n);
	      if (sortedByDis.size() > K)
	    	  sortedByDis.poll();
	    }
	    
	 // build output list
	    List<String> closest_K = new LinkedList();
	    while (!sortedByDis.isEmpty())
	    	closest_K.add(sortedByDis.poll());
	    Collections.reverse(closest_K);
	    
	    System.out.println(closest_K);
	    
	    int i=0;
	    for(String s:closest_K) {
	    	System.out.println(s);
	    	String sA[] = s.split(",");
	    	nearestPoint[i][0] = Integer.parseInt(sA[0]);
	    	nearestPoint[i][1] = Integer.parseInt(sA[1]);
	    	i++;
	    }
        return nearestPoint;
    }
}
