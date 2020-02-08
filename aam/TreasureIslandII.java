package aam;

import java.util.LinkedList;
import java.util.Queue;
/*
 * You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. 
 * Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest 
 * route to one of the treasure islands.

Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of the 
starting point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure island is 
marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. 
You cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to get to any of the 
treasure islands.
 * Time Complexity O(4*row*col*no of Souce) => O(row*col*source)
 * Space Complexity O(row*col) for the queue.
 */
public class TreasureIslandII {

	// Amazon | OA 2019 | Shortest Path From Multiple Sources
	// https://leetcode.com/discuss/interview-question/356150
	//Slightly modified from treasure-island. We need to add all sources into a queue and set them visited. 
	//The finding part is similar to treasure-island.
	final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	int cntItrtn = 0;

	public int shortestPath(char[][] islands) {
		if (islands.length == 0 || islands[0].length == 0)
			return -1;
		int R = islands.length, C = islands[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int steps = 1;
		// add all sources to queue and set 'visited'.
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (islands[i][j] == 'S') {
					queue.add(new int[] { i, j });
					islands[i][j] = 'D';
				}
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int[] pos = queue.poll();
				for (int[] dir : dirs) {
					
					System.out.println(cntItrtn++);
					
					int x = pos[0] + dir[0], y = pos[1] + dir[1];
					
					if (x < 0 || x >= R || y < 0 || y >= C || islands[x][y] == 'D')
						continue;
					if (islands[x][y] == 'E')
						return steps;
					queue.add(new int[] { x, y });
					islands[x][y] = 'D';
				}
			}
			++steps;
		}
		return -1;
	}

	public static void main(String[] args) {
		char[][] islands ={{'S', 'O', 'O', 'S'},
							{'D', 'O', 'D', 'D'},
							{'O', 'O', 'O', 'E'},
							{'E', 'D', 'D', 'O'}};
		System.out.println(new TreasureIslandII().shortestPath(islands));
	}
}
