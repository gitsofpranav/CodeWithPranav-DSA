import java.util.List;
    class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        dfs(rooms,vis,0);

        for(boolean v : vis){
            if(!v){
                return false;
            }
        }
        return true;

    }

    public static void dfs(List<List<Integer>> rooms,boolean vis[],int curr){
        vis[curr] = true;

        for(int key:rooms.get(curr)){
            if(!vis[key]){
                dfs(rooms,vis,key);
            }
        }
    }
}

