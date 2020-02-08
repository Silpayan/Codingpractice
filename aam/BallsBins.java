package aam;

public class BallsBins {

	public static void main(String[] args) {
		/*
		 * Give m balls and n bins. Find out how many ways to assign balls to bins.
		 * Notice the buckets has no order. Like (1,2,3) and (3,2,1) are considered the
		 * same. eg, m = 3, n = 2, return 2. (1, 2) and (3, 0)
		 */
		
		int combi = assignBalls(11,12);
		System.out.println(combi);

	}
	
	static int assignBalls(int m, int n) {
        if (m == 0 || n == 1) {
            return 1;
        }
        if (n > m) {
            return assignBalls(m, m);
        } else {
            return assignBalls(m, n - 1) + assignBalls(m - n, n);
        }
    }
	

}
