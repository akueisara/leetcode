/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Approach 1: Recursion
    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            ListNode mergedList;
            if (list1.val < list2.val) {
                mergedList = list1;
                mergedList.next = mergeTwoLists(list1.next, list2);
            } else {
                mergedList = list2;
                mergedList.next = mergeTwoLists(list1, list2.next);
            }
            return mergedList;
        }
    }

    // Approach 2: Iteration
    // Time complexity: O(n + m)
    // Space complexity: O(1)
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(-1);
        ListNode head = resultNode;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        head.next = (list1 != null) ? list1 : list2;
        ListNode temp = resultNode;
        resultNode = resultNode.next;
        return resultNode;
    }
}
