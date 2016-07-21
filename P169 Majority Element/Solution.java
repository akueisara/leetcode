public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        int majority = nums[0];
        int count=1;
        for(int i=1; i<nums.length; i++){
            if (nums[i] == majority) {
                count++;
                if(count > nums.length/2) return nums[i];
            }
            else {
                majority = nums[i];
                count = 1;
            }
        }
        return 0;
    }
}