class Solution {
    Set<String> roads = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();;
    Set<Integer> seen = new HashSet<>();
    public int minReorder(int n, int[][] connections) {

        for(int i = 0; i < connections.length; i++) {
            for(int j = 0; j < 2; j++) {

                if(map.containsKey(connections[i][0])) {
                    map.get(connections[i][0]).add(connections[i][j]);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(connections[i][j]);
                    map.put(connections[i][0], list);
                }

                if(map.containsKey(connections[i][1])) {
                    map.get(connections[i][1]).add(connections[i][j]);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(connections[i][j]);
                    map.put(connections[i][1], list);
                }

                roads.add(convertToHash(connections[i][0], connections[i][1]));
            }
        }

        seen.add(0);
        return dfs(0);
        
    }

    public int dfs(int node) {
        int ans = 0;
        for (int neighbor: map.get(node)) {
            if (!seen.contains(neighbor)) {
                if (roads.contains(convertToHash(node, neighbor))) {
                    ans++;
                }

                seen.add(neighbor);
                ans += dfs(neighbor);
            }
        }
        
        return ans;
    }

    public String convertToHash(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }
}
