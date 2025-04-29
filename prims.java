import java.util.*;
public class prims {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> []graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        //vertex 1
        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 0, 10));

        //vertex 2
        graph[2].add(new Edge(2, 3, 50));
        graph[2].add(new Edge(2, 0, 15));

        //vertex 3
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;
        Pair(int v, int c){
            this.vertex = v;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void prims_algo(ArrayList<Edge> []graph,int src){
        boolean [] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(!vis[curr.vertex]){
                vis[curr.vertex] = true;
                finalCost += curr.cost;
                for(Edge e: graph[curr.vertex]){
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                    
                }
            }
        }
        System.out.println("Final cost of MST :" + finalCost);

    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> []graph = new ArrayList[V];
        createGraph(graph);
        prims_algo(graph, 0);
    }
}

