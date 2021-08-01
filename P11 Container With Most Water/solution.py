class Solution:
    def maxArea(self, height: List[int]) -> int:
        return self._maxArea2(height)
    
    # Approach 1: Brute Force
    # Time: O(N ^ 2)
    # Space: O(1)
    def _maxArea1(self, height: List[int]) -> int:
        result = 0
        for i in range(0, len(height)):
            for j in range(i + 1, len(height)):
                result = max(result, min(height[i], height[j]) * (j - i))
        return result
    
    # Approach 2: Two pointers
    # Time: O(N)
    # Space: O(1)
    def _maxArea2(self, height: List[int]) -> int:
        result = 0
        left = 0
        right = len(height) - 1
        while left != right:
            result = max(result, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return result 