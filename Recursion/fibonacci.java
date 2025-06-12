public class fibonacci {
     static int []dp;
    public static int fibonacciSum(int n){
        if(n==0 || n == 1){
            return n;
        }
        dp = new int[n+1];
        for(int i=0; i<n+1; i++){
            dp[i] = -1;
        }


        for(int i=0; i<n+1; i++){
            if(dp[i] != -1){
            return dp[i];
            }else {
                return dp[i] =  fibonacciSum(n-1) + fibonacciSum(n-2);
            }


        }       
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 20;
        System.out.println(fibonacciSum(n));
    }
}
