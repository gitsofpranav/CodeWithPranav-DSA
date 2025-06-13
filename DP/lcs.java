class Solution {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Match → add 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Not match → max of top/left
                }
            }
        }

        return dp[n][m];
    }
}
