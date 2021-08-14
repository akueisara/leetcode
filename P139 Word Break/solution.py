class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        return self._workBreak2(s, wordDict)
    
    # Approach 1: Recursion + Memoization (Top-down)
    # Time: n (recur) * n (for loop) * n (substring) => O(n^3)
    # Space: O(n)
    def _workBreak1(self, s: str, word_dict: List[str]) -> bool:
        memo = [None for i in range(0, len(s))]
        return self._recursive_word_break(s, set(word_dict), 0, memo)

    def _recursive_word_break(self, s: str, word_dict: Set[str], start: int, memo: List[bool]) -> bool:
        if start == len(s):
            return True
        if memo[start] != None:
            return memo[start]
        for i in range(start, len(s) + 1):
            if s[start: i] in word_dict and self._recursive_word_break(s, word_dict, i, memo):
                memo[start] = True
                return memo[start]
        memo[start] = False
        return False
    
    # Approach 2: DP (Bottom-up)
    # Time: O(n^3)
    # Space: n+1 => O(n)
    def _workBreak2(self, s: str, word_dict: List[str]) -> bool:
        word_dict_set = set(word_dict)
        n = len(s)
        dp = [None] * (n + 1)
        dp[0] = True
        for i in range(1, n + 1):
            for j in range(0, i):
                if dp[j] and s[j : i] in word_dict_set:
                    dp[i] = True
                    break
        return dp[n]