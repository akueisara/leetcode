class Solution:
    # Time: O(2^n), where n is the length of digits
    # Space: O(n)
    def letterCombinations(self, digits: str) -> List[str]:
        result = []
        if not digits:
            return result
        result.append("")
        letter_sets = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        for i in range(len(digits)):
            result = self.get_combinations(letter_sets[ord(digits[i]) - ord('0')], result)
        return result
            
    def get_combinations(self, possible_letters: str, current_result: List[str])-> List[str]:
        result = []
        for i in range(len(possible_letters)):
            for s in current_result:
                result.append(s + possible_letters[i])
        return result
