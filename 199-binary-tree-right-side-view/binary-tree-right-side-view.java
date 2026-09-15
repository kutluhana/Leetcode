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
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> answer = new ArrayList<>();

        queue.offer(root);

        if(root == null) {
            return answer;
        }
        
        while(!queue.isEmpty()) {

            int sizeOfQueue = queue.size();

            answer.add(queue.peek().val);

            for(int i = 0; i < sizeOfQueue; i++) {
                TreeNode node = queue.remove();

                if(node.right != null) {
                    queue.offer(node.right);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return answer;
    }
}