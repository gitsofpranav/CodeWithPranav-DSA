public class rodCutting {
    static int [][]dp;
    public static int rodCutting_profit(int []length, int [] price, int N){
        int n = price.length;
        dp = new int[n+1][N+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<N+1; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][N];

    }
    public static void main(String[] args) {
        int []length = {1,2,3,4,5,6,7,8};
        int []price  = {1,5,8,9,10,17,17,20};
        int N = 8;
        System.out.println(rodCutting_profit(length, price, N));
    }
}
