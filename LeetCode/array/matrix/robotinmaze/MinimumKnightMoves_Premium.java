package leetcode.array.matrix.robotinmaze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * 
1197. Minimum Knight Moves
Medium

In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.



Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.

 

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]*/

public class MinimumKnightMoves_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new MinimumKnightMoves_Premium().minKnightMoves(3, 3)); //|x| + |y| <= 300
	}
	
private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return result;
                }
                
                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[] {newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            //System.out.println(visited);
            result++;
        }
        return -1;
    }

}
