class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        d = {}
        for num in nums:
            if not d.get(num):
                d[num] = True
            else:
                return True
        return False
        
        """ the "joke" version
          return len(nums) > len(set(nums))
        """
        
        """ using sort
        nums.sort()
        for i in range(0, len(nums)-1):
            if nums[i] == nums[i+1]:
                return True
        return False
        """
        """ using hashset
        numSet = set()
        for num in nums:
            if num in numSet:
                return True
            numSet.add(num)
        return False
        """