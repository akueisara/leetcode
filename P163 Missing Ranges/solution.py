class Solution:
    # Time: O(n)
    # Space: O(n)
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        result = []
        prev = lower - 1
        for i in range(0, len(nums) + 1):
            curr = nums[i] if i < len(nums) else upper + 1
            start = prev + 1
            end = curr - 1
            if start <= end:
                if start == end:
                    result.append(str(start))
                else:
                    result.append(str(start) + "->" + str(end))
            prev = curr
        return result