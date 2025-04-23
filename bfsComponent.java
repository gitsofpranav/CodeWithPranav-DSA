import java.util.*;

public class bfsComponent {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    //Component BFS CODE...
    public static void bfs(ArrayList<Edge> []graph){
        boolean []vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph, vis,i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> []graph,  boolean []vis,int start){
        Queue<Integer> q = new LinkedList<>();
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

        bfs(graph);
    }
}
