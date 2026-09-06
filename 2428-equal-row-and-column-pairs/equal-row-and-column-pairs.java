import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int matrixSize = grid.length;
        Map<String, Integer> rowFrequencyMap = new HashMap<>();

        for (int[] currentRow : grid) {
            String rowPattern = Arrays.toString(currentRow);
            rowFrequencyMap.put(rowPattern, rowFrequencyMap.getOrDefault(rowPattern, 0) + 1);
        }

        int matchingPairCount = 0;

        for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
            int[] currentColumn = extractColumn(grid, colIndex, matrixSize);
            String columnPattern = Arrays.toString(currentColumn);

            matchingPairCount += rowFrequencyMap.getOrDefault(columnPattern, 0);
        }

        return matchingPairCount;
    }

    private int[] extractColumn(int[][] grid, int colIndex, int matrixSize) {
        int[] column = new int[matrixSize];
        for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
            column[rowIndex] = grid[rowIndex][colIndex];
        }
        return column;
    }
}
