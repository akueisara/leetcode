class Solution {
    // Time complexity : O(rowIndex). Each term is calculated once, in constant time.
    // Space complexity : O(rowIndex). No extra space required other than that required to hold the output.
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList();
        result.add(1);
        if(rowIndex == 0) {
            return result;
        }
        for(int i = 1; i < rowIndex; i++) {
            int element = (int) (result.get(i - 1) * (long) (rowIndex + 1 - i) / i);
            result.add(element);
        }
        result.add(1);
        return result;
    }
}