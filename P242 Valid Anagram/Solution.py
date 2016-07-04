class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) == 0 and len(t) == 0: 
            return True
        elif len(s) != 0 and len(t) != 0:
            if len(s) == len(t):
                HashTable_s = {}
                for i in s:
                    if i in HashTable_s: HashTable_s[i] += 1
                    else: HashTable_s[i] = 1 
                HashTable_t = {}
                for i in t:
                    if i in HashTable_t: HashTable_t[i] += 1
                    else: HashTable_t[i] = 1 
                return HashTable_t==HashTable_s
        return False
        