class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var maxTemp = 0
        for(i in 0..nums.size-1) {
            maxTemp += nums[i]
            if(result < maxTemp) {
                result = maxTemp
            }
            if(maxTemp < 0) {
                maxTemp = 0
            }
        }
        return result
    }
}