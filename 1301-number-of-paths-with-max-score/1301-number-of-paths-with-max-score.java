class Solution {

    static final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        // Initialize score with -1 (unreachable)
        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        // Start from 'S'
        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        // Traverse from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                // Skip obstacle
                if (ch == 'X')
                    continue;

                // Skip starting cell
                if (i == n - 1 && j == n - 1)
                    continue;

                int bestScore = -1;
                int pathCount = 0;

                // Down
                if (i + 1 < n && score[i + 1][j] != -1) {

                    if (score[i + 1][j] > bestScore) {
                        bestScore = score[i + 1][j];
                        pathCount = ways[i + 1][j];
                    } else if (score[i + 1][j] == bestScore) {
                        pathCount = (pathCount + ways[i + 1][j]) % MOD;
                    }
                }

                // Right
                if (j + 1 < n && score[i][j + 1] != -1) {

                    if (score[i][j + 1] > bestScore) {
                        bestScore = score[i][j + 1];
                        pathCount = ways[i][j + 1];
                    } else if (score[i][j + 1] == bestScore) {
                        pathCount = (pathCount + ways[i][j + 1]) % MOD;
                    }
                }

                // Diagonal
                if (i + 1 < n && j + 1 < n && score[i + 1][j + 1] != -1) {

                    if (score[i + 1][j + 1] > bestScore) {
                        bestScore = score[i + 1][j + 1];
                        pathCount = ways[i + 1][j + 1];
                    } else if (score[i + 1][j + 1] == bestScore) {
                        pathCount = (pathCount + ways[i + 1][j + 1]) % MOD;
                    }
                }

                if (bestScore == -1)
                    continue;

                int value = 0;

                if (Character.isDigit(ch))
                    value = ch - '0';

                score[i][j] = bestScore + value;
                ways[i][j] = pathCount;
            }
        }

        if (ways[0][0] == 0)
            return new int[] {0, 0};

        return new int[] {score[0][0], ways[0][0]};
    }
}