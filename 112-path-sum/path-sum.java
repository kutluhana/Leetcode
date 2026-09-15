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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        boolean isRightTrue = false;
        boolean isLeftTrue = false;

        if(root == null) {
            return false;
        }
        
        if(root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        } else if(root.left == null && root.right == null) {
            return false;
        } else if(root.left == null) {
            isLeftTrue = hasPathSum(root.right, targetSum - root.val);
        } else if(root.right == null) {
            isRightTrue = hasPathSum(root.left, targetSum - root.val);
        } else if(root.left != null && root.right != null) {
            isLeftTrue = hasPathSum(root.left, targetSum - root.val);
            isRightTrue = hasPathSum(root.right, targetSum - root.val);
        }

        return isLeftTrue || isRightTrue;


    }
}