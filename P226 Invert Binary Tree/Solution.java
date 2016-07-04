/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
    /**
     * Iterative Version
     * 
     * if (root == null) return null;
     * Queue<TreeNode> queue = new LinkedList<TreeNode>();
     * queue.add(root);
     * while (!queue.isEmpty()) {
     *    TreeNode current = queue.poll();
     *    TreeNode temp = current.left;
     *    current.left = current.right;
     *    current.right = temp;
     *    if (current.left != null) queue.add(current.left);
     *    if (current.right != null) queue.add(current.right);
     * }
     * return root;
     */
}