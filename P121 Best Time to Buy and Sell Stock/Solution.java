class Solution {
    // Approach 1: Brute Force -> Time Limit Exceeded
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }

    // Approach 2: One Pass
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }
}