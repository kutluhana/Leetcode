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
    public int deepestLeavesSum(TreeNode root) {

        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int answer = 0;

        List<TreeNode> currRow = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                currRow.add(queue.remove());
            }

            if(size == currRow.stream().filter(item -> item.left == null && item.right == null).count()) {
                for(TreeNode node : currRow) {
                    answer += node.val;
                }
            }

            for(TreeNode node : currRow) {
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            currRow = new ArrayList<>();
        }

        return answer;

    }
}