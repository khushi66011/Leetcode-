class Solution {

    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];

        return solve(0, 0, s, p, dp);
    }

    private boolean solve(int i, int j, String s, String p, Boolean[][] dp) {

        // If pattern is finished
        if (j == p.length()) {
            return i == s.length();
        }

        // Already computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Check if current characters match
        boolean match = (i < s.length()) &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // If next character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            dp[i][j] = solve(i, j + 2, s, p, dp) ||   // Ignore x*
                       (match && solve(i + 1, j, s, p, dp)); // Use x*

            return dp[i][j];
        }

        // Normal character match
        if (match) {
            dp[i][j] = solve(i + 1, j + 1, s, p, dp);
        } else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }
}