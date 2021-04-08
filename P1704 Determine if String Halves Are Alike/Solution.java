class Solution {
    // Time: O(n), where n is the length of s
    // Space: O(1)
    public boolean halvesAreAlike(String s) {
        int firstHalfCount = 0;
        int secondHalfCount = 0;
        int strLength = s.length();
        String vowels = "aeiouAEIOU";
        for(int i = 0; i < strLength; i++) {
            if(vowels.indexOf(s.charAt(i)) != -1) {
                if(i < strLength/2) {
                    firstHalfCount++;
                } else {
                    secondHalfCount++;
                }
            }
        }
        return firstHalfCount == secondHalfCount;
    }
}