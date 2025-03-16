class Solution {
    public int maxProfit_solution1(int[] prices) {
        int l = 0;
        int maxProfit = 0;
        for(int r = 1; r < prices.length;r++) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else
                l = r;
        }
        return maxProfit;
    }

    public int maxProfit_solution2(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++) {
            if(prices[i] <= min)
                min = prices[i];
            else {
                int profit = prices[i]-min;
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }


}