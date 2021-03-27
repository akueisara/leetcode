class Solution {
    public int numWays(String s) {
        int modNum = 1000000007;
        int numOfOnes = countOnes(s);
        if (numOfOnes % 3 != 0) {
            return 0;
        } else if(numOfOnes == 0) {
            return (int) ((s.length() - 1L) * (s.length() - 2L) / 2 % modNum);
        } else {
            int onesInEachPart =  numOfOnes / 3;
            long waysBeforeFirstCut = 0, waysBetweenFirstAndSecondCut = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
                if (count == onesInEachPart) { 
                    waysBeforeFirstCut++;
                } else if (count == onesInEachPart * 2) {
                    waysBetweenFirstAndSecondCut++;
                }
            }
            return (int) (waysBeforeFirstCut * waysBetweenFirstAndSecondCut % modNum);
        }
    }
    
    private static int countOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}