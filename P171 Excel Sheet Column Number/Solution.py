class Solution:
    def titleToNumber(self, s: str) -> int:
        num = 0
        time = 1
        for i in range(len(s) - 1, -1, -1):
            num += time * (ord(s[i]) - 64)
            time *= 26
        return num