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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null) {

            return new TreeNode(val);
        }

        TreeNode answer = null;

        if(root.val > val) {
            if(root.left == null) {
                answer = new TreeNode(val);
                root.left = answer;
            } else {
                answer = insertIntoBST(root.left, val);
            }
        } else if(root.val < val) {
            if(root.right == null) {
                answer = new TreeNode(val);
                root.right = answer;
            } else {
                answer = insertIntoBST(root.right, val);
            }
        }

        return root;
    }
}