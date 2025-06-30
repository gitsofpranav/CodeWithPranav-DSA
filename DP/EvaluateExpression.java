public class EvaluateExpression {
    public static int solve(String s, int i, int j, boolean isTrue){
        if (i > j) return 0;
        if (i == j){
            if (isTrue) return s.charAt(i) == 't' ? 1 : 0;
            else return s.charAt(i) == 'f' ? 1 : 0;
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lt = solve(s, i, k - 1, true);
            int lf = solve(s, i, k - 1, false);
            int rt = solve(s, k + 1, j, true);
            int rf = solve(s, k + 1, j, false);

            char op = s.charAt(k);

            if (op == '&') {
                if (isTrue) ans += lt * rt;
                else ans += lf * rt + lt * rf + lf * rf;
            } else if (op == '|') {
                if (isTrue) ans += lt * rt + lt * rf + lf * rt;
                else ans += lf * rf;
            } else if (op == '^') {
                if (isTrue) ans += lt * rf + lf * rt;
                else ans += lt * rt + lf * rf;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "t|f&t^t";
        int ways = solve(s, 0, s.length() - 1, true);
        System.out.println("Ways to evaluate to true: " + ways);
    }
}


