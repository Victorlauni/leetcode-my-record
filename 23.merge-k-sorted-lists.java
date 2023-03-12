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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;
        PriorityQueue<ListNode> minQueue = new PriorityQueue<>((a1, a2) -> Integer.compare(a1.val, a2.val));
        for (ListNode listHead: lists) {
            if (listHead == null) continue;
            minQueue.add(listHead);
        }
        while (!minQueue.isEmpty()) {
            ListNode min = minQueue.poll();
            ListNode newNode = new ListNode(min.val);
            if (min.next != null) minQueue.add(min.next);
            if (head == null) {
                head = newNode;
            } else {
                curr.next = newNode;
            }
            curr = newNode;
        }
        return head;

    }
}