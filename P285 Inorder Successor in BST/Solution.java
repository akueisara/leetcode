/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Time: O(n), where n is the number of nodes in the tree
    // Space: O(1)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // successor's value is always bigger than p.val
         TreeNode successor = null;
         while (root != null) {
             if (root.val <= p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
         }
        return successor;
    }
}