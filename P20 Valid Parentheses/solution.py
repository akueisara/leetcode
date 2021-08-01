class Solution:
    # Time : O(N)
    # Space : O(N)    
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            elif len(stack) == 0 or c == ')' and stack.pop() != '(' or c == '}' and stack.pop() != '{' or c == ']' and stack.pop() != '[':
                return False
        return len(stack) == 0
