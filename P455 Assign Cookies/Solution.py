class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g, s = sorted(g), sorted(s)
        res, i = 0, 0
        while(res<len(g) and i<len(s)):
            if(g[res]<=s[i]):
                res+=1
            i+=1
        return res