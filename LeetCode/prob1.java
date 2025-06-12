class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int []prefixSum = new int[n];
        int []left_candle = new int[n];
        int []right_candle = new int[n];

        prefixSum[0] = s.charAt(0) == '*' ? 1 : 0;
        left_candle[0] = s.charAt(0) == '|' ? 0 : -1;

        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + (s.charAt(i) == '*' ? 1 : 0);
            left_candle[i] = s.charAt(i) == '|' ? i : left_candle[i-1];
        }

        right_candle[n-1] = s.charAt(n-1) == '|' ? n-1 : n;
        for(int i=n-2; i>=0; i--){
            right_candle[i] = s.charAt(i) == '|' ? i: right_candle[i+1];
        }


        int []res = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int start = right_candle[queries[i][0]];
            int end = left_candle[queries[i][1]];


            res[i] =(start >= end) ? 0 : prefixSum[end] - prefixSum[start];
        }

        return res;
    }
}