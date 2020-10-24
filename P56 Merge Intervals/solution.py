class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1:
            return intervals
        intervals = sorted(intervals,key=lambda l:l[0])
        newInterval = intervals[0]
        result = [newInterval]
        for i in range(1, len(intervals)):
            if newInterval[1] >= intervals[i][0]:
                newInterval[1] = max(newInterval[1], intervals[i][1])
            else:
                newInterval = intervals[i]
                result.append(newInterval)
        return result