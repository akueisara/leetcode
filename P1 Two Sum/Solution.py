class Solution(object):
    # Time complexity : O(n), where n is the length of nums
    # Space complexity : O(n)
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for i in range(len(nums)):
            if target - nums[i] in dict:
                return [dict[target - nums[i]], i]
            dict[nums[i]] = i
        raise Exception("No two sum solution")
