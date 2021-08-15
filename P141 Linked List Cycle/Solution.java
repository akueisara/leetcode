/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        return hasCycle2(head);
    }
    
    // Approach 1: Hash Table
    // Time: O(n)
    // Space: O(n)
    private boolean hasCycle1(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        
        while (head != null) {
            if (visitedNodes.contains(head)) {
                return true;
            }
            visitedNodes.add(head);
            head = head.next;
        }
        return false;
    }
    
    // Approach 2: Floyd's cycle-finding algorithm
    // https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_tortoise_and_hare
    // Time: O(n+m) => O(n), where n is the total number of nodes and m is the number of nodes in a cycle. n >= m
    // Space: O(1) -> only use two pointers
    private boolean hasCycle2(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }
}