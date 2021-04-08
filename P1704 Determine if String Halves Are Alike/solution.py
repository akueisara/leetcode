class Solution:
    # Time: O(n), where n is the length of s
    # Space: O(1)
    def halvesAreAlike(self, s: str) -> bool:
        first_half_count = 0
        second_half_count = 0
        vowels = "aeiouAEIOU"
        for i in range(len(s)):
            if s[i] in vowels:
                if i < len(s) / 2:
                    first_half_count += 1
                else:
                    second_half_count += 1
        return first_half_count == second_half_count
