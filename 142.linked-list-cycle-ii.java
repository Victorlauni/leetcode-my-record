/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
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
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slowPointer = head.next;
        ListNode fastPointer = head.next == null? null:head.next.next;
        if (slowPointer == null || fastPointer == null) return null;
        while (slowPointer != fastPointer) {
            if (slowPointer == null || fastPointer == null) return null;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next == null ? null : fastPointer.next.next;
        }
        slowPointer = head;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}
// @lc code=end

