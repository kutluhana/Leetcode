class Solution {
    int answer = 0;
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                dfs(i, j, grid);
                count = 0;
            }
        }

        return answer;
    }

    void dfs(int i, int j, int[][] grid) {
        if(grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        count++;

        if(i + 1 < grid.length) {
            dfs(i + 1, j, grid);
        }
        if(j + 1 < grid[i].length) {
            dfs(i, j + 1, grid);
        }

        if(i - 1 >= 0) {
            dfs(i - 1, j, grid);
        }
        if(j - 1 >= 0) {
            dfs(i, j - 1, grid);
        }

        answer = Math.max(count, answer);
        
    }
}