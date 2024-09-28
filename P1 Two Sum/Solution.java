public class Solution {
    // Time complexity : O(n), where n is the length of nums
    // Space complexity : O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNumMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(visitedNumMap.containsKey(diff)) {
                return new int[] {visitedNumMap.get(diff), i};
            }
            visitedNumMap.put(nums[i], i);
        }
        return new int[0];
    }
}