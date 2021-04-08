# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Time: O(n), where n is the number of nodes in the tree
    # Space: O(1)
    def inorderSuccessor(self, root: 'TreeNode', p: 'TreeNode') -> 'TreeNode':
        # successor's value is always bigger than p.val
        successor = None
        while root:
            if root.val <= p.val:
                root = root.right
            else:
                successor = root
                root = root.left
        return successor
