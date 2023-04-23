package leetcode.array;

public class ShareMaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {7,1,5,5,5,5,5,4};
		System.out.println(maxProfitOneTrade(prices));
		
		int prices1[] = {1,3,2,5};
		System.out.println(maxProfitOneTrade(prices1));
		
		int prices2[] = {7,6,4,3,1};
		System.out.println(maxProfitOneTrade(prices2));
		
		int prices3[] = {0,0,0,0,1};
		System.out.println(maxProfitOneTrade(prices3));
	}
	
	 /*public static int maxProfit(int[] prices) {
	        int profit=0;
	        int buyPrice = Integer.MAX_VALUE;
	        int sellPrice  = 0;
	        
	        
	        for(int i=0; i<prices.length; i++){
	        	
	        	System.out.println("Loop : "+i+" PurchasePrice : "+buyPrice+" SellPrice : "+sellPrice+" Profit : "+profit);
	        	
	        	if( i == prices.length-1 && sellPrice <prices[i]) {
    				sellPrice = prices[i];
    				if(buyPrice<sellPrice)
    					profit += sellPrice-buyPrice;
	        		//buyPrice = Integer.MAX_VALUE;
	        		break;
	        		
    			}
	        	
	        	if(sellPrice>buyPrice) {
	        		if(sellPrice >= prices[i] ) {//sell at toggle point
	        		profit += sellPrice-buyPrice;
	        		buyPrice = Integer.MAX_VALUE;
	        		sellPrice = 0;
	        		} 
	        	}
	        	
	        	if(buyPrice> prices[i]) {//buy cheap even cheaper and buy price should not be sell price
	        		
	        		buyPrice = prices[i];
	        		continue;
	        	}

	        	if(sellPrice < prices[i]){//buyPrice>= prices[i] then update the sellPrice
	        		
	        		sellPrice = prices[i];
	        		//continue;
	        		
	        	}
	        	
	        }
	        
	        return profit;
	    }*/
	 
	 
	 	public static int maxProfit(int[] prices) {
	        if (prices.length <= 1) return 0;
	        int total = 0;
	        for (int i = 1; i < prices.length; i++) {
	            if (prices[i] > prices[i - 1]) {
	                total += prices[i] - prices[i - 1];
	            }
	        }
	        return total;
	    }

	public static int maxProfitOneTrade(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int maxProfit = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min = min<prices[i]?min:prices[i];
			maxProfit = maxProfit>(prices[i]-min)?maxProfit:(prices[i]-min);
		}
		return maxProfit;
	}

}
