package com.netjstech.graph;

public class WeightedGraphAdjMatrix {
	private int vertices;
	private int[][] adjMAtrix;
	public WeightedGraphAdjMatrix(int vertices){
		this.vertices = vertices;
		adjMAtrix = new int[vertices][vertices];
	}
	
	public void addEdge(int source, int destination, int weight) {
		if((source < 0 || source >= vertices) || (destination < 0 || destination >= vertices)) {
			System.out.println("Invalid edge addition");
			return;
		}
		adjMAtrix[source][destination] = weight;
		// For undirected graph (For directed graph comment this line)
		//adjMAtrix[destination][source] = weight;
	}
	
	public void displayGraph() {
		for(int i = 0; i < vertices; i++) {
			for(int j= 0; j < vertices; j++) {
				System.out.print(adjMAtrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		WeightedGraphAdjMatrix graph = new WeightedGraphAdjMatrix(5);
		graph.addEdge(0, 1, 5); // A-B
		graph.addEdge(0, 2, 10); //A-C
		graph.addEdge(0, 4, 7); //A-E
		graph.addEdge(2, 3, 15); //C-D
		graph.addEdge(3, 4, 8); //D-E
		graph.displayGraph();

	}

}
