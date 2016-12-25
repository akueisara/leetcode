public class Solution {
    public int hammingDistance(int x, int y) {
        int dist = 0;
        int val = x ^ y;

        // Count the number of bits set
        while (val != 0) {
            // A bit is set, so increment the count and clear the bit
            dist++;
            val &= val - 1;
        }

        // Return the number of differing bits
        return dist;
    }
}