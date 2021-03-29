class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m+1][n+1];
         for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum[i+1][j+1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + mat[i][j];
            }
        }
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K);
                int r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                result[i][j] = sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
            }
        }
        return result;
    }
}