package pramp;

import java.util.LinkedList;
import java.util.Queue;
//import org.junit.Before;
//import org.junit.Test;

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
        if (grid.length == 0 || grid[0].length == 0 || grid[sr][sc] == 0) {
            return -1;
        }

        int steps = 0;

        Queue<int[]> points = new LinkedList<>();

        points.offer(new int[]{sr, sc});

        while (!points.isEmpty()) {

            int size = points.size();

            for (int i = 0; i < size; i++) {
                int[] point = points.poll();

                if (point[0] == tr && point[1] == tc) {
                    return steps;
                }

                grid[point[0]][point[1]] = 0;

                //do BFS 4 dir
                addNeiboursToQueue(point, grid, points);

            }
            steps++;
        }
        return -1;
    }

    private static void addNeiboursToQueue(int[] point, int[][] grid, Queue<int[]> points) {


        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int[] d : dir) {
            int newR = point[0] + d[0], newC = point[1] + d[1];

            if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 1) {
                points.offer(new int[]{newR, newC});
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        int count = shortestCellPath(grid, 0, 1, 0, 0);
        System.out.println(count);

        //assertEqual(shortestCellPath(grid, 0, 1, 0, 0),8);

        int[][] grid1 = {{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}};
        int count1 = shortestCellPath(grid1, 0, 0, 2, 0);
        System.out.println(count1);

    }
}
