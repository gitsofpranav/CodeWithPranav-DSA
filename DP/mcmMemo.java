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
          dp = new int[1001][1001];
          for(int i=0; i<1001; i++){
            for(int j=0; j<1001; j++){
                dp[i][j] = -1;
            }
          }
        System.out.println(solve(arr, 1, arr.length-1));
    
    }
}
