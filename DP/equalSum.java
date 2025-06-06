public class equalSum{
    public static boolean isEqualPartition(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }

        if(sum % 2 != 0){
            return false;
        } else {
            return isSubsetSum(arr, n, sum/2);
        }
    }
     static boolean [][]dp;
    public static boolean isSubsetSum(int arr[], int n, int sum){
        dp = new boolean[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dp[i][j] = false;
                }
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
             if (arr[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int [] arr = {1,5,11,5};
        System.out.println(isEqualPartition(arr));
    }
}