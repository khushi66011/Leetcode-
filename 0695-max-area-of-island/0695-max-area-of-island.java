class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int maxi = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area = bfs(i, j, grid, vis);
                    maxi = Math.max(maxi, area);
                }
            }
        }

        return maxi;
    }

    public int bfs(int row, int col, int[][] grid, boolean[][] vis) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{row, col});
        vis[row][col] = true;

        int area = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            area++;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 1 &&
                    !vis[nr][nc]) {

                    q.add(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

        return area;
    }
}
