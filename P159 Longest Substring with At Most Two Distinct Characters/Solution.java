class Solution {
    // Approach: Sliding Window
    // Time: O(n)
    // Space: O(1)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0, maxLen = 0;
        // A map containing at most "2" characters as keys and their latest potions as values
        Map<Character, Integer> map = new HashMap<>();
        // O(n)
        while (right < s.length()) {
            map.put(s.charAt(right), right);
            if (map.size() == 3) {
                // map size is always smaller than 3, so we don't need to consider the time complexity of Collections.min
                int leftMostIndex = Collections.min(map.values());
                map.remove(s.charAt(leftMostIndex));
                left = leftMostIndex + 1;
            }
            maxLen = Math.max(maxLen, right - left +1);
            right ++;
        }
        return maxLen;
    }
}