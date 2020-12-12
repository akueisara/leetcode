class Solution {
    // Time complexity : O(numRows^2)
    // Space complexity : O(numRows^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (numRows == 0) {
            return result;
        }
        
        result.add(new ArrayList<>());
        result.get(0).add(1);
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> curr_list = new ArrayList();
            
            curr_list.add(1);
            
            
            for(int j = 1; j < i; j++) {
                // element = prev_element * (line - index) / index 
                int element = curr_list.get(j-1) * (i + 1 - j) / j;
                curr_list.add(element);
            }
            
            curr_list.add(1);
            
            result.add(curr_list);
        }
        
        return result;
    }
}