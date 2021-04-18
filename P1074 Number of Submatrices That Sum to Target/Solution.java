class Solution {
    // Time complexity: O(mn^2)
    // Space complexity: O(mn) for the matrix
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        /*
             i=0     i=1     i=2  n -> i is the top left of a submatrix 
             j=0to2 j=1to2 j=2to2   -> j is the top right of a submatrix
        k=0   0       1       0     prefix sum -> 0 1 1 
        k=1   1       1       1     prefix sum -> 1 2 3
        k=2   0       1       0     prefix sum -> 0 1 1
         m
        k is the bottom of a submatrix

        i = 0, ..., n
        j = i, ..., n
        k = 0, ..., m
        target = 0
        */
        int res = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                matrix[i][j] += matrix[i][j - 1];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}