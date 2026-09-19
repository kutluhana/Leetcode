class Solution {
    Queue<List<Integer>> queue = new LinkedList<>();
    int[][] dirs = {
    {-1, -1}, {-1, 0}, {-1, 1},
    { 0, -1},          { 0, 1},
    { 1, -1}, { 1, 0}, { 1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        
        grid[0][0] = 1;
        queue.offer(List.of(0, 0, 1));

        while(!queue.isEmpty()) {
            List<Integer> cell = queue.remove();

            int i = cell.get(0);
            int j = cell.get(1);
            int depth = cell.get(2);

            if(i == grid.length - 1 && j == grid.length - 1) {
                return depth;
            }

            for (int[] d : dirs) {
                int newi = i + d[0];
                int newj = j + d[1];

                if (newi >= 0 && newi < grid.length && newj >= 0 && newj < grid.length && grid[newi][newj] == 0) {
                    grid[newi][newj] = 1;
                    queue.offer(List.of(newi, newj, depth + 1));
                }
            }
            
        }

        return -1;

    }
}