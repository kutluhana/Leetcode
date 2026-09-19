class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 1) {
            return true;
        }
        
        for(int i = 0; i < edges.length; i++) {
            List<Integer> list1 = map.getOrDefault(edges[i][0], new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(edges[i][1], new ArrayList<>());

            list1.add(edges[i][1]);
            list1.add(edges[i][0]);
            list2.add(edges[i][0]);
            list2.add(edges[i][1]);

            map.put(edges[i][0], list1);
            map.put(edges[i][1], list2);
        }

        dfs(source);

        return set.contains(destination);
    }

    void dfs(int source) {
        if(set.contains(source)) {
            return;
        }

        set.add(source);

        for(Integer neighbor : map.get(source)) {
            dfs(neighbor);
        }
    }
}