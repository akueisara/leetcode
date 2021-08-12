class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        return self._largestRectangleArea3(heights)
    
    # Approach 1: Brute Force - Time Limit Exceeded
    # Time: O(N^2)
    # Space: O(1)
    def _largestRectangleArea1(self, heights: List[int]) -> int:
        n = len(heights)
        maxArea = 0
        for i in range(n):
            mini_height = inf
            for j in range(i, n):
                mini_height = min(mini_height, heights[j])
                width = j - i + 1
                maxArea = max(maxArea, mini_height * width)
        return maxArea
    
    # Approach 2: Divide and Conquer - Time Limit Exceeded
    # Time: O(nlogn)
    # Space: O(n)
    def _largestRectangleArea2(self, heights: List[int]) -> int:
        return self._calculateArea(heights, 0, len(heights) - 1)
    
    def _calculateArea(self, heights: List[int], start: int, end: int):
        if start > end:
            return 0
        mini_index = start
        for i in range(start, end + 1):
            if heights[mini_index] > heights[i]:
                mini_index = i
        return max(
            heights[mini_index] * (end - start + 1),
            max(
                self._calculateArea(heights, start, mini_index - 1),
                self._calculateArea(heights, mini_index + 1, end)
            )
        )

    # Approach 3: Stack
    # Time: O(N), where N is the number of bars in the histogram
    # Space: O(N)
    def _largestRectangleArea3(self, heights: List[int]) -> int:
        n = len(heights)
        max_area = 0
        stack = [-1]
        for i in range(0, n):
            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
                current_height = heights[stack.pop()]
                current_width = i - stack[-1] - 1
                max_area = max(max_area, current_height * current_width)
            stack.append(i) 
        
        while stack[-1] != -1:
            current_height = heights[stack.pop()]
            current_width = n - stack[-1] - 1
            max_area = max(max_area, current_height * current_width)
        return max_area