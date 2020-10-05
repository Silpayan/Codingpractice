package pramp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Shortest Cell Path
In a given grid of 0s and 1s, we have some starting row and column sr, sc and a target row and column tr, tc. Return the length of the shortest path from sr, sc to tr, tc that walks along 1 values only.

Each location in the path, including the start and the end, must be a 1. Each subsequent location in the path must be 4-directionally adjacent to the previous location.

It is guaranteed that grid[sr][sc] = grid[tr][tc] = 1, and the starting and target positions are different.

If the task is impossible, return -1.

Examples:

input:
grid = [[1, 1, 1, 1], 
		[0, 0, 0, 1], 
		[1, 1, 1, 1]]
sr = 0, sc = 0, tr = 2, tc = 0
output: 8

grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 0, 1, 1]]
sr = 0, sc = 0, tr = 2, tc = 0
output: -1
 * 
 */
public class ShortestPathinGrid {
	
	  static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
			// your code goes here
	    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	    Queue<Point> path = new LinkedList<>();
	    Queue<Integer> levels = new LinkedList<>();
	    Set<Integer> visited = new HashSet<>();
	    path.offer(new Point(sr, sc));
	    levels.offer(0);
	    visited.add(new Point(sr, sc).getHash());
	    while (!path.isEmpty()) {
	      Point p = path.poll();
	      int level = levels.poll();
	      if (p.x == tr && p.y == tc) {
	        return level;
	      }
	      for (int[] dir : dirs) {
	        int x = p.x + dir[0];
	        int y = p.y + dir[1];
	        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1
	           && !visited.contains(new Point(x, y).getHash())) {
	          path.offer(new Point(x, y));
	          levels.offer(level + 1);
	          visited.add(new Point(x, y).getHash());
	        }
	      }
	    }
	    return -1;
		}

		public static void main(String[] args) {
		  int[][] grid = {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
	      int count = shortestCellPath(grid, 0, 1, 0, 0);
	      System.out.println(count);
	      
	      int[][] grid1 = {{1,1,1,1},{0,0,0,1},{1,1,1,1}};
	      int count1 = shortestCellPath(grid1,0, 0, 2, 0);
	      System.out.println(count1);
 
		}
	  
	  static class Point {
	    int x;
	    int y;
	    public Point(int x, int y) {
	      this.x = x;
	      this.y = y;
	    }
	    
	    public int getHash() {
	      return (this.x + "#" + this.y).hashCode();
	    }
	  }

}
