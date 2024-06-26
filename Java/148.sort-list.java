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
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head;
        boolean isSorted = true;
        while (tmp != null && tmp.next != null) {
            isSorted = isSorted && tmp.val < tmp.next.val;
            tmp = tmp.next;
        }
        if (isSorted) return head;
        ListNode pivot = head;
        ListNode pivotEnd = head;
        ListNode curr = head.next;
        pivot.next = null;
        ListNode smaller = null;
        ListNode larger = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;
            if (curr.val < pivot.val) {
                curr.next = smaller;
                smaller = curr;
            } else if (curr.val > pivot.val) {
                curr.next = larger;
                larger = curr;
            } else {
                curr.next = pivot;
                pivot = curr;
            }
            curr = next;
        }
        
        smaller = sortList(smaller);
        larger = sortList(larger);
        ListNode root = smaller;
        pivotEnd.next = larger;
        if (smaller == null) return pivot;
        while (smaller != null && smaller.next != null) {
            smaller = smaller.next;
        }
        smaller.next = pivot;
        return root;
    }
}