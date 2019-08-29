class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int n = nums.length;
         if (nums == null || n < 3) {
            return results;
        }

        Arrays.sort(nums);

         for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = n - 1;
            int target = -nums[i];

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> triple = new ArrayList<>(Arrays.asList(-target, nums[left], nums[right]));
                    results.add(triple);

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results;
    }
}
