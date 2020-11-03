class Solution:
    
    def insert_word(self, root, word):
        current = root
        for c in word:
            current = current.children.setdefault(c, Node())
        current.word = word
        
    def initialize_trie(self, words):
        root = Node()
        for word in words:
            self.insert_word(root, word)
        return root   

    def longestWord(self, words: List[str]) -> str:
        root = self.initialize_trie(words)
        result = ""
        queue = collections.deque([root])
        while queue:
            node = queue.pop()
            if node.word or node == root:
                if node != root:
                    if len(node.word) > len(result) or len(node.word) == len(result) and node.word < result:
                        result = node.word
                queue.extend(node.children.values())
        return result

class Node:
    def __init__(self):
        self.children = {}
        self.word = None