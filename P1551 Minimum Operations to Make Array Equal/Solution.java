class Solution {
    // [1*] 1/2 => 0
    // [1*, 3] 2/2 => 1
    // [1*, 3, 5] 3/2 => 2
    // [1*, 3*, 5, 7] 4/2 => (4-1) + (4-3)
    // [1*, 3*, 5, 7, 9] 5/2 => (5-1) + (5-3)
    // [1*, 3*, 5*, 7, 9, 11] 6/2 => (6-1) + (6-3) + (6-5) 
    // [1*, 3*, 5*, 7, 9, 11, 13] 7/2 = 3
    // Time: O(logn)
    // Space: O(1)
    public int minOperations2(int n) {
        int endIndex = n / 2;
        int result = 0;
        for(int i = 0; i < endIndex; i++) {
            result += n - ((2 * i) + 1);
        }
        return result;
    }
    
    // [1*, 3*, 5*, 7*, 9, 11, 13, 15] 8/2 => (8-1) + (8-3) + (8-5) + (8-7) = 4 * 4 => n/2 * n/2
    // [1*, 3*, 5*, 7*, *9, 11, 13, 15, 17] 9/2 => (9-1) + (9-3) + (9-5) + (9-7) = 4 * 4 + 4 => n/2 * n/2 + n/2
    // Time: O(1)
    // Space: O(1)
    public int minOperations(int n) {
        int halfEndIndex = n / 2;
        return halfEndIndex * halfEndIndex + n % 2 * halfEndIndex;
    }
}