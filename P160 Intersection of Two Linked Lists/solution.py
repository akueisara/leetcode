# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        return self._getIntersectionNode2(headA, headB)
    
    # Approach 1: Hash Table
    # Time: O(n + m), where n is the length of linked list A and m is the length of B
    # Space: o(m)
    def _getIntersectionNode1(self, headA: ListNode, headB: ListNode) -> ListNode:
        visited_nodes = set()
        while headB:
            visited_nodes.add(headB)
            headB = headB.next
            
        while headA:
            if headA in visited_nodes:
                return headA
            headA = headA.next
        return None
    
    # Approach 2: Two pointers
    # Time: O(n + m)
    # Space: o(1)
    def _getIntersectionNode2(self, headA: ListNode, headB: ListNode) -> ListNode:
        p1, p2 = headA, headB
        while p1 != p2:
            p1 = p1.next if p1 else headB
            p2 = p2.next if p2 else headA
        return p1