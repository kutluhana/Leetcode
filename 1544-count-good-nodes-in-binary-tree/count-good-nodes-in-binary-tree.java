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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, Integer currMax) {
        
        if(root == null) {
            return 0;
        }

        int leftCount = goodNodes(root.left, Math.max(currMax, root.val));
        int rightCount = goodNodes(root.right, Math.max(currMax, root.val));

        return root.val >= currMax ? leftCount + rightCount + 1 : leftCount + rightCount;
    }
}