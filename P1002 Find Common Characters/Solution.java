class Solution {
    // Time: O(n), where n is the total number of characters in A
    // Space: O(1)
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        for(int i = 0; i < 26; i++) {
            count[i] = 100;
        }
        for(String s: A) {
            int[] indivialCount = new int[26]; 
            for(char c: s.toCharArray()) {
                indivialCount[c - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                count[i] = Math.min(indivialCount[i], count[i]);
            }
        }
        
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < count[i]; j++) {
                result.add(Character.toString((char) i + 'a'));
            }
        }
        
        return result;
    }
}