class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return workBreak2(s, wordDict);
    }
    
    // Approach 1: Recursion + Memoization (Top-down)
    // Time: n (recur) * n (for loop) * n (substring) => O(n^3)
    // Space: O(n)
    private boolean workBreak1(String s, List<String> wordDict) {
        return recursiveWordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    // memo to record 
    private boolean recursiveWordBreak(String s, Set<String> wordDict, int start, Boolean[] memo) {
        // it hits the end
        if (start == s.length()) {
            return true;
        }
        // get the cache value
        if (memo[start] != null) {
            return memo[start];
        }
        // O(n)
        for (int i = start + 1; i <= s.length(); i++) {
            // O(n)
            if (wordDict.contains(s.substring(start, i)) && recursiveWordBreak(s, wordDict, i, memo)) {
                memo[start] = true;
                return true;
            }
        }
        // Nothing works out
        memo[start] = false;
        return false;
    }
    
    // Approach 2: DP (Bottom-up)
    // Time: O(n^3)
    // Space: n+1 => O(n)
    private boolean workBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // O(n)
        for (int i = 1; i <= n; i++) {
            // o(n)
            for (int j = 0; j < i; j++) {
                // O(n) for substring computation
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}