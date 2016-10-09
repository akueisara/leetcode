class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        len1 = len(num1) - 1
        len2 = len(num2) - 1
        carry = 0
        res = ""
        while(len1>=0 or len2>=0 or carry):
            sum = 0
            if(len1 >= 0):
                sum += (ord(num1[len1]) - 48)
                len1 -= 1
            if(len2 >= 0):
                sum += (ord(num2[len2]) - 48)
                len2 -= 1
            sum += carry
            carry = sum / 10
            sum = sum % 10
            res = str(sum) + res
        return res