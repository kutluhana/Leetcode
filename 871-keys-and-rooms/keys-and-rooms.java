class Solution {

    Set<Integer> seen = new HashSet<>();
    Set<Integer> keys = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(0, rooms);

        return seen.size() == rooms.size();
    }

    void dfs(Integer room, List<List<Integer>> rooms) {

        if(seen.contains(room)) {
            return;
        }

        seen.add(room);

        for(Integer key : rooms.get(room)) {
            keys.add(key);
            dfs(key, rooms);
        }


    }
}