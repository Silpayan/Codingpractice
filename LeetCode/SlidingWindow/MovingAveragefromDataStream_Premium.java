package leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/*
 * 
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
Easy
Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAveragefromDataStream_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MovingAveragefromDataStream_Premium m = new MovingAveragefromDataStream_Premium(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
		
		System.out.println("Queue : "+ m.queue);
		
	}

	/**
	 * Your MovingAverage object will be instantiated and called as such:
	 * MovingAverage obj = new MovingAverage(size);
	 * double param_1 = obj.next(val);
	 */
	
	/** Initialize your data structure here. */
	int size;
	List queue = new ArrayList<Integer>();

	public MovingAveragefromDataStream_Premium(int size) {
      this.size = size;
    }

	public double next(int val) {
		queue.add(val);
		// calculate the sum of the moving window
		int windowSum = 0;
		for (int i = Math.max(0, queue.size() - size); i < queue.size(); ++i)
			windowSum += (int) queue.get(i);

		return windowSum * 1.0 / Math.min(queue.size(), size);
	}

}
