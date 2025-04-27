class Solution {
    public int findJudge(int n, int[][] trust) {
        int len = trust.length;
        int []Deg = new int[n+1];


        for(int i=0; i<len; i++){
            Deg[trust[i][1]]++;
            Deg[trust[i][0]]--; 
        }
        for(int i=1; i<=n; i++){
            if(Deg[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}