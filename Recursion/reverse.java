public class reverse {
    public static int reverseNumber(int n, int rev){
        if(n == 0){
            return rev;
        }

        return reverseNumber(n/10, rev*10 + n%10);
    }
    public static void main(String[] args) {
        int n = 1245;
        System.out.println(reverseNumber(n, 0));
    }
}
