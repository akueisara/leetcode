class Solution:
    # Time Complexity: O(n), where n is the length of A
    # Space Complexity: O(1)
    def isIdealPermutation(self, A: List[int]) -> bool:
        # If true, 0 only can be at index 0 or 1
        # Hence the possibilities are either: 
        # (1) 0, ideal permutaion of 1...N-1
        # (2) 1, 0, ideal permutation of 2...N-1
        for i in range(len(A)):
            # The absolute distance between A[i] and i can not be larger than 1, otherwises, global > local
            if abs(A[i] - i) > 1:
                return False  
        return True
