class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        return self.groupAnagrams2(strs)
        
    # Approach 1: Categorize by Sorted String
    # Time: O(N*K*logK), where N is the length of strs and K is the maximum length of a string in strs
    # Space: O(N*K) => a hash table to store N strings of length K
    def groupAnagrams1(self, strs: List[str]) -> List[List[str]]:
        groups = {}
        for s in strs:
            groups.setdefault(str(sorted(s)), []).append(s)
        return groups.values()
    
    
    # Approach 2: Categorize by Count
    # Time: O(N*K + N*26) = O(NK)
    # Space: O(N*K + N*26) = O(NK)
    def groupAnagrams2(self, strs: List[str]) -> List[List[str]]:
        groups = {}
        for s in strs:
            count = 26 * [0]
            for c in s:
                count[ord(c) - ord('a')] += 1 
            groups.setdefault(str(count), []).append(s)
        return groups.values()
