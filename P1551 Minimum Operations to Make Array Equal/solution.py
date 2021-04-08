class Solution:
    # Time: O(logn)
    # Space: O(1)
    def minOperations2(self, n: int) -> int:
        half_end_index = n // 2
        result = 0
        for i in range(half_end_index):
            result += n - (2*i + 1)
        return result
    
    # Time: O(1)
    # Space: O(1)
    def minOperations(self, n: int) -> int:
        half_end_index = n // 2
        return half_end_index * half_end_index + n % 2 * half_end_index
