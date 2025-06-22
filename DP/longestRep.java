public class longestRep {
    static int [][]dp;
    public static int LRS(String s){
        String b = new String(s);
        int n = s.length();
        int m = b.length();

        dp = new int[n+1][m+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1) == b.charAt(j-1) && i != j){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];

    }
    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println(LRS(s));
    }
}
