class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        count = collections.Counter(magazine)
        for letter in ransomNote:
            count[letter] -= 1
            if count[letter] <0: return False
        return True