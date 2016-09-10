public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-1) {
            if(nums[i] == nums[i+1])
                i = i+2;
            else
                return nums[i];
        }
        return nums[i];
    }
    /* bit manipulation
       int result = 0;
       for (int i = 0; i<nums.length; i++) {
            result ^=nums[i]; 
        }
        return result;
    */
}