class Solution {
    // Time : O(n), n is the length of the string.
    // Space: O(n), the size of the stack can be up to n. It could be improved to O(1) by scaning the string from left to right and right to left
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int pointer = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                   stack.push(i); 
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}