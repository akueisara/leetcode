class Solution {
    // Sliding Window with Two Pointers
    // Time complexity: O(n), when n is the length of the array.
    // Space complexity: O(1).
    public int minSwaps(int[] data) {
        int onesInData = 0;
        for (int i = 0; i < data.length; i++) {
            onesInData += data[i];
        }
        int onesInTheWindow = 0, maxOnesInTheWindow = 0;
        int left = 0, right = 0;
        
        while (right < data.length) {
            onesInTheWindow += data[right];
            right++;
            if (right - left > onesInData) {
                onesInTheWindow -= data[left];
                left++;
            }
            maxOnesInTheWindow = Math.max(maxOnesInTheWindow, onesInTheWindow);
        }
        return onesInData - maxOnesInTheWindow;
    }
}