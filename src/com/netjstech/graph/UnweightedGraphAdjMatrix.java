package com.netjstech.graph;

public class UnweightedGraphAdjMatrix {
	private int vertices;
	private int[][] adjMatrix;
	public UnweightedGraphAdjMatrix(int vertices) {
		this.vertices = vertices;
		adjMatrix = new int[vertices][vertices];
	}
	
	// For adding an edge
	public void addEdge(int source, int destination) {
		if((source < 0 || source >= vertices) || (destination < 0 || destination >= vertices)){
			System.out.println("Invalid edge addition");
			return;
		}
		adjMatrix[source][destination] = 1;
		// For undirected graph (For directed graph comment it)
		//adjMatrix[destination][source] = 1;
	}
	
	// displaying adj matrix
	public void displayGraph() {
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j< vertices; j++) {
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		UnweightedGraphAdjMatrix obj = new UnweightedGraphAdjMatrix(5);
		obj.addEdge(0, 1); // A-B
		obj.addEdge(0, 2); // A-C
		obj.addEdge(0, 4); // A-E
		obj.addEdge(2, 3); // C-D
		obj.addEdge(3, 4); //D-E
		obj.displayGraph();

	}

}
