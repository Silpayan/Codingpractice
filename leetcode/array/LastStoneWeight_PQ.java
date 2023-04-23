package leetcode.array;

import java.util.Arrays;

public class LastStoneWeight_PQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[] = {8};
		
		System.out.println(lastStoneWeight(stones));
		
	}

	public static int lastStoneWeight(int[] stones) {
     
		if(stones.length==1) {
			return stones[stones.length-1];
		}
		Arrays.sort(stones);
		
		
		while(stones[stones.length-2]!=0) {
			System.out.println("Last element  "+ stones[stones.length-1]);
			stones[stones.length-2]=(stones[stones.length-1]-stones[stones.length-2]);
			stones[stones.length-1]=0;
			Arrays.sort(stones);
			System.out.println("Second last element =  "+ stones[stones.length-2]);
		}
		
		return stones[stones.length-1];	
    }
	
	/*
	 *         PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer> () {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            }
        );
        
        for (int i = 0; i < stones.length; i++)  {
            
            pq.add(stones[i]);
            
        }
        
        while (pq.size() > 1) {
            int highestNum = pq.poll();
            int secondHighestNum = pq.poll();
            
            pq.add(highestNum - secondHighestNum);
        }
        
        return pq.poll();
    }
	 */

	
}
