class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    int answer = 0;
    public int countComponents(int n, int[][] edges) {
        
        for(int i = 0; i < edges.length; i++) {
            List<Integer> list1 = map.getOrDefault(edges[i][0], new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(edges[i][1], new ArrayList<>());

            list1.add(edges[i][0]);
            list1.add(edges[i][1]);

            list2.add(edges[i][0]);
            list2.add(edges[i][1]);

            map.put(edges[i][0], list1);
            map.put(edges[i][1], list2);
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(!set.contains(entry.getKey())) {
                answer++;
                dfs(entry.getKey());
            }
        }

        return answer + n - set.size();
    }

    void dfs(Integer node) {
        if(set.contains(node)) {
            return;
        }

        set.add(node);

        for(Integer connected : map.get(node)) {
            dfs(connected);
        }
    }
}