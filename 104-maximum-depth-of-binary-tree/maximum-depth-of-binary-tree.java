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

    public int maxDepth(TreeNode root) {
        
        Stack<Map.Entry<TreeNode,Integer>> stack = new Stack<>();

        int maxDepth = Integer.MIN_VALUE;
        if(root == null) {
            return 0;
        }
        stack.add(Map.entry(root, 1));

        while(!stack.empty()) {
            Map.Entry<TreeNode,Integer> entry = stack.pop();

            if(entry.getKey().left != null) {
                stack.push(Map.entry(entry.getKey().left, entry.getValue() + 1));
            }
            if(entry.getKey().right != null) {
                stack.push(Map.entry(entry.getKey().right, entry.getValue() + 1));
            }

            maxDepth = Math.max(maxDepth, entry.getValue());


        }

        return maxDepth;
    }
}