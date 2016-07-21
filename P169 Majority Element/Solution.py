class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        nums.sort()
        majority = nums[0]
        count = 1
        for i in range(1,len(nums)):
            if (nums[i] == majority):
                count += 1
                if(count > len(nums)/2):
                    return nums[i]
            else:
                majority = nums[i]
                count = 1
        return 0