class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        Num = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        Roman = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        ans = ""
        i = 0
        while (num>0):
            times = num / Num[i]
            num %= Num[i]
            while (times>0):
                ans += Roman[i]
                times-=1
            i+=1
        return ans