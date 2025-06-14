public class lcString {
    static int dp[][];
    public static int longestString(String x, String y, int n, int m){
        char []a = x.toCharArray();
        char []b = y.toCharArray();
        dp = new int[n+1][m+1];
        int maxLen = 0;
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(a[i-1] == b[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String x = "abcde";
        String y = "abfce";
        int n = x.length();
        int m = y.length();
        System.out.println(longestString(x, y, n, m));
    }
}
