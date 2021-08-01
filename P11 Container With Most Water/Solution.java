class Solution {
    public int maxArea(int[] height) {
        return maxArea2(height);
    }
    
    // Approach 1: Brute Force
    // Time: O(N ^ 2)
    // Space: O(1)
    private int maxArea1(int[] height) {
        int result = 0;
        // left pointer
        for (int i = 0; i < height.length; i++) {
            // right pointer
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return result;
    }
    
        
    // Approach 2: Two pointers
    // Time: O(N)
    // Space: O(1)
    private int maxArea2(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left != right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
    
}