class Solution {
    // Time : O(k*m*n), where k is the length of strs
    // Space: O(m*n)
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] table = new int[(m+1)][(n+1)];
        for(String s: strs) {
            int[] count = countZerosAndOnes(s);
            for (int i = m; i >= count[0]; i--) {
               for(int j = n; j >= count[1]; j--) {
                  table[i][j] = Math.max(1 + table[i-count[0]][j-count[1]], table[i][j]);
                } 
            }
        }
        return table[m][n];
    }
    
    private int[] countZerosAndOnes(String s) {
        int[] count = new int[2];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        return count;
    }
}