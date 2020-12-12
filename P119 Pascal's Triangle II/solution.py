class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        result = []
        result = [None for _ in range(rowIndex+1)]
        result[0], result[-1] = 1, 1
        
        for j in range(1, rowIndex):
            result[j] = result[j-1] * (rowIndex + 1 - j) // j
        
        return result
