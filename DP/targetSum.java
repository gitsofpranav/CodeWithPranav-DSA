public class targetSum {
    static Boolean dp[][];
    static boolean dpp[][];
    public static boolean isPresent(int []arr, int size, int sum){
        if(sum == 0) return true;
        if(size == 0) return false;

        if(dp[size][sum] != null){
            return dp[size][sum];
        }
        //ye wo case hai jisme hum include kr v sakte hai ya nhi v kr skte hai
        if(arr[size-1] <= sum){
            return dp[size][sum] = isPresent(arr, size-1, sum-arr[size-1]) || isPresent(arr, size-1, sum);
        }else { // exclude wala case;
           return dp[size][sum] = isPresent(arr, size-1, sum);
        }

    }

// tabulation...
       public static boolean isPresent2(int []arr, int size, int sum){
        dpp = new boolean[size+1][sum+1];
        for(int i=0; i<size+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dpp[i][j] = false;
                }
                if(j==0){
                    dpp[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= size; i++) {
        for (int j = 1; j <= sum; j++) {
            if (arr[i - 1] <= j) {
                dpp[i][j] = dpp[i - 1][j - arr[i - 1]] || dpp[i - 1][j];
            } else {
                dpp[i][j] = dpp[i - 1][j];
            }
        }
    }

    return dpp[size][sum];

    }
    public static void main(String[] args) {
        int [] arr = {2,3,7,8,10};
        int sum = 11;
        int size = arr.length;
        dp = new Boolean[size+1][sum+1];
        dpp = new boolean[size+1][sum+1];

        System.out.println(isPresent(arr, size, sum));
        System.out.println(isPresent2(arr, size, sum));
    }
}
    