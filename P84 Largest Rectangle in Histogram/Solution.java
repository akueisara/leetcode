class Solution {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea3(heights);
    }
    
    // Approach 1: Brute Force - Time Limit Exceeded
    // Time: O(N^2)
    // Space: O(1)
    private int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        // O(N)
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            // O(N)
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                maxArea = Math.max(maxArea, minHeight * width);
            }
        }
        return maxArea;
    }
    
    // Approach 2: Divide and Conquer - Time Limit Exceeded
    // Time: O(nlogn)
    // Space: O(n)
    private int largestRectangleArea2(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
    
    private int calculateArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int miniIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[miniIndex] > heights[i]) {
                miniIndex = i;
            }
        }
        return Math.max(
            heights[miniIndex] * (end - start + 1),
            Math.max(
                calculateArea(heights, start, miniIndex - 1),
                calculateArea(heights, miniIndex + 1, end)
            )   
        );
    }
    
    // Approach 3: Stack
    // Time: O(N), where N is the number of bars in the histogram
    // Space: O(N)
    private int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        // Java doc: https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
        // Deques can also be used as LIFO (Last-In-First-Out) stacks. 
        // This interface should be used in preference to the legacy Stack class. 
        // When a deque is used as a stack, elements are pushed and popped from the beginning of the deque.
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        // O(N) each element is going to be pushed and popped once
        for (int i = 0; i < n; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        // O(N)
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}