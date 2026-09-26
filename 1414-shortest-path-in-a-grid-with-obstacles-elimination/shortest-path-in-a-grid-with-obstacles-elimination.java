class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = Integer.MAX_VALUE;
        int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1}};

        if (k >= m + n - 3) {
            return m + n - 2;
        }

        boolean[][][] seen = new boolean[m][n][k + 1];
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.offer(List.of(0, 0, 0, k));
        seen[0][0][k] = true;

        while(!queue.isEmpty()) {
            List<Integer> list = queue.remove();

            Integer row = list.get(0);
            Integer col = list.get(1);
            Integer depth = list.get(2);
            Integer kLeft = list.get(3);

            if(row == m - 1 && col == n - 1) {
                answer = Math.min(answer, depth);
                return depth;
            }
            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && seen[newRow][newCol][kLeft] == false) {
                    if(grid[newRow][newCol] == 1 && kLeft > 0) {
                        seen[newRow][newCol][kLeft - 1] = true;
                        queue.offer(List.of(newRow, newCol, depth + 1, kLeft - 1));
                    } else if(grid[newRow][newCol] == 0) {
                        seen[newRow][newCol][kLeft] = true;
                        queue.offer(List.of(newRow, newCol, depth + 1, kLeft));
                    }
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}