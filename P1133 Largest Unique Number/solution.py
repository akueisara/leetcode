class Solution:
    # Time: O(nlogn) due to sorting, where n is the length of A
    # Can be improved to O(n) by using a hash map
    # Space: O(1)
    def largestUniqueNumber(self, A: List[int]) -> int:
        if len(A) == 1:
            return A[0]
        A.sort(reverse=True)
        anwser = A[0]
        count = 1
        for i in range(1, len(A)):
            if anwser == A[i]:
                count += 1
            else:
                if count == 1:
                    return anwser
                anwser = A[i]
                count = 1
        if count == 1:
            return anwser
        return -1
