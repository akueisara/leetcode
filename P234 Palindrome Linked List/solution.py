# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # Time: O(n), where n is the number of nodes of the Linked List.
    # Space: O(1)
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        
        fast = head
        slow = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        first_half_start = head
        second_half_start = self.reverse_linked_List(slow.next)
        while second_half_start:
            if first_half_start.val != second_half_start.val:
                return False
            first_half_start = first_half_start.next
            second_half_start = second_half_start.next
        return True

    def reverse_linked_List(self, head: ListNode) -> ListNode:
        prev = None
        curr = head
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        return prev
