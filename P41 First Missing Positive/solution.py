class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        num_occurrence = [0] * (n + 1)
        for i in range(n):
            if nums[i] > 0 and nums[i] <= n:
                num_occurrence[nums[i]] = 1
        for i in range(1, n + 1):
            if num_occurrence[i] == 0:
                return i
        return n + 1
    
    def firstMissingPositive2(self, nums: List[int]) -> int:
        i = 1
        while True:
            if i not in nums:
                return i
            i+=1
        return i