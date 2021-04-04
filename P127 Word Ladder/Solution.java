class Solution {
    // Bi-BFS
    // M is the length of each word and N is the length of the word list
    // Time: O(M^2*N)
    // Space: O(M*N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int length = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty() ) {
            if(beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for(String word: beginSet) {
                List<String> neighbors = getNeighbors(word);
                for(String neighbor: neighbors) {
                    if(endSet.contains(neighbor)) {
                        return length + 1;
                    }
                    if(words.contains(neighbor)) {
                        newBeginSet.add(neighbor);
                        words.remove(neighbor);
                    }
                }
            }
            beginSet = newBeginSet;
            length++;
        }
        return 0;
    }
    
    // BFS
    // M is the length of each word and N is the length of the word list
    // Time: O(M^2*N)
    // Space: O(M^2*N)
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) {
                    return step;
                }
                List<String> neighbors = getNeighbors(currentWord); 
                for(String neighbor: neighbors) {
                    if(words.contains(neighbor)) {
                        words.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }
    
    // Time: O(M^2)
    private List<String> getNeighbors(String word) {
        char[] chars = word.toCharArray();
        List<String> result = new ArrayList();
        for(int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String neighbor = new String(chars);
                result.add(neighbor);
            }
            chars[i] = temp;
        }
        return result;
    }
}