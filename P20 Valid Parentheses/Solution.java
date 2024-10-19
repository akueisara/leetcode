class Solution {
    // Time: O(N)
    // Space: O(N)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.empty() || c == ')' && stack.pop() != '(' || c == '}' && stack.pop() != '{' || c == ']' && stack.pop() != '[') {
               return false;
            }
        }
        return stack.empty();  
    }

    // Time: O(N)
    // Space: O(N)
    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) return false;
        
        Map<Character, Character> bracketMap = Map.of('(', ')', '[', ']', '{', '}');
        Deque<Character> endBracketStack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                endBracketStack.addLast(bracketMap.get(c));
            } else {
                if (endBracketStack.isEmpty() || endBracketStack.removeLast() != c) {
                    return false;
                }
            }
        }
        return endBracketStack.isEmpty();
    }
}