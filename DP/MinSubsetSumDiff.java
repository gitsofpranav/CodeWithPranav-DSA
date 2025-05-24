public class MinSubsetSumDiff {
    static boolean[][] dp;

    public static boolean isSubsetSum(int arr[], int n, int sum){
        dp = new boolean[n+1][sum+1];

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < sum + 1; j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                if(j == 0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static int minSubsetSumDifference(int[] arr, int n){
        int totalSum = 0;
        for(int num : arr) totalSum += num;


        isSubsetSum(arr, n, totalSum);

        int minDiff = Integer.MAX_VALUE;

        for(int s1 = 0; s1 <= totalSum / 2; s1++){
            if(dp[n][s1]){
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }

        return minDiff;
    }

    public static void main(String[] args){
        int[] arr = {1, 6, 11, 5};
        int n = arr.length;
        System.out.println("Minimum Subset Sum Difference: " + minSubsetSumDifference(arr, n));
    }
}
