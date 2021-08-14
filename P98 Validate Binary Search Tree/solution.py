# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self._isValidBST2(root)
        
    # Approach 1: Top-Down DFS
    # Time: O(n)
    # Space: O(n)    
    def _isValidBST1(self, root: Optional[TreeNode]) -> bool:
        return self._validate(root, None, None)
    
    def _validate(self, root: Optional[TreeNode], low: Optional[int], high: Optional[int]) -> bool:
        if root == None:
            return True
        if (low != None and root.val <= low) or (high != None and root.val >= high):
            return False
        return self._validate(root.left, low, root.val) and self._validate(root.right, root.val, high)
    
    # Approach 2: Inorder Traversal
    # Time: O(n)
    # Space: O(n)
    prev = None
    def _isValidBST2(self, root: Optional[TreeNode]) -> bool:
        return self._inorder(root)
    
    def _inorder(self, root: Optional[TreeNode]) -> bool:
            if root == None:
                return True
            if not self._inorder(root.left):
               return False
            if self.prev != None and root.val <= self.prev:
                return False
            self.prev = root.val
            return self._inorder(root.right)