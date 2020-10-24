class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] num_occurrence = new int[n+1];
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0 && nums[i] <= n) {
                num_occurrence[nums[i]] = 1;
            }
        }
        for(int i = 1; i < n + 1; i++) {
            if(num_occurrence[i] == 0) {
                return i;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int i = 1;
        while(true) {
            if(!contains(nums, i)) {
                return i;
            }
            i++;
        }
    }
    
    private Boolean contains(int[] nums, int num) {
        for(int i = 0; i< nums.length; i++) {
            if(num == nums[i]) {
                return true;
            }
        }
        return false;
    }
}