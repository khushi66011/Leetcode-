class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        // Already same color
        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    public void dfs(int[][] image, int r, int c,
                    int original, int color) {

        int m = image.length;
        int n = image[0].length;

        // Boundary and color check
        if (r < 0 || r >= m || c < 0 || c >= n ||
            image[r][c] != original) {
            return;
        }

        // Change current pixel color
        image[r][c] = color;

        // Visit four directions
        dfs(image, r - 1, c, original, color); // Up
        dfs(image, r + 1, c, original, color); // Down
        dfs(image, r, c - 1, original, color); // Left
        dfs(image, r, c + 1, original, color); // Right
    }
}
