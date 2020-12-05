class Solution {
    public int totalFruit(int[] tree) {
        Set<Integer> types = new HashSet();
        int maxCount = 0, tempCount = 0, i = 0, j = 0;
        while(i < tree.length) {
            int n = tree[i];
            types.add(n);
            if(types.size() == 3) {
                if(maxCount < tempCount) {
                    maxCount = tempCount;
                }
                tempCount = 0;
                j = i;
                types.clear();
                while(types.size() < 2) {
                    j-=1;
                    types.add(tree[j]);
                }
                i = j+1;
                types.clear();
                continue;
            } else {
                tempCount++;
            }
            i++;
        }
        if(maxCount < tempCount) {
            maxCount = tempCount;
        }
        return maxCount;
    }
}