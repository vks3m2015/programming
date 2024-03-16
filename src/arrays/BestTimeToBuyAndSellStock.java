package arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and
 choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

//https://www.youtube.com/watch?v=34WE6kwq49U


class BestTimeToBuyAndSellStock {
	
	
	 public int maxProfit(int[] prices) {
		 
		 int max_profit = 0;
		 int lowest_price_so_far = prices[0];
		 
		 for(int i=1; i< prices.length; i++) {
			 
			if(prices[i] < lowest_price_so_far) lowest_price_so_far = prices[i];
			 
			// lowest_price_so_far = Math.min(lowest_price_so_far, prices[i]);
			 
			int profit = prices[i] - lowest_price_so_far;
			
			//max_profit = Math.max(max_profit, profit);
			if(profit > max_profit)
				max_profit = profit;
			
			 
			 
		 }
	        
		 return max_profit;
	 }

	public static void main(String[] args) {
		

	}

}
