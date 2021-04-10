class Solution {
    // Time complexity : O(n), where n is the total number of characters in words
    // Space complexity : O(1), the size of the hash map is fixed as 26
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        for(char c: order.toCharArray()) {
            map.put(c, index);
            index++;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(j >= words[i + 1].length()) {
                    return false;
                }
                if(words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currentWordWeight = map.get(words[i].charAt(j));
                    int nextWordWeight = map.get(words[i+1].charAt(j));
                    if(currentWordWeight > nextWordWeight) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }
}