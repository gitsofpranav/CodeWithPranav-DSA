public class targetSum {
    static Boolean dp[][];
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
    public static void main(String[] args) {
        int [] arr = {2,3,7,8,10};
        int sum = 31;
        int size = arr.length;
        dp = new Boolean[size+1][sum+1];

        System.out.println(isPresent(arr, size, sum));
    }
}
    