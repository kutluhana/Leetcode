/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Queue<List<Integer>> queue = new LinkedList<>();
    List<Integer> answer = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        dfs(root, null);

        queue.add(List.of(target.val, 0));

        while(!queue.isEmpty()) {
            List<Integer> element = queue.remove();

            Integer value = element.get(0);
            Integer depth = element.get(1);

            seen.add(value);
            if(depth == k) {
                answer.add(value);
            } else if(depth < k) {
                for(Integer item : map.get(value)) {
                    if(!seen.contains(item)) {
                        queue.offer(List.of(item, depth + 1));
                    }
                }
            }
        }

        return answer;
    }



    void dfs(TreeNode node, TreeNode parent) {
        if(node == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();

        if(node.left != null) {
            list.add(node.left.val);
        }
        if(node.right != null) {
            list.add(node.right.val);
        }
        if(parent != null) {
            list.add(parent.val);
        }
        map.put(node.val, list);

        dfs(node.left, node);
        dfs(node.right, node);
    }
}