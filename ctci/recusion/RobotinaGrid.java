package ctci.recusion;

import java.util.ArrayList;
import java.util.HashSet;

import aam.TreasureIsland;

public class RobotinaGrid {

	public static void main(String[] args) {
		boolean[][] maze = {{true, false, true, true},
						 {false, true, true, true},
						 {true, true, true, true},
						 {true, true, true, true}};
	ArrayList<Point> result = new RobotinaGrid().getPath(maze);
	System.out.println("Result : ");
	if(result!=null)
		for(Point p: result)
		System.out.println(p.a+", "+p.b);

	}
	int count=0;
	ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}
		return null;
	}

	boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
		
		System.out.println(row+" "+col+" "+count++ +" "+failedPoints);
		/* If out of bounds or not available, return. */
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}

		Point p = new Point(row, col);
		
		//System.out.println(p.equals(p));

		/* If we've already visited this cell, return. */
		if (failedPoints.contains(p)) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (col == 0);

		/* If there's a path from start to my current location, add my location. */
		if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints)
				|| getPath(maze, row - 1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}

		
		failedPoints.add(p); // Cache result // coment out complexity O(2^row+col)
		return false;
	}

	private class Point {
		int a;
		int b;

		Point(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public String toString(){
			
			return a+","+b;			
		}
		
		public int hashCode() {
			//System.out.println(a*10+b);
			 return a*10+b;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof Point) {
				Point p = (Point)o;
				System.out.println(a==p.a && b==p.b);
				return a==p.a && b==p.b;
			}
			return false;
		}
		
	}

}
