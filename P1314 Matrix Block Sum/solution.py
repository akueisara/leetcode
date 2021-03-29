class Solution:
    # Time & space: O(m * n)
    def matrixBlockSum(self, mat: List[List[int]], K: int) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        sums = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(m):
            for j in range(n):
                sums[i+1][j+1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + mat[i][j]
        # result = [[0] * n] * m => wrong. it creates m references of [[0] * n]
        result = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                r1, c1, r2, c2 = max(0, i - K), max(0, j - K), min(m, i + K + 1), min(n, j + K + 1)
                result[i][j] = sums[r2][c2] - sums[r2][c1] - sums[r1][c2] + sums[r1][c1]
        return result