# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum2(self, root: TreeNode) -> int:
        # stack (pop)
        # pop out from the right, first push the right child, and then the left one.
        # alternative: queue (poll)
        # pop out from the right, first push the right child, and then the left one.
        deepest_sum = max_level = current_level = 0
        stack = [(root, 0)]
        
        while stack:
            root, current_level = stack.pop()
            if root.left is None and root.right is None:
                if max_level < current_level:
                    deepest_sum = root.val
                    max_level = current_level
                elif max_level == current_level:
                    deepest_sum += root.val
            else:
                if root.right is not None:
                    stack.append((root.right, current_level + 1))
                if root.left is not None:
                    stack.append((root.left, current_level + 1))
                    
        return deepest_sum
    
    # Time: O(n)
    # Space: O(n)
    def deepestLeavesSum(self, root: TreeNode) -> int:
        return self.recursive_deepest_leaves_sum(root, 0, [])
    
    def recursive_deepest_leaves_sum(self, root, level, sum_array):
        if not root:
            return
        if len(sum_array) == level:
            sum_array.append(root.val)
        else:
            sum_array[level] = sum_array[level] + root.val
        self.recursive_deepest_leaves_sum(root.left, level + 1, sum_array)
        self.recursive_deepest_leaves_sum(root.right, level + 1, sum_array)
        return sum_array[-1]
