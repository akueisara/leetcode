class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (grid[i][j] == 1):
                    count = count + 4
                    if(i - 1 >=0 and grid[i-1][j] == 1):
                        count = count - 1
                    if(i + 1 < len(grid) and grid[i+1][j] == 1): 
                        count = count - 1
                    if(j - 1 >= 0 and grid[i][j-1] ==1):
                        count = count - 1
                    if(j + 1 < len(grid[0]) and grid[i][j+1] == 1):
                        count = count - 1
        return count