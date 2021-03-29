class Solution:
    # Time: O(n), where n is the total number of characters in A
    # Space: O(1)
    def commonChars(self, A: List[str]) -> List[str]:
        count = 26 * [100]
        for s in A:
            individual_count = 26 * [0]
            for c in s:
                individual_count[ord(c) - ord('a')] += 1
            for i in range(26):
                count[i] = min(individual_count[i], count[i])
                
        result = []
        for i in range(26):
            for j in range(count[i]):
                result.append(chr(i + ord('a')))
        return result
