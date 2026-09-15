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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        boolean isLeft = false, isRight = false;
        
        if(p == null && q == null) {
            return true;
        } else if((p != null && q == null) || (p == null && q != null)) {
            return false;
        } else if(p != null && q != null) {
            if(p.val != q.val) {
                return false;
            }

            isLeft = isSameTree(p.left, q.left);
            isRight = isSameTree(p.right, q.right);

        }

        return isLeft && isRight;
    }
}