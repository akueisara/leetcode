class Solution:
    # Time complexity : O(n), where n is the total number of characters in words
    # Space complexity : O(1), the size of the hash map is fixed as 26
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        dict = {}
        for i in range(len(order)):
            dict[order[i]] = i
        for i in range(len(words) - 1):
            for j in range(len(words[i])):
                if j >= len(words[i + 1]):
                    return False
                if words[i][j] != words[i+1][j]:
                    current_word_weight = dict[words[i][j]]
                    next_word_weight = dict[words[i+1][j]]
                    if current_word_weight > next_word_weight:
                        return False
                    else:
                        break
        return True
