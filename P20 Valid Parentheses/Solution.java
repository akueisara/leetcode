class Solution {
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
}
