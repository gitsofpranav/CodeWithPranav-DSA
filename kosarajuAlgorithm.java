import java.util.*;
public class kosarajuAlgorithm  {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 1));
        graph[1].add(new Edge(1, 0));
        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 4));

    }
    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");
    
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }
    
    public static void kosarajuAlo( ArrayList<Edge> [] graph, int V){
        Stack<Integer> st = new Stack<>();
        boolean []vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                topoSort(graph, i, st, vis);
            }
        }

        //setp2
        ArrayList<Edge> []transpose = new ArrayList[V];
        for(int i=0; i<V; i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step 3
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                System.out.print("SCC ->");
                dfs(transpose, vis, curr);
                System.out.println();
            }
        }
    }

    public static void topoSort( ArrayList<Edge> [] graph,int curr, Stack<Integer> st, boolean []vis){
        vis[curr] = true;
        for(Edge e : graph[curr]){
            if(!vis[e.dest]){
                topoSort(graph, e.dest, st, vis);
            }
        }
        st.push(curr);
       
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        kosarajuAlo(graph,V);
    }
}


