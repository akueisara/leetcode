class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return false;
        }
        int i = 0;
        while(i < m) {
            if(target < matrix[i][0]) {
                return false;
            } else if(target <= matrix[i][n-1]) {
                for(int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == target) {
                        return true;
                    }
                }
                break;
            } else {
                i++;
            }
        }
        return false;
    }
}