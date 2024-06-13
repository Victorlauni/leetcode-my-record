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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0 || head == null) return head;
        ListNode last = head;
        ListNode prev = null;
        int count = 0;
        for (ListNode i = head; count < k; i = i.next) {
            if (i == null) return head;
            count++;
        }
        while (count > 0) {
            ListNode tmp = prev;
            prev = head;
            head = head.next;
            prev.next = tmp;
            count--;
        }
        last.next = reverseKGroup(head, k);
        return prev;
    }
}