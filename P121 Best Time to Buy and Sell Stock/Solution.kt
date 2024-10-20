class Solution {
    // Approach 1: Brute Force -> Time Limit Exceeded
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0
        var maxProfit = 0
        for (i in prices.indices) {
            for (j in i + 1 until prices.size) {
                val profit = prices[j] - prices[i]
                if (profit > maxProfit) maxProfit = profit
            }
        }
        return maxProfit
    }

    // Approach 2: One Pass
    // Time complexity: O(n)
    // Space complexity: O(1)
    fun maxProfit2(prices: IntArray): Int {
        if (prices.size < 2) return 0
        var minPrice = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            } else {
                val profit = prices[i] - minPrice
                if (profit > maxProfit) maxProfit = profit
            }
        }
        return maxProfit
    }
}