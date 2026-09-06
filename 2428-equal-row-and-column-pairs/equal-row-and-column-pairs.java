class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int c = 0; c < n; c++) {
            int[] col = new int[n];
            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }

            for (int r = 0; r < n; r++) {
                if (Arrays.equals(grid[r], col)) {
                    count++;
                }
            }
        }

        return count;
    }
}