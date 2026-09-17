class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[i].length; j++) {
                map.putIfAbsent(i, new ArrayList<>());
                if (isConnected[i][j] == 1) {
                    map.get(i).add(j);
                }
            }
        }
        
        int count = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(!set.contains(entry.getKey())) {
                count++;
                dfs(entry.getKey());
            }
            
        }
        return count;
    }

    void dfs(Integer city) {
        if(set.contains(city)) {
            return;
        }
        set.add(city);

        for(Integer connection : map.get(city)) {
            dfs(connection);
        }
    }
}