class Solution {
    // Time: O(nlogn) due to sorting, where n is the length of A
    // Can be improved to O(n) by using a hash map
    // Space: O(1)
    public int largestUniqueNumber(int[] A) {
        if(A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        int anwser = A[A.length - 1];
        int count = 1;
        for(int i = A.length - 2; i >=0; i--) {               
            
            if(anwser == A[i]) {
                count++;
            } else {
                if(count == 1) {
                    return anwser;
                }
                anwser = A[i];
                count = 1;
            }
        }
        if(count == 1) {
            return anwser;
        }
        return -1;
    }
}