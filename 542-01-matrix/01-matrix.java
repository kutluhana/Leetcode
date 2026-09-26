class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] matrix = new int[m][n];
        boolean[][] seen = new boolean[m][n];

        Queue<List<Integer>> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(List.of(i, j, 0));
                    seen[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            List<Integer> list = queue.remove();

            Integer row = list.get(0);
            Integer col = list.get(1);
            Integer depth = list.get(2);

            for(int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if(0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n && seen[nextRow][nextCol] == false) {
                    seen[nextRow][nextCol] = true;
                    matrix[nextRow][nextCol] = depth + 1;
                    queue.offer(List.of(nextRow, nextCol, depth + 1));
                }
            }
        }

        return matrix;
    }
}