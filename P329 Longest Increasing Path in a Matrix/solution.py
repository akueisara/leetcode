class Solution:
    # down, right, up, left
    directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    m = 0
    n = 0
    
    # 1. DFS
    # Time: O(2^(m+n))
    # Space: O(mn)
    # 2. DFS + cache
    # Time: O(mn)
    # Space: O(mn)
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0
        self.m = len(matrix)
        self.n = len(matrix[0])
        cache = [[0] * self.n for _ in range(self.m)]
        result = 0
        for i in range(self.m):
            for j in range(self.n):
                # 1
                # result = max(result, self.dfs(matrix, i, j))
                # 2
                result = max(result, self.dfs_with_cache(matrix, i, j, cache))
                
        return result
    
    def dfs(self, matrix: List[List[int]], i: int, j: int) -> int:
        result = 0
        for direction in self.directions:
            x = i + direction[0]
            y = j + direction[1]
            if 0 <= x and x < self.m and 0 <= y and y < self.n and matrix[x][y] > matrix[i][j]:
                result = max(result, self.dfs(matrix, x, y))
        result += 1
        return result
        
    def dfs_with_cache(self, matrix: List[List[int]], i: int, j: int, cache: List[List[int]]) -> int:
        if cache[i][j] != 0:
            return cache[i][j]
        for direction in self.directions:
            x = i + direction[0]
            y = j + direction[1]
            if 0 <= x and x < self.m and 0 <= y and y < self.n and matrix[x][y] > matrix[i][j]:
                cache[i][j] = max(cache[i][j], self.dfs_with_cache(matrix, x, y, cache))
        cache[i][j] += 1
        return cache[i][j]