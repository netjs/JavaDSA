package com.netjstech.graph;

public class GraphDSAdjMatrix {
	private int vertices;
	private int[][] adjMatrix;
	
	GraphDSAdjMatrix(int vertices){
		this.vertices = vertices;
		adjMatrix = new int[vertices][vertices];
	}
	
	public void addEdge(int source, int destination) {
		if((source < 0 || source >= vertices) || (destination < 0 || destination >= vertices)) {
			System.out.println("Invalid edge addition");
			return;
		}
		adjMatrix[source][destination] = 1;
		// for undirected graph (comment for directed graph)
		adjMatrix[destination][source] = 1;
	}
	
	public void removeEdge(int source, int destination) {
		if((source < 0 || source >= vertices) || (destination < 0 || destination >= vertices)) {
			System.out.println("Invalid edge addition");
			return;
		}
		adjMatrix[source][destination] = 0;
		// for undirected graph (comment for directed graph)
		adjMatrix[destination][source] = 0;
	}
	
	// adding a vertex to a graph
	public void addVertex() {
		int changedSize = vertices + 1;
		int[][] changedMatrix = new int[changedSize][changedSize];
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < vertices; j++) {
				changedMatrix[i][j] = adjMatrix[i][j];
			}
		}
		this.adjMatrix = changedMatrix;
		this.vertices = changedSize;
	}
	
	public void removeVertex(int v) {
		if(v < 0 || v >=vertices) {
			System.out.println("Invalid vertex removal");
			return;
		}
		int changedSize = vertices - 1;
		int[][] changedMatrix = new int[changedSize][changedSize];
		int tempRow = 0;
		for(int i = 0; i < vertices; i++) {
			if(i == v)
				continue;
			int tempCol = 0;
			for(int j = 0; j < vertices; j++) {
				if(j == v)
					continue;
				changedMatrix[tempRow][tempCol] = adjMatrix[i][j];
				tempCol++;
			}
			tempRow++;
		}
		this.adjMatrix = changedMatrix;
		this.vertices = changedSize;
	}
	public void displayGraph() {
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < vertices; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		GraphDSAdjMatrix graph = new GraphDSAdjMatrix(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.displayGraph();
		System.out.println("After adding a vertex");
		graph.addVertex();
		graph.addEdge(3, 5);
		graph.displayGraph();
		System.out.println("After removing a edge");
		graph.removeEdge(3, 5);
		graph.displayGraph();
		System.out.println("After removing a vertex");
		graph.removeVertex(3);
		graph.displayGraph();
		
	}

}
