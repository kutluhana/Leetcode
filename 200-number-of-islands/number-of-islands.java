class Solution {
    public int numIslands(char[][] grid) {
        int[][] seen = new int[grid.length][grid[0].length];
        
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(seen[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(grid[i][j], seen, i, j, grid);
                }
            }
        }

        return count;
    }

    public void dfs(char island, int[][] seen, int i, int j, char[][] grid) {
        if(seen[i][j] == 1) {
            return;
        }


        seen[i][j] = 1;

        if(i + 1 < grid.length && grid[i + 1][j] == '1') {
            dfs(grid[i + 1][j], seen, i + 1, j, grid);
        }

        if(i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid[i - 1][j], seen, i - 1, j, grid);
        }

        if(j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            dfs(grid[i][j + 1], seen, i, j + 1, grid);
        }

        if(j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid[i][j - 1], seen, i, j - 1, grid);
        }
        
    }
}