class Solution {
    public boolean isHappy(int n) {
        Set<Integer> uniqueNumberSet = new HashSet<Integer>();
        while(uniqueNumberSet.add(n)) {
            int value = 0;
            while(n > 0) {
                value += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = value;
        }
        return n == 1;
    }
}