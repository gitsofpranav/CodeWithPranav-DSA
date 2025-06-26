public class mcmMemo {
    static int dp[][];
     public static int solve(int []arr, int i, int j){
        if(i>=j) {
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int tempAns = solve(arr, i, k) + solve(arr,k+1, j) + (arr[i-1] * arr[k] * arr[j]);
            if(tempAns < min){
                min = tempAns;
            }
        }
        return  dp[i][j] = min;
    }

    public static void main(String[] args) {
          int arr[] = {40,20,30,10,30};
          int n = arr.length;
           dp = new int[n+1][n+1];
          for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
          }
        System.out.println(solve(arr, 1, arr.length-1));
    
    }
}
