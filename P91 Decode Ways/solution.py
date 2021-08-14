class Solution:
    def numDecodings(self, s: str) -> int:
        return self.num_decodings_3(s)
    
    # Apporach 1: Recursion
    # Time: O(n), where n is the length of the string
    # Space: O(n)
    def num_decodings_1(self, s: str) -> int:
        memo = {}
        return self.recusive_with_memo(memo, 0, s)
    
    def recusive_with_memo(self, memo: dict[int, int], index: int, s: str) -> int:
        if memo.get(index):
            return memo[index]
        
        if index == len(s):
            return 1
        
        if s[index] == '0':
            return 0
        
        if index == len(s) - 1:
            return 1
        
        ans = self.recusive_with_memo(memo, index + 1, s)
        if int(s[index : index + 2]) <= 26:
            ans += self.recusive_with_memo(memo, index + 2, s)
        memo[index] = ans
        return ans
    
    # Approach 2: Iteration (DP)
    # Time: O(n)
    # Space: O(n+1) => O(n)
    def num_decodings_2(self, s: str) -> int:
        if s[0] == '0':
            return 0
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n + 1):
            if s[i - 1] != '0':
                dp[i] = dp[i - 1]
                
            two_digit = int(s[i - 2: i])
            if two_digit >= 10 and two_digit <= 26:
                dp[i] += dp[i - 2]
        return dp[n]

    # Approach 3: Approach 2 Optimization
    # We only use the values from one and two before the current position of dp
    # Time: O(n)
    # Space: O(1)
    def num_decodings_3(self, s: str) -> int:
        if s[0] == '0':
            return 0
        n = len(s)
        dp = [0] * (n + 1)
        one_back = 1
        two_back = 1
        for i in range(2, n + 1):
            current = 0
            if s[i - 1] != '0':
                current = one_back
            two_digit = int(s[i - 2: i])
            if two_digit >= 10 and two_digit <= 26:
                current += two_back
            two_back = one_back
            one_back = current
        return one_back