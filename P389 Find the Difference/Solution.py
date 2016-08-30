class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        cs = collections.Counter(s)
        for letter in t:
            cs[letter] -= 1
            if cs[letter] <0: return letter
        return ''