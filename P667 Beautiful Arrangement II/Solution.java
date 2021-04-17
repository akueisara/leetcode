class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] constructArray(int n, int k) {
        // if n = 6, k = 3
        // [1,2,3,6,4,5]
        // [1, ..., n-k-1], [n-k, ..., n] => [1, ..., 2], [3, ..., 6]
        // n-K-1 elements => [1, 2, ..., n - k - 1] => [1, 2]
        // distances are always 1: [1]
        // k+1 elements => [n-k + 0, n - 0, n-k + 1, n - 1, n-k + 2] => [3, 6, 4, 5]
        // distances are increasing by 1 starting from k: [k, k+1, k+2, k+3, ...]                       
        int[] result = new int[n];
        int i = 0;
        for (int j = 1; j < n-k; j++) {
            result[i] = j;
            i++;
        }
        for (int j = 0; j <= k; j++) {
            result[i] = (j%2 == 0) ? (n-k + j/2) : (n - j/2);
            i++;
        }
        return result;
    }
}