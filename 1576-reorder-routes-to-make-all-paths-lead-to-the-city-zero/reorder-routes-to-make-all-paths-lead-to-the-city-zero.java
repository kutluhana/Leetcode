class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    Set<String> roads = new HashSet<>();
    int answer = 0;

    public int minReorder(int n, int[][] connections) {
        
        for(int i = 0; i < connections.length; i++) {
            List<Integer> list1 = map.getOrDefault(connections[i][0], new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(connections[i][1], new ArrayList<>());

            list1.add(connections[i][1]);
            list2.add(connections[i][0]);

            map.put(connections[i][0], list1);
            map.put(connections[i][1], list2);
            roads.add(convertToHash(connections[i][0], connections[i][1]));
        }

        dfs(0);

        return answer;
    }

    void dfs(int city) {
        if(set.contains(city)) {
            return;
        }

        set.add(city);

        for(Integer connected : map.get(city)) {
            if (!set.contains(connected) && roads.contains(convertToHash(city, connected))) {
                answer++;
            }
            dfs(connected);
        }
    }

    public String convertToHash(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }


}