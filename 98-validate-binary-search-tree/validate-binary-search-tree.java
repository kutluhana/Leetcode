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
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        
        if(root == null) {
            return true;
        }
        
        boolean isLeftValid = isValidBST(root.left);

        if(!list.isEmpty() && list.getLast() >= root.val) {
            return false;
        }

        list.add(root.val);
        
        boolean isRightValid = isValidBST(root.right);

        return isLeftValid && isRightValid;
    }
}