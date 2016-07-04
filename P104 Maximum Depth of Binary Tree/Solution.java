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
    public int maxDepth(TreeNode root) {
         if(root == null)    
             return 0;
             
         // Non-recursive, use level order triversal
         ArrayList<TreeNode> q = new ArrayList<TreeNode>();
         q.add(root);
         int depth = 0;
         
         while(!q.isEmpty()) {
             ArrayList<TreeNode> next = new ArrayList<TreeNode>();
             for(TreeNode node : q) {
                 if(node.left != null)   next.add(node.left);
                 if(node.right != null)  next.add(node.right);
             }
             q = new ArrayList<TreeNode>(next);
             depth++;
         }
         
         return depth;
    }
}