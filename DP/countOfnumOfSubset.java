public class countOfnumOfSubset {
    static int [][]dp;
    public static int Subset(int []arr, int sum){
        int n = arr.length;
        dp = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dp[i][j] = 0;
                }

                if(j==0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                     dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];

    }

    public static int countOfSubset(int [] arr, int diff){
        int sum = 0;
        for(int a : arr){
            sum += a;
        }

        int s1 = (diff + sum)/2;
        return Subset(arr, s1);
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,3};

        int diff = 1;
        System.out.println(countOfSubset(arr, diff));
    
    }
}
