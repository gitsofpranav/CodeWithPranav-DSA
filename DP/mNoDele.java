public class mNoDele {
    static int [][]dp;
    public static int minimumNumOfdeletion(String s){
        String b =new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = s.length();
        dp = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return m-dp[n][m];

    }
    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(minimumNumOfdeletion(s));
    }
}
