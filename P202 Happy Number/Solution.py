class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        unique_number_set = set()
        while n not in unique_number_set:
            unique_number_set.add(n)
            value = 0
            while n > 0:
                value += (n%10)*(n%10)
                n /= 10
            n = value
        return n == 1