// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int hold = -prices[0]; 
        int sold = 0; 
        int coldDown = 0; 

        for (int i = 1; i < n; i++) {
            int prevHold = hold; 
            int prevSold = sold; 
            int prevColdDown = coldDown; 

            hold = Math.max(prevHold, prevColdDown - prices[i]); 
            sold = prevHold + prices[i]; 
            coldDown = Math.max(prevColdDown, prevSold); 
        }
        
        return Math.max(sold, coldDown); 
    }
}