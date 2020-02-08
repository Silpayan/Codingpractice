package leetcode.dp;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 
 * and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2 }, B = { -2, -1 }, C = { -1, 2 }, D = { -2, 2 };

		FourSumII fs2 = new FourSumII();

		System.out.println("Four Sum count : "+fs2.fourSumCountLC(A, B, C, D));

	}

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// List<List<Integer>> result = new ArrayList<List<Integer>>();
		int count = 0;

		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		Arrays.sort(D);

		for (int a : A) {
			for (int b : B) {
				for (int c : C) {
					for (int d : D) {
						if (a + b + c + d == 0)
							count++;
					}
				}
			}
		}

		return count;
	}

	public int fourSumCountLC(int[] A, int[] B, int[] C, int[] D) {
		if (A == null || B == null || C == null || D == null) {
			return 0;
		}

		Map<Integer, Integer> mapAB = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				Integer count = mapAB.get(sum);
				if (count == null) {
					count = 0;
				}
				mapAB.put(sum, count + 1);
				System.out.println(sum);
			}
		}
		
		System.out.println("MapAB size : "+mapAB.size());

		int result = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				System.out.println(sum);
				if (mapAB.containsKey(-sum))
					result += mapAB.get(-sum);
			}
		}

		return result;
	}

}
