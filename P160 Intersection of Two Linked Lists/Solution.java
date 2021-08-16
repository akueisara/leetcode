/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNode1(headA, headB);
    }
    
    // Approach 1: Hash Table
    // Time: O(n + m), where n is the length of linked list A and m is the length of B
    // Space: o(m)
    private ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> visitedNodes = new HashSet<>();
        while (headB != null) {
            visitedNodes.add(headB);
            headB = headB.next;
        }
        
        while (headA != null) {
            if (visitedNodes.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        
        return null;
    }
    
    // Approach 2: Two pointers
    // Time: O(n + m)
    // Space: o(1)
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // We need to know the length of each linked list
        // If one of the pointers reaches the end, just go back to the beginning and eventually both pointers will meet at the intersection node. 
        // If there's no intersection between two linked lists, two pointers will be the end (null) at the same time
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            // faster if switching the heads, when the pointers reach the end
            p1 = p1 == null ? headB : p1.next; 
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}