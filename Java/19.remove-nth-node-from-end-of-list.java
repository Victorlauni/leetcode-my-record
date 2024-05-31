/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode endNode = head;
        ListNode preNode = head;
        if (endNode.next == null) return null;
        for (int i = 0; i < n; i++) {
            endNode = endNode.next;
        }
        if (endNode == null) {
            return preNode.next;
        }
        else  {
            endNode = endNode.next;
            while (endNode != null) {
                endNode = endNode.next;
                preNode = preNode.next;
            }
            preNode.next = preNode.next.next;
        }
        return head;
    }
}