package pramp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairsWithGivenDifference {

	static int[][] findPairsWithGivenDifference(int[] arr, int k) {
		// your code goes herenew
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Integer> set = new HashSet<Integer>();

		/*
		 * 0, -1, -2, 2, 1 1 i Set.add() x-y = k x = y k- k-(-1) = 2 k-(-2) = 3
		 */

		for (int a : arr) {
			/*if (set.contains(k + a)) {// Math.abs(a)
				map.put(k + a, a);
			} */
			set.add(a);// Math.abs(k-a)
		}

		for (int a : arr) {
			if (set.contains(k + a)) {// Math.abs(a)
				map.put(k + a, a);
			}
		}

		System.out.println("Pairs With Given Difference : "+map);
		
		if (map.size() == 0) {
			return new int[0][0];
		}

		int result[][] = new int[map.size()][2];
		int i = 0;

		for (int key : map.keySet()) {
			result[i][0] = key;
			result[i][1] = map.get(key);
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 4, 1 };
		findPairsWithGivenDifference(a, 3); //[4,1]

		int a1[] = { 0, -1, -2, 2, 1 }; // Expected: [[1,0],[0,-1],[-1,-2],[2,1]]
		findPairsWithGivenDifference(a1, 1);

		int a2[] = { 1, 5, 11, 7 }; // Expected: [[7,1],[11,5]]
		findPairsWithGivenDifference(a2, 6);

		int a3[] = { 1, 7, 5, 3, 32, 17, 12 }; // Expected: []
		findPairsWithGivenDifference(a3, 17);
	}

}
