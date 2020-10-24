class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
			return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (newInterval[1] >= intervals[i][0]) {
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
		    } else {                           
				newInterval = intervals[i];
                result.add(newInterval);
			} 
        }
        return result.toArray(new int[result.size()][]);
    }
}