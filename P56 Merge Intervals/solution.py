class Solution:
    # Time: o(nlogn)
    # Space: O(n)
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1:
            return intervals
        intervals = sorted(intervals,key=lambda l:l[0])
        newInterval = intervals[0]
        result = [newInterval]
        for interval in intervals:
            if newInterval[1] >= interval[0]:
                newInterval[1] = max(newInterval[1], interval[1])
            else:
                newInterval = interval
                result.append(newInterval)
        return result