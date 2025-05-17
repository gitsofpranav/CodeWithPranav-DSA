import java.util.Arrays;

public class knapsack {
    static int[][] dp; 
  // memoization
    public static int knapsackProfit(int[] wt, int[] val, int n, int W) {
        // Initialize dp array
        dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        if(n == 0|| W == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if (wt[n - 1] <= W){
            return dp[n][W] = Math.max(val[n-1]+ knapsackProfit(wt, val, n-1, W-wt[n-1]), knapsackProfit(wt, val, n-1, W));
        } else if(wt[n-1] > W){
            return dp[n][W] = knapsackProfit(wt, val, n-1, W);
        }

        return 0;
        
    }

    //Tabulation
 public static int knapsackProfit2(int wt[], int val[], int n, int W){
    int[][] dp = new int[n + 1][W + 1];

    // Initialize base cases
    for(int i = 0; i <= n; i++){
        for(int j = 0; j <= W; j++){
            if(i == 0 || j == 0){
                dp[i][j] = 0;
            }
        }
    }

    // Build DP table
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= W; j++){
            if(wt[i - 1] <= j){
                dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[n][W];
}



    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;

        System.out.println("Maximum Profit = " + knapsackProfit(wt, val, n, W));
        System.out.println("maxProfit2 = " + knapsackProfit2(wt, val, n, W));
    }
}
