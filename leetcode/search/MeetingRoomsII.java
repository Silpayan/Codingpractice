package leetcode.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* 253. Meeting Rooms II
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the 
 * minimum number of conference rooms required. For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */

public class MeetingRoomsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] intervals = {{0, 30},{5, 10},{15, 20}};
				
		System.out.println(new MeetingRoomsII().minMeetingRooms(intervals));
	}
	
	public int minMeetingRooms(int[][] intervals) {
	    
        //sort the meetings
        
        Arrays.sort(intervals, new Comparator<int[]>(){
                                        @Override
                                        public int compare(int a[], int b[]){
                                            return a[0]-b[0];
                                        }
                                    });
            
        
        //System.out.println(intervals);
        //start a meeting by iterating over them
        int room = 0;
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        
        
        for(int interval[]:intervals){
            endTime.offer(interval[1]);
            //System.out.println("Size : "+endTime.size());
            
            if(interval[0]>=endTime.peek()){
                endTime.poll();
            }
                
            /*if(interval[0]<endTime.peek()) {
                room++;
            } else{
                endTime.poll();
            }*/
            
        }
        
        //push the end time in a PQ as we can remove when checking next meeting time if this became avail/prev meeting got over
            
            return endTime.size();
    
    }
    
        
    public int minMeetingRoomsLC(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        int room = 0;
        for(int i = 0; i < intervals.length; i++){
            endTime.offer(intervals[i][1]);
            if(intervals[i][0] < endTime.peek())  room++;
            else{
                endTime.poll();
            }
        }
        return room;
    }
}
