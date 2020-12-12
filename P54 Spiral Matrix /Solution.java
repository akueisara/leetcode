class Solution {
    // Time Complexity: O(N), where N is the total number of elements in the input matrix. We add every element in the matrix to our final answer.
    // Space Complexity: O(N), the information stored in res.
    public List<Integer> spiralOrder(int[][] matrix) {
        // 0,0 -> 0,1 -> 0,matrix[0].length -1 -> 
        // 1, matrix[0].length -1 -> .. -> matrix[1].length -1, matrix[0].length -1 ->
        // matrix[1].length -1, 1 -> matrix[1].length -1, matrix[0].length -1 -1 -> 
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }
}