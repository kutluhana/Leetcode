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
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val, 0);
    }

    public int maxAncestorDiff(TreeNode root, Integer max, Integer min, Integer maxDiff) {

        if(root == null) {
            return maxDiff;
        }

        int left = maxAncestorDiff(root.left, 
        Math.max(max, root.val), 
        Math.min(min, root.val), 
        Math.max(maxDiff, Math.max(Math.abs(max - root.val), Math.abs(root.val - min)))
        );

        int right = maxAncestorDiff(root.right, 
        Math.max(max, root.val), 
        Math.min(min, root.val), 
        Math.max(maxDiff, Math.max(Math.abs(max - root.val), Math.abs(root.val - min)))
        );

        return Math.max(right, left);

    }
}