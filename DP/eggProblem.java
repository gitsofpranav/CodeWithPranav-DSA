public class eggProblem {
    static int [][]dp;
    public static int solve(int e, int f){
        if(f == 0 || f == 1) return f;
        if(e==0 || e==1) return f;
        if(dp[e][f] != -1){
            return dp[e][f];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int temp = 1 + Math.max(solve(e-1, k-1), solve(e, f-k));
            ans = Math.min(ans,temp);
        }
        return dp[e][f] = ans;
    }
    public static void main(String[] args) {
        int e = 3;
        int f = 5;
        dp = new int[e+1][f+1];
        for(int i=0; i<e+1; i++){
            for(int j=0; j<f+1; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(e, f));
    }
}
