class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<List<Integer>> queue = new LinkedList<>();

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int answer = Integer.MAX_VALUE;

        int m = maze.length;
        int n = maze[0].length;

        boolean[][] seen = new boolean[m][n];

        queue.offer(List.of(entrance[0], entrance[1], 0));
        seen[entrance[0]][entrance[1]] = true;

        while(!queue.isEmpty()) {
            List<Integer> list = queue.remove();

            int row = list.get(0);
            int col = list.get(1);
            int depth = list.get(2);

            if((row != entrance[0] ||col != entrance[1]) && (row == m - 1 ||row == 0 ||col == 0 ||col == n - 1)) {
                answer = Math.min(answer, depth);
            }

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.' && seen[newRow][newCol] == false) {
                    seen[newRow][newCol] = true;
                    queue.offer(List.of(newRow, newCol, depth + 1));
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;

        
    }
}