// For other solutions: https://www.jiuzhang.com/solution/min-stack/
class MinStack {
    int min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack();
    }

    public void push(int x) {
       if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
         if(stack.pop() == min) {
             min=stack.pop();
         }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
