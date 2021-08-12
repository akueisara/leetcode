class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagrams2(strs);
    }
    
    // Approach 1: Categorize by Sorted String
    // Time: O(N*K*logK), where N is the length of strs and K is the maximum length of a string in strs
    // Space: O(N*K) => a hash table to store N strings of length K
    private List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        // O(N)
        for(String s: strs) {
            char[] chars = s.toCharArray();
            // O(K*logK)
            Arrays.sort(chars);
            
            // sorted chars as a key
            String key = String.valueOf(chars);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }
        
        // Convert a map to a list
        return new ArrayList<>(groups.values());
    }
    
    // Approach 2: Categorize by Count
    // Time: O(N*K + N*26) = O(NK)
    // Space: O(N*K + N*26) = O(NK)
    private List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        // O(N)
        for (String s: strs) {
            int[] count = new int[26];
            // O(K)
            for(char c: s.toCharArray()) {
                count[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            // O(26)
            for(int i = 0; i < 26; i++) {
                sb.append(count[i]);
                // aaaaaaaaaaab (11 1000...0) and abbbbbbbbbbb (1 11 000..0) are not anagrams, but their keys are the same.
                // add a delimiter to avoid this kind of case
                // 11/1/0... and 1/11/0...
                sb.append('/');
            }
            
            String key = sb.toString();
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}