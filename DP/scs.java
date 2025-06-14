public class scs {
    static int[][] dp;

    public static String shortestCommonSuperSequence(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        dp = new int[n+1][m+1];

        // Build the LCS dp table
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Build the SCS using the dp table
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(s1.charAt(i-1));
                i--;
            } else {
                sb.append(s2.charAt(j-1));
                j--;
            }
        }

        // Append remaining characters
        while(i > 0){
            sb.append(s1.charAt(i-1));
            i--;
        }

        while(j > 0){
            sb.append(s2.charAt(j-1));
            j--;
        }

        // Since we built it from the end, reverse it before returning
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        String result = shortestCommonSuperSequence(s1, s2);
        System.out.println("Shortest Common Supersequence: " + result);
    }
}
