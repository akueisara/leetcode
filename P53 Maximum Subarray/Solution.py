class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Kadane’s Algorithm
        # Time complexity: O(n)
        result = -sys.maxint -1
        maxTemp = 0
        for num in nums:
            maxTemp += num
            if result < maxTemp:
                result = maxTemp
            if maxTemp < 0:
                maxTemp = 0
        return result

    def maxSubArray2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # divide and conquer
        # Time complexity: O(nlogn)
        return self.maxSubArraySum(nums, 0, len(nums)-1)

    def maxSubArraySum(self, nums, l, h):
        if l == h:
            return nums[l]

        m = (l+ h) // 2

        return max(self.maxSubArraySum(nums, l, m), self.maxSubArraySum(nums, m+1, h), self.maxCrossingSum(nums, l, m, h))

    def maxCrossingSum(self, nums, l, m, h):
        sum = 0
        left_sum = -sys.maxint -1
        for i in range(m, l-1, -1):
            sum += nums[i]
            if sum > left_sum:
                left_sum = sum

        sum = 0
        right_sum = -sys.maxint -1
        for i in range(m+1, h+1):
            sum += nums[i]
            if sum > right_sum:
                right_sum = sum

        return left_sum + right_sum