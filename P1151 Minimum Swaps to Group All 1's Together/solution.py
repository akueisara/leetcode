class Solution:
    # Sliding Window with Two Pointers
    # Time complexity: O(n), when n is the length of the array.
    # Space complexity: O(1).
    def minSwaps(self, data: List[int]) -> int:
        ones_in_data = sum(data)
        ones_in_the_window = max_ones_in_the_window = 0
        left = right = 0
        
        while right < len(data):
            ones_in_the_window += data[right]
            right += 1
            if right - left > ones_in_data:
                ones_in_the_window -= data[left]
                left += 1
            max_ones_in_the_window = max(max_ones_in_the_window, ones_in_the_window)
        
        return ones_in_data - max_ones_in_the_window
