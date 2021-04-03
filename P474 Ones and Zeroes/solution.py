class Solution:
    # Time : O(k*m*n), where k is the length of strs
    # Space: O(m*n)
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        table = [[0] * (n+1) for _ in range(m+1)]
        print(table)
        for s in strs:
            count = self.count_zeros_and_ones(s) 
            for i in range(m, count[0] - 1, -1):
                for j in range(n, count[1] - 1, -1):
                    table[i][j] = max(table[i-count[0]][j-count[1]] + 1, table[i][j])
        return table[m][n]
    
    def count_zeros_and_ones(self, s: str) -> List[int]:
        count = [0] * 2
        for i in range(len(s)):
            count[ord(s[i]) - ord('0')] += 1
        # could just return [s.count('0'), s.count('1')]
        return count
