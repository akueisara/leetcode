class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        result = []
        for i in range(n-1, -1, -1):
            result.append(s[i])
        return ''.join(result)