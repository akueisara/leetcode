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
    public boolean isValidBST(TreeNode root) {
        return isValidBST2(root);
    }
    
    // Approach 1: Top-Down DFS
    // Time: O(n)
    // Space: O(n)
    private boolean isValidBST1(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if ((low != null && root.val <= low) || 
            (high != null && root.val >= high)
           ) {
            return false;
        }
        return validate(root.left, low, root.val) && 
            validate(root.right, root.val, high);
    }
    
    // Approach 2: Inorder Traversal
    // Time: O(n)
    // Space: O(n)
    private Integer prev;
    private boolean isValidBST2(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}