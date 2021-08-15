# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        return self._hasCycle2(head)
    
    # Approach 1: Hash Table
    # Time: O(n)
    # Space: O(n)
    def _hasCycle1(self, head: ListNode) -> bool:
        visited_nodes = set()
        while head:
            if head in visited_nodes:
                return True
            visited_nodes.add(head)
            head = head.next
        return False
    
    # Approach 2: Floyd's cycle-finding algorithm
    # https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_tortoise_and_hare
    # Time: O(n+m) => O(n), where n is the total number of nodes and m is the number of nodes in a cycle. n >= m
    # Space: O(1) -> only use two pointers
    def _hasCycle2(self, head: ListNode) -> bool:
        tortoise = head
        hare = head
        while hare and hare.next:
            tortoise = tortoise.next
            hare = hare.next.next
            if tortoise == hare:
                return True
        return False   