class Solution {
    // down, right, up, left
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    
    // 1. DFS
    // Time: O(2^(m+n))
    // Space: O(mn)
    // 2. DFS + cache
    // Time: O(mn)
    // Space: O(mn)
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 1. DFS
                // result = Math.max(result, dfs(matrix, i, j));
                // 2. DFS + cache
                result = Math.max(result, dfsWithCache(matrix, i, j, cache));
            }
        }
        return result;
    }
    
    private int dfs(int[][] matrix, int i, int j) {
        int result = 0;
        for (int[] direction : directions) {
          int x = i + direction[0], y = j + direction[1];
          if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
              result = Math.max(result, dfs(matrix, x, y));
          }   
        }
        result++;
        return result;
    }
    
    private int dfsWithCache(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        for (int[] direction : directions) {
            int x = i + direction[0], y = j + direction[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfsWithCache(matrix, x, y, cache));
            }  
        }
        cache[i][j]++;
        return cache[i][j];
    }
}