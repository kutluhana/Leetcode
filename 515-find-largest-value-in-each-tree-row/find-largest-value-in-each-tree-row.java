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
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> answer = new ArrayList<>();
        queue.offer(root);

        int currMax = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            int size = queue.size();

            currMax = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                currMax = Math.max(node.val, currMax);

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }


            answer.add(currMax);
        }

        return answer;
    }
}