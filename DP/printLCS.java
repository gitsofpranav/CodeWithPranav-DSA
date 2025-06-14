public class printLCS {
     static int dp[][];
    public static String longestString(String x, String y, int n, int m){
        char []a = x.toCharArray();
        char []b = y.toCharArray();
        dp = new int[n+1][m+1];
        int maxLen = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i=n, j=m;
       while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                sb.append(a[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String x = "abcde";
        String y = "abfce";
        int n = x.length();
        int m = y.length();
        System.out.println(longestString(x, y, n, m));
    }
}
