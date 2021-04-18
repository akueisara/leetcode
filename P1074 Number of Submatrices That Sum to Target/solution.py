class Solution:
    # Time complexity: O(mn^2)
    # Space complexity: O(mn) for the matrix
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
        '''
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
        '''
        res = 0
        m = len(matrix)
        n = len(matrix[0])
        for i in range(0, m):
            for j in range(1, n):
                matrix[i][j] += matrix[i][j - 1]

        for i in range(n):
            for j in range(i, n):
                counter = {}
                counter[0] = 1
                cur = 0
                for k in range(m):
                    cur += matrix[k][j]
                    if i > 0:
                        cur -= matrix[k][i - 1]
                    res += counter.get(cur - target) or 0
                    counter[cur] = (counter.get(cur) or 0) + 1
        return res
        