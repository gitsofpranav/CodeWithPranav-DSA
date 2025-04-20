import java.util.*;
public class bfs{
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

// CODE for Normal BFS...
    public static void bfs(ArrayList<Edge> []graph, int start){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;


                for(Edge e : graph[curr]){
                        q.add(e.dest);  
                }
            }
        }
    }
    public static void main(String[] args) {
         int V = 5;
        boolean vis[] = new boolean[V];
        ArrayList<Edge> []graph =new ArrayList[V];
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4, 2));

        bfs(graph, 0);
    }
}