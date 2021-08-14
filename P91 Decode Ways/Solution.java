class Solution {
    public int numDecodings(String s) {
        return numDecodings3(s);
    }
    
    // Apporach 1: Recursion
    // Time: O(n), where n is the length of the string
    // Space: O(n)
    private int numDecodings1(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return recusiveWithMemo(memo, 0, s);
    }
    
    private int recusiveWithMemo(Map<Integer, Integer> memo, int index, String s) {
        if(memo.containsKey(index)) {
            return memo.get(index);
        }
        
        // The end has been hit and there's no more solutions
        if (index == s.length()) {
            return 1;
        }
        
        // if the current number is 0, there's no solution
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        // At the last number, there's one solution
        if (index == s.length() - 1) {
            return 1;
        }
        
        int ans = recusiveWithMemo(memo, index + 1, s);
        // If two numbers could be decoded to a letter
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += recusiveWithMemo(memo, index + 2, s);
        }
        memo.put(index, ans);
        return ans;
    }
    
    // Approach 2: Iteration (DP)
    // Time: O(n)
    // Space: O(n+1) => O(n)
    private int numDecodings2(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        // Include the empty string ('0') in front of s
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
    
    // Approach 3: Approach 2 Optimization
    // We only use the values from one and two before the current position of dp
    // Time: O(n)
    // Space: O(1)
    private int numDecodings3(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int twoBack = 1;
        int oneBack = 1;
        for (int i = 2; i < n + 1; i++) {
            int current = 0;
            if (s.charAt(i - 1) != '0') {
                current = oneBack;
            }
            
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack;
            }
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}