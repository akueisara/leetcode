/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    // Approach 1: Recursion
    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val mergedList: ListNode?
        when {
            list1 == null -> mergedList = list2
            list2 == null -> mergedList = list1
            else -> {
                if (list1.`val` < list2.`val`) {
                    mergedList = list1
                    mergedList.next = mergeTwoLists(list1.next, list2)
                } else {
                    mergedList = list2
                    mergedList.next = mergeTwoLists(list1, list2.next)
                }
            }
        }
        return mergedList
    }

    // Approach 2: Iteration
    // Time complexity: O(n + m)
    // Space complexity: O(1)
    fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
        val head = ListNode(-1)
        var tail: ListNode? = head
        var mutableList1 = list1
        var mutableList2 = list2
        while(mutableList1 != null && mutableList2 != null) {
            if (mutableList1.`val` < mutableList2.`val`) {
                tail?.next = mutableList1
                mutableList1 = mutableList1.next
            } else {
                tail?.next = mutableList2
                mutableList2 = mutableList2.next
            }
            tail = tail?.next
        }

        tail?.next = mutableList1 ?: mutableList2
        return head.next
    }
}