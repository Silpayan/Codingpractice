package leetcode.dp;

/*
 * 256 Paint House
 * There are row of n houses, each house can be painted with one of the 3 colors:red, blue or green.
 * The cost of paining each house with a certain color is different. You have to paint all the houses 
 * such that no 2 adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a nx3 cost matrix .
 * For ex. costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the 
 * cost of painting hose 1 with color green, and and so on....
 * Find the min cost to paint all the houses.
 * 
 */
public class PaintHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int costs[][] = {{17,2,1},
						{2,16,3},
						{2,3,19}};
		
		System.out.println(minCost(costs)+"\n Costs : ");
		
		for(int []a:costs) {
			System.out.println(a[0]+", "+a[1]+", "+a[2]);
		}
		}
	
	public static int minCost(int[][] costs) {
		if(costs == null || costs.length ==0)
			return 0;
		
		for(int i=1;i<costs.length; i++) {
			costs[i][0]+=Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1]+=Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2]+=Math.min(costs[i-1][0], costs[i-1][1]);
		}
		
		return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
	}

}
