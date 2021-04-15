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
    // O(n), where n is the total number of nodes
    // O(l), where l is a tree height
    public int deepestLeavesSum2(TreeNode root) {
        int deepestSum = 0, maxLevel = 0, currentLevel = 0;
        // stack (pop) -> ArrayDeque (DFS)
        // pop out from the right, first push the right child, and then the left one.
        // alternative: queue (poll) -> ArrayDeque (BFS)
        // pop out from the right, first push the right child, and then the left one.
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));
        
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currentLevel = p.getValue();
            
            if (root.left == null && root.right == null) {
                if (maxLevel < currentLevel) {
                    deepestSum = root.val;
                    maxLevel = currentLevel;
                } else if (maxLevel == currentLevel) {
                    deepestSum += root.val;
                }
            } else {
                if (root.right != null) {
                    stack.push(new Pair(root.right, currentLevel + 1));
                }
                if (root.left != null) {
                    stack.push(new Pair(root.left, currentLevel + 1));
                }
            }
        }
        return deepestSum;
    }
    
    private int maxLevel = 0;
    
    // Time: O(n)
    // Space: O(n)
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, root.val);
        calculateDeepestSumAt(root.left, 1, map);
        calculateDeepestSumAt(root.right, 1, map);
        return map.get(maxLevel);
    }
    
    private void calculateDeepestSumAt(TreeNode root, int level, Map<Integer, Integer> map) {
        if(root == null) {
            return;
        }
        if(level > maxLevel){
            maxLevel = level;
        }
        map.put(level, map.getOrDefault(level, 0) + root.val);
        calculateDeepestSumAt(root.left, level + 1, map);
        calculateDeepestSumAt(root.right, level + 1, map);
    }
}