public class minimumNumber {
    static int dp[][];
      public static int minInsertions(String s) {
        String b = new StringBuilder(s).reverse().toString();
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(s.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[n][n];
    }
    public static void main(String[] args) {
        String s = "aebcbda";
        System.out.println(minInsertions(s));
    }
}
