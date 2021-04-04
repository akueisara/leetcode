class Solution:
    # Bi-BFS
    # M is the length of each word and N is the length of the word list
    # Time: O(M^2*N)
    # Space: O(M*N)
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        words = set(wordList)
        if endWord not in words:
            return 0
        begin_set = set([beginWord])
        end_set = set([endWord])
        length = 1
        while len(begin_set) != 0 and len(end_set) != 0:
            if len(begin_set) > len(end_set):
                begin_set, end_set = end_set, begin_set
            new_begin_set = set()
            for word in begin_set:
                neighbors = self._get_neighbors(word)
                for neighbor in neighbors:
                    if neighbor in end_set:
                        return length + 1
                    if neighbor in words:
                        new_begin_set.add(neighbor)
                        words.remove(neighbor)
            begin_set = new_begin_set
            length += 1
        return 0
    
    # BFS
    # M is the length of each word and N is the length of the word list
    # Time: O(M^2*N)
    # Space: O(M^2*N)
    def ladderLength2(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        queue = [beginWord]
        words = set(wordList)
        if beginWord in words:
            words.remove(beginWord)
        step = 0
        while len(queue) != 0:
            size = len(queue)
            step += 1
            for i in range(size):
                current_word = queue.pop(0)
                if current_word == endWord:
                    return step
                neighbors = self._get_neighbors(current_word)
                for neighbor in neighbors:
                    if neighbor in words:
                        words.remove(neighbor)
                        queue.append(neighbor)
                        
        return 0
    
    # Time: O(M^2)
    def _get_neighbors(self, word: str) -> List[str]:
        result = []
        for i in range(len(word)):
            for n in range(ord('a'), ord('z') + 1):
                result.append(word[:i] + chr(n) + word[i+1:])
        return result
