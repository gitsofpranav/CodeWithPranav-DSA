public class fibonacci {
    public static int fibonacciSum(int n){
        if(n==0 || n == 1){
            return n;
        }

        return fibonacciSum(n-1) + fibonacciSum(n-2);
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibonacciSum(n));
    }
}
