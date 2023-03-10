/*
 * @lc app=leetcode id=382 lang=java
 *
 * [382] Linked List Random Node
 */

// @lc code=start
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
    private ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    // Reservoir Sampling approach
    public int getRandom() {
        int count = 0;
        Random random = new Random();
        ListNode selected = head;
        ListNode curr = head;
        while (curr != null) {
            if (random.nextInt(count+1) == count) selected = curr;
            count++;
            curr = curr.next;
        }
        return selected.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

