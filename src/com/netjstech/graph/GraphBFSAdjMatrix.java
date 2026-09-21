package com.netjstech.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph BFS traversal Adjacency matrix representation
 * 
 */
public class GraphBFSAdjMatrix {
	private int numOfVertices;
	private int[][] adjMatrix;
	private boolean[] visited;
	// If want to show labels and using the Vertex as a separate class
	private Vertex[] vertices;
	int col;
	
	public GraphBFSAdjMatrix(int numOfVertices){
		this.numOfVertices = numOfVertices;
		this.adjMatrix = new int[numOfVertices][numOfVertices];
		this.visited = new boolean[numOfVertices];
		this.vertices = new Vertex[numOfVertices];
		this.col = 0;
	}
	
	public void addVertex(String label) {
		this.vertices[col++] = new Vertex(label);
	}
	
	public void addEdge(int source, int destination) {
	    if((source < 0 || source > numOfVertices) || (destination < 0 || destination > numOfVertices)) {
	      System.out.println("Invalid edge addition");
	      return;
	    }
	    adjMatrix[source][destination] = 1;
	    // For undirected graph reverse setting also required
	    adjMatrix[destination][source] = 1;
	}
	
	public void displayGraph() {
		for(int i = 0; i < adjMatrix.length; i++) {
	      for(int j = 0; j < adjMatrix[0].length; j++) {
	        System.out.print(adjMatrix[i][j] + " ");
	      }
	      System.out.println();
	    }
	}
	
	public void bfsTraversal(int startVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startVertex);
		//visited[startVertex] = true;
		vertices[startVertex].setVisited(true);
		while(!queue.isEmpty()) {
			int currentVertex = queue.poll();
			System.out.print(vertices[currentVertex].getLabel() + " ");
			for(int i = 0; i < adjMatrix.length; i++) {
				if(adjMatrix[currentVertex][i] == 1 && !vertices[i].isVisited()) {
					queue.add(i);
					//visited[i] = true;
					vertices[i].setVisited(true);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		GraphBFSAdjMatrix graph = new GraphBFSAdjMatrix(10);
	    
	    graph.addVertex("A");
	    graph.addVertex("B");
	    graph.addVertex("C");
	    graph.addVertex("D");
	    graph.addVertex("E");
	    graph.addVertex("F");
	    graph.addVertex("G");
	    graph.addVertex("H");
	    graph.addVertex("I");
	    graph.addVertex("J");
	    
	    graph.addEdge(0, 1); //A-B
	    graph.addEdge(0, 2); //A-C
	    graph.addEdge(0, 3); //A-D
	    graph.addEdge(0, 4); //A-E
	    graph.addEdge(1, 5); //B-F
	    graph.addEdge(5, 8); //F-I
	    graph.addEdge(2, 6); //C-G
	    graph.addEdge(4, 7); //E-H
	    graph.addEdge(7, 9); //H-J

	    graph.displayGraph();
	    System.out.println("Graph Traversal - BFS");
	    graph.bfsTraversal(0);
	    
	}
}
