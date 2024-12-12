# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder: return None
        root = TreeNode(postorder[-1])
        inorder_root_index = inorder.index(root.val)
        inorder_left_subtree = inorder[:inorder_root_index]
        inorder_right_subtree = inorder[inorder_root_index + 1:]
        postorder_left_subtree = postorder[:len(inorder_left_subtree)]
        postorder_right_subtree = postorder[len(inorder_left_subtree):-1]
        root.left = self.buildTree(inorder_left_subtree, postorder_left_subtree)
        root.right = self.buildTree(inorder_right_subtree, postorder_right_subtree)
        return root