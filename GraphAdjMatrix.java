import java.util.Iterator;
import java.util.LinkedList; 


public class GraphAdjMatrix implements Graph {
	int[][] edges;
	int numEdges = 0;

	public GraphAdjMatrix(int size) {
		// TODO Auto-generated constructor stub
		edges = new int[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				edges[i][j] = -1;
			}
		}
	}
    public class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		
	}
	
	public void topologicalSort() {
		// TODO Auto-generated method stub
		
	}

	public void addEdge(int v1, int v2, int weight) {
		// TODO Auto-generated method stub
		edges[v1][v2] = weight;
		numEdges++;
	}

	public int getEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		return edges[v1][v2];
	}

	public int createSpanningTree() {
		// TODO Auto-generated method stub
		int numVertices = edges.length;
		LinkedList<Edge> MSTlist = new LinkedList<Edge>();
		Edge[] allEdges = new Edge[numEdges];
		int count = 0;
		int totalWeight = 0;
		for(int i = 0; i < numVertices; i++){
			for(int j = 0; j < numVertices; j++){
				int curr = getEdge(i,j);
				if(curr > 0){
					int k = count-1;
					while(k >= 0 && allEdges[k].weight > curr){
						allEdges[k+1] = allEdges[k];
						k--;
					}
					allEdges[k+1] = new Edge(i, j, curr);
					count++;
				}
			}
		}
		
		DisjointSet ds = new DisjointSet();
		ds.createSets(numVertices);
		int z = 0;
		while(MSTlist.size() < numVertices - 1){
			Edge nextEdge = allEdges[z++];
			
			int x = ds.find(nextEdge.src);
			int y = ds.find(nextEdge.dest);
			
			if(x != y){
				MSTlist.add(nextEdge);
				totalWeight += nextEdge.weight;
				ds.union(x, y);
			}
		}
		int i = 0;
		while(i < MSTlist.size()){
			System.out.println(MSTlist.get(i).src + " to " + MSTlist.get(i).dest + " with a cost of " + MSTlist.get(i++).weight);
		}
		
		return totalWeight;
	}
}
