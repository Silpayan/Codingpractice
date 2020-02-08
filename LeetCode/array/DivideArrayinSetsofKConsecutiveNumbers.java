package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DivideArrayinSetsofKConsecutiveNumbers {

	public static void main(String[] args) {

		int nums[] = { 15, 16, 17, 18, 19, 16, 17, 18, 19, 20, 6, 7, 8, 9, 10, 3, 4, 5, 6, 20 };
		int k = 5;

		System.out.println(new DivideArrayinSetsofKConsecutiveNumbers().isPossibleDivide(nums, k));
	}

	// We could sort the keys then add to queue, or simply use a heap. Time:
	// max(O(dlgd), O(n)), d is the number of distinct elements.

	public boolean isPossibleDivide(int[] nums, int k) {
		int len = nums.length;
		if (len % k != 0)
			return false;
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);
		for (int n : map.keySet())
			pq.add(n);
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			if (map.get(cur) == 0)
				continue;
			int times = map.get(cur);
			for (int i = 0; i < k; i++) {
				if (!map.containsKey(cur + i) || map.get(cur + i) < times)
					return false;
				map.put(cur + i, map.get(cur + i) - times);
			}
			len -= k * times;
		}
		return len == 0;
	}

}
