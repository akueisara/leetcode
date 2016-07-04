# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if p==None and q==None:
            return True
        elif p != None and q != None:
            if p.val == q.val:
                return self.isSameTree(p.left, q.left) & self.isSameTree(q.right, p.right)
        else:
            return False
        
        return False