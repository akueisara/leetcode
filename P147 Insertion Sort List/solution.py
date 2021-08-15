# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # https://en.wikipedia.org/wiki/Insertion_sort
    # If's often to preform this algo using an Array, here we use a linked list
    # Insertion Sort Algo is fast for sorting a "small" array, even faster than quicksort
    # Time: O(n^2)
    # Space: O(1)
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        sorted_head = ListNode()
        curr = head
        while curr:
            prev = sorted_head
            
            while prev.next and prev.next.val < curr.val:
                prev = prev.next
                
            next_node = curr.next
            curr.next = prev.next
            prev.next = curr
            
            curr = next_node
        return sorted_head.next
    
    def _insertionSort(self, nums: List[int]) -> List[int]:
        for i in range(0, len(nums)):
            tmp = nums[i]
            
            j = i
            while j > 0 and nums[j - 1] > tmp:
                nums[j] = nums[j - 1]
                j = j - 1
            nums[j] = tmp
        return nums