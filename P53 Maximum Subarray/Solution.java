class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane’s Algorithm
        // Time complexity: O(n)
        int result = Integer.MIN_VALUE, maxTemp = 0;
        for(int i = 0; i < nums.length; i++) {
            maxTemp += nums[i];
            if(result < maxTemp) {
                result = maxTemp;
            }
            if(maxTemp < 0) {
                maxTemp = 0;
            }
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        // divide and conquer
        // Time complexity: O(nlogn)
        return maxSubArraySum(nums, 0, nums.length-1);
    }

    public int maxSubArraySum(int nums[], int l, int h) {
        if (l == h) return nums[l];

        int m = (l + h)/2;

        // T(n) = 2T(n/2) + Θ(n)
        return Math.max(Math.max(maxSubArraySum(nums, l, m), maxSubArraySum(nums, m+1, h)),
                maxCrossingSum(nums, l, m, h));
    }

    public int maxCrossingSum(int nums[], int l, int m, int h) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = l; i <= m; i++) {
            sum = sum + nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }

}