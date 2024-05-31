/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // Level order traversal
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean reachLeaf = false;
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode currNode = queue.poll();
            if (reachLeaf && currNode.left == null && currNode.right == null) continue;
            else if (reachLeaf) {
                return false;
            } 
            if (currNode.left == null || currNode.right == null) {
                if (currNode.left == null && currNode.right != null) return false;
                reachLeaf = true;
            }
            if (currNode.left != null) queue.add(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
        }
        return true;
    }

    private boolean isNodeLeaf(TreeNode node) {
        if (node == null) return true;
        return node.left == null && node.right == null;
    }
}