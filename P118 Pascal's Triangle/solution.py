class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        result = []
        for i in range(1, numRows+1):
            line = [None for _ in range(i)]
            line[0], line[-1] = 1, 1
            
            for j in range(1, i):
                line[j] = line[j-1] * (i - j) // j

                
            result.append(line)
            
        return result
