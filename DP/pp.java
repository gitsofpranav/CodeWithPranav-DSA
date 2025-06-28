public class pp {
    static int dp[][];
    static int left;
    static int right;
    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static int solve(String s, int i, int j){
        if(i>j) return 0;
        int ans = Integer.MAX_VALUE;
        if(isPalindrome(s, i, j)){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int k=i; k<j; k++){

             int left = (dp[i][k] != -1) ? dp[i][k] : solve(s, i, k);
            dp[i][k] = left;

             int right = (dp[k+1][j] != -1) ? dp[k+1][j] : solve(s, k+1, j);
            dp[k+1][j] = right;


            int temp = left + right + 1;
            ans = Math.min(ans, temp);
        }
        return  dp[i][j] = ans;
    }
    public static void main(String[] args) {
        String s = "nitinab";
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(s, 0, s.length()-1));
    }
}
