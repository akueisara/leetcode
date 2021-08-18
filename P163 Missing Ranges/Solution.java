class Solution {
    // Time: 0(n)
    // Space: O(n)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        // All we care about are the ranges of numbers between the lower and upped bounds that do not exist in nums
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = upper + 1;
            if (i < nums.length) {
                curr = nums[i];
            }
            int start = prev + 1;
            int end = curr - 1;
            if (start <= end) {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
            }
            prev = curr;
        }
        return result;
    }
}