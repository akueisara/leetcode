from string import ascii_lowercase as al

class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == None or len(s) == 0:
            return -1
        dic = {x:i for i, x in enumerate(al, 1)}
        result = 0
        for i in range(len(s)):
            result = result + dic[str(s[i]).lower()] * pow(26, len(s)-1-i)
        return result
        """
        if s == None or len(s) == 0:
            return -1
        result = 0
        for i in range(len(s)):
            result = result + (ord(s[i])-ord('A')+1) * pow(26, len(s)-1-i)
        return result
        """