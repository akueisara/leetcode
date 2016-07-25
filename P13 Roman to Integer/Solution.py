class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        dict = ["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"]
        num = [1000,900,500,400,100,90,50,40,10,9,5,4,1]
        i, index, ret = 0, 0, 0
        while(i<len(s) and index<13):
            target = dict[index]
            cur = s[i:i+len(target)]
            if(cur==target):
                ret += num[index]
                i += len(target)
            else:
                index += 1
        return ret