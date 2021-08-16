class Solution:
    # Approach: Sliding Window
    # Time: O(n)
    # Space: O(1)
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        left, right, max_len = 0, 0, 0
        map = {}
        while right < len(s):
            map[s[right]] = right
            if len(map) == 3:
                left_most_index = min(map.values())
                map.pop(s[left_most_index])
                left = left_most_index + 1
            max_len = max(max_len, right - left +1)
            right += 1
        return max_len