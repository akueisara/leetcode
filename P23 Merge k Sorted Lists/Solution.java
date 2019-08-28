// For other solutions: https://www.jiuzhang.com/solution/merge-k-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<Integer>();
        for(ListNode l: lists) {
            while(l != null) {
                list.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(list);
        ListNode headNode = new ListNode(0);
        ListNode head = headNode;
        for(int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            headNode.next = node;
            headNode = headNode.next;
        }
        return head.next;
    }
}
