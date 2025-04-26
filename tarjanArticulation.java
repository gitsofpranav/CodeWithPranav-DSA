import java.util.*;
public class tarjanArticulation {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph, int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }
    public static void dfs(ArrayList<Edge>[]graph,int curr , int par, boolean [] vis, int dt[],int low[],int time, boolean []ap){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for(Edge e : graph[curr]){
            if(e.dest == par){
                continue;
            }else if(vis[e.dest]){
                low[curr] = Math.min(low[curr] , dt[e.dest]);
            } else if(!vis[e.dest]){
                dfs(graph, e.dest, curr, vis, dt, low, time,ap);
                low[curr] = Math.min(low[curr],low[e.dest]);
                if(par != -1 && dt[curr] <= low[e.dest]){
                   ap[curr] = true;
                }
                children++;
            }
        }

        if(par == -1 && children >1){
            ap[curr] = true;
        }
     }

    public static void getArticulation(ArrayList<Edge>[]graph, int V){
        int dt[] = new int[V];
        int low[]  = new int[V];
        int time  = 0;
        boolean []vis = new boolean[V];
        boolean []ap = new boolean[V];
        

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph, i, -1, vis, dt, low, time,ap);
            }
        }


        for(int i=0; i<V; i++){
            if(ap[i]){
                System.out.println("AP : " +i);
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[]graph = new ArrayList[V];
        createGraph(graph, V);
        getArticulation(graph, V);
    }
}
