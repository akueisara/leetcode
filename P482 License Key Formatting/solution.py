class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        result = ""
        for i in range(len(S) -1, -1, -1):
            if S[i] != "-":
                if len(result) % (K + 1) == K:
                    result += "-"
                result += S[i]
        return result[::-1].upper()