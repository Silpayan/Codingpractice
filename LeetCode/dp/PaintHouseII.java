package leetcode.dp;

public class PaintHouseII {


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
		if(costs == null || costs.length == 0 || costs[0].length == 0)
			return 0;
		int m = costs.length, n = costs[0].length;
		
		// min1 is the index of the 1st-smallest cost till previous house
        // min2 is the index of the 2nd-smallest cost till previous house

        int min1 = -1, min2 = -1;

        for (int i = 0; i < m; i++) {

            int last1 = min1, last2 = min2;

            min1 = -1;
            min2 = -1;

            for (int j = 0; j < n; j++) {

                if (j != last1) {
                    // current color j is different to last min1
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];

                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                // find the indices of 1st and 2nd smallest cost of painting current house i
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {

                    min2 = min1;
                    min1 = j;

                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {

                    min2 = j;
                }
            }
        }

        return costs[m - 1][min1];
	}


}
