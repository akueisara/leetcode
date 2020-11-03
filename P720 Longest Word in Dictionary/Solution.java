class Solution {

    public String longestWord(String[] words) {
        Node root = initializeTrie(words);
        String result = "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(!node.word.isEmpty() || node == root) {
                if(node != root) {
                    if(node.word.length() > result.length() || node.word.length() == result.length() && node.word.compareTo(result) < 0) {
                        result = node.word;
                    }
                }
                queue.addAll(node.children.values());
            }
        }
        return result;
    }
    
    private Node initializeTrie(String[] words) {
        Node root = new Node();
        for(String word: words) {
            insertWord(root, word);
        }
        return root;
    }
    
    private void insertWord(Node root, String word) {
        Node current = root;
        for(Character c: word.toCharArray()) {
            if(current.children.get(c) == null) {
                current.children.put(c, new Node());
            }
            current = current.children.get(c);
        }
        current.word = word;
    }
    
    public String longestWord2(String[] words) {
        Arrays.sort(words, Collections.reverseOrder());
        List<String> wordList = Arrays.asList(words);
        List<String> result = new ArrayList<>();
        for(String word: words) {
            boolean anwser = true;
            for(int i = 1; i < word.length(); i++) {
                if(!wordList.contains(word.substring(0, i))) {
                    anwser = false;
                }
            }
            if(anwser) {
                result.add(word);
            }
        }
        if(result.size() == 0) {
            return "";
        } else {
            int maxLength = 0;
            String longestWord = "";
            Collections.sort(result);
            for(String word: result) {
                if(word.length() > maxLength) {
                    maxLength = word.length();
                    longestWord = word;
                }
            }
            return longestWord;
        }
    }
}

class Node {
    Map<Character, Node> children;
    String word;

    Node() {
        this.children = new HashMap<>();
        this.word = "";
    }
}