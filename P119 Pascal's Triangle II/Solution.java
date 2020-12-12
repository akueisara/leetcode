class Solution {
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