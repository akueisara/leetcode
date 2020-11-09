class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        if n == 0:
            return False
        i = 0
        while i < m:
            if target < matrix[i][0]:
                return False
            elif target <= matrix[i][n-1]:
                for j in range(len(matrix[i])):
                    if target == matrix[i][j]:
                        return True
                break
            else:
                i += 1
        return False