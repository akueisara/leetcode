class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def constructArray(self, n: int, k: int) -> List[int]:
        # if n = 6, k = 3
        # [1,2,3,6,4,5]
        # [1, ..., n-k-1], [n-k, ..., n] => [1, ..., 2], [3, ..., 6]
        # n-K-1 elements => [1, 2, ..., n - k - 1] => [1, 2]
        # distances are always 1: [1]
        # k+1 elements => [n-k + 0, n - 0, n-k + 1, n - 1, n-k + 2] => [3, 6, 4, 5]
        # distances are increasing by 1 starting from k: [k, k+1, k+2, k+3, ...]           
        result = []
        for i in range(1, n-k):
            result.append(i)
        for i in range(k+1):
            if i % 2 == 0:
                result.append(n - k + i//2)
            else:
                result.append(n - i//2)
        return result
