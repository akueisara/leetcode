public class Solution {
    public int singleNumber(int[] nums) {
       // bit manipulation
       int result = 0;
       for (int i = 0; i<nums.length; i++) {
            result ^=nums[i]; 
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int number = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(i % 2 == 1) {
                if(number != nums[i]) {
                    return number;
                } 
            } else {
                number = nums[i];
            }
        }
        return nums[nums.length-1]; 
    }

    public int singleNumber2(int[] nums) {
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
}