public class seqMatching {
    static int dp[][];
    public static boolean patternMatching(String a, String b){
        int n = a.length();
        int m = b.length();
        
        dp = new int[n+1][m+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m] == a.length();

    }
    public static void main(String[] args) {
        String a = "AXY";
        String b = "ADXCPY";
        System.out.println(patternMatching(a, b));
    }
}
