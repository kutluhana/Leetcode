import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>(n);
            for (int val : row) list.add(val);
            rowMap.put(list, rowMap.getOrDefault(list, 0) + 1);
        }

        int count = 0;
        for (int c = 0; c < n; c++) {
            List<Integer> col = new ArrayList<>(n);
            for (int r = 0; r < n; r++) col.add(grid[r][c]);
            count += rowMap.getOrDefault(col, 0);
        }

        return count;
    }
}