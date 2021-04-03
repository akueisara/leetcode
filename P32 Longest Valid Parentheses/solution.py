class Solution:
    # Time : O(n), n is the length of the string.
    # Space: O(n), the size of the stack can be up to n. It could be improved to O(1) by scaning the string from left to right and right to left
    def longestValidParentheses(self, s: str) -> int:
        result = 0
        stack = [-1]
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if len(stack) == 0:
                    stack.append(i)
                else:
                    result = max(result, i - stack[-1])
        return result
