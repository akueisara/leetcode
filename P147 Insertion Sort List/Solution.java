/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // https://en.wikipedia.org/wiki/Insertion_sort
    // If's often to preform this algo using an Array, here we use a linked list
    // Insertion Sort Algo is fast for sorting a "small" array, even faster than quicksort
    // Time: O(n^2)
    // Space: O(1)
    public ListNode insertionSortList(ListNode head) {
        // node -> null | 4 (head) -> 2 -> 1 -> 3 -> null
        ListNode sortedHead = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            // prev points to the `sortedHead`
            ListNode prev = sortedHead;
            
            // find the position to insert the current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            ListNode nextNode = curr.next;
            // insert the current node to the new linked list where the head is `sortedHead`
            curr.next = prev.next;
            prev.next = curr;
            
            // move to the next node
            curr = nextNode;
        }
        
        return sortedHead.next;
    }

    private int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j = j - 1;
            }
            nums[j] = tmp;
        }
        return nums;
    }
}