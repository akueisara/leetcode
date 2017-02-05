# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)
        curr = head
        carry = 0
        while l1 or l2:
            sum =  carry + (l1 and l1.val or 0) + (l2 and l2.val or 0)
            carry = sum / 10
            curr.next = ListNode(sum % 10)
            curr = curr.next
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
                
        if carry > 0:
            curr.next = ListNode(carry)
            
        return head.next