public class printLCString {
    static int dp[][];

    public static String printLongestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int maxLen = 0;
        int endIndex = -1;

        dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s1.substring(endIndex - maxLen, endIndex);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        System.out.println(printLongestCommonSubstring(s1, s2));
    }
}
