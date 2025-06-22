public class scommons {
    static int [][]dp;
    public static String suberComSeq(String a, String b){
        int n = a.length();
        int m = b.length();
        dp =new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                     dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int i = n, j=m;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j> 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(a.charAt(i-1));
                i--;
            }else {
                sb.append(b.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            sb.append(a.charAt(i-1));
            i--;
        }

        while(j>0){
            sb.append(a.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "acbcf";
        String b = "abcdaf";
        System.out.println(suberComSeq(a, b));
    }
}
