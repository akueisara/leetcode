class Solution:
    def myAtoi(self, s: str) -> int:
        sign = 1
        i = 0
        result = 0
        if len(s) == 0:
            return 0
        while i < len(s) and s[i] == ' ':
            i += 1
        if i < len(s) and (s[i] == '+' or s[i] == '-'):
            sign = -1 if s[i] == '-' else 1
            i += 1
        while i < len(s) and s[i] >= '0' and s[i] <= '9':
            max = 2147483647
            min = -2147483648
            if result > max // 10 or (result == max // 10 and int(s[i]) - int('0') > max % 10):
                if sign == 1:
                    return max
                else:
                    return min
            result = result * 10 + (int(s[i]) - int('0'))
            i += 1
        return sign * result