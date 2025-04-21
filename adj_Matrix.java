public class adj_Matrix {
        // Static class to represent edges and adjacency matrix
        static class Edge {
            int[][] adjMatrix;
            int vertex;
    
            // Constructor to initialize adjacency matrix based on vertex count
            Edge(int v) {
                this.vertex = v;
                adjMatrix = new int[v][v];
            }
    
            // Method to add edge between two vertices
            public void addEdge(int i, int j) {
                adjMatrix[i][j] = 1;
                adjMatrix[j][i] = 1; // for undirected graph
            }
    
            // Method to print adjacency matrix
            public void printMatrix() {
                System.out.println("Adjacency Matrix:");
                for (int i = 0; i < vertex; i++) {
                    for (int j = 0; j < vertex; j++) {
                        System.out.print(adjMatrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    
        public static void main(String[] args) {
            // Create an object of Edge class with number of vertices
            Edge graph = new Edge(4);  // Let's assume 4 vertices
            
            // Add edges between the vertices
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
    
            // Print the adjacency matrix
            graph.printMatrix();
        }
    
    
}
