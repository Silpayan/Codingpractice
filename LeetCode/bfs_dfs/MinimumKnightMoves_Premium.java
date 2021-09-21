package leetcode.bfs_dfs;

import java.util.*;

public class MinimumKnightMoves_Premium {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(minKnightMoves(1,2));
		
		System.out.println(minKnightMoves(100,200));

	}
	
	
	public static int minKnightMoves(int x, int y) {
        // the offsets in the eight directions
        int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

        // data structures needed to move from the origin point
        Deque<int[]> originQueue = new LinkedList<>();
        originQueue.addLast(new int[]{0, 0, 0});
        Map<String, Integer> originDistance = new HashMap<>();
        originDistance.put("0,0", 0);

        // data structures needed to move from the target point
        Deque<int[]> targetQueue = new LinkedList<>();
        targetQueue.addLast(new int[]{x, y, 0});
        Map<String, Integer> targetDistance = new HashMap<>();
        targetDistance.put(x + "," + y, 0);

        while (true) {
            // check if we reach the circle of target
            int[] origin = originQueue.removeFirst();
            String originXY = origin[0] + "," + origin[1];
            if (targetDistance.containsKey(originXY)) {
                return origin[2] + targetDistance.get(originXY);
            }

            // check if we reach the circle of origin
            int[] target = targetQueue.removeFirst();
            String targetXY = target[0] + "," + target[1];
            if (originDistance.containsKey(targetXY)) {
                return target[2] + originDistance.get(targetXY);
            }

            for (int[] offset : offsets) {
                // expand the circle of origin
                int[] nextOrigin = new int[]{origin[0] + offset[0], origin[1] + offset[1]};
                String nextOriginXY = nextOrigin[0] + "," + nextOrigin[1];
                if (!originDistance.containsKey(nextOriginXY)) {
                    originQueue.addLast(new int[]{nextOrigin[0], nextOrigin[1], origin[2] + 1});
                    originDistance.put(nextOriginXY, origin[2] + 1);
                }

                // expand the circle of target
                int[] nextTarget = new int[]{target[0] + offset[0], target[1] + offset[1]};
                String nextTargetXY = nextTarget[0] + "," + nextTarget[1];
                if (!targetDistance.containsKey(nextTargetXY)) {
                    targetQueue.addLast(new int[]{nextTarget[0], nextTarget[1], target[2] + 1});
                    targetDistance.put(nextTargetXY, target[2] + 1);
                }
            }
        }
    }

    public int minKnightMovesSelf(int x, int y) { //TLE
        //Start point 0,0
        //go {{2,1}, {-2,1}, {2,-1}, {-2,-1}}
        //BFS
        //check if reached
        
        Queue<int[]> q = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        
        q.add(new int[]{0,0});
        
        int steps = 0, dirs[][] =  {{1, 2}, {2, 1}, {2, -1}, {1, -2},
                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i<size; i++){
                
                int point[] = q.poll();
                
                if(point[0] == x && point[1] == y){
                    return steps;
                }
                
                visited.add(point);
                
                for(int dir[]: dirs){
                    
                    int newPoint[] = new int[]{point[0]+ dir[0], point[1]+ dir[1]};
                    if(!visited.contains(newPoint))
                        q.add(newPoint);
                }
                
            }
            
            steps++;
            
        }
        
        return steps;
    }

}
